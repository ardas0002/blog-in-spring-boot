package pl.ardas.bloginspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.ardas.bloginspringboot.exception.UserAlreadyExistException;
import pl.ardas.bloginspringboot.exception.VerificationTokenExpired;
import pl.ardas.bloginspringboot.model.User;
import pl.ardas.bloginspringboot.model.dto.UserDto;
import pl.ardas.bloginspringboot.register.EmailSenderService;
import pl.ardas.bloginspringboot.register.VerificationToken;
import pl.ardas.bloginspringboot.repository.UserRepository;
import pl.ardas.bloginspringboot.repository.UserRoleRepository;
import pl.ardas.bloginspringboot.repository.VerificationTokenRepository;

import java.util.Calendar;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final static String role = "ROLE_USER";
    private final VerificationTokenRepository verificationTokenRepository;
    private final EmailSenderService emailSenderService;

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder,
                       VerificationTokenRepository verificationTokenRepository, EmailSenderService emailSenderService){
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.verificationTokenRepository = verificationTokenRepository;
        this.emailSenderService = emailSenderService;
    }

    public void registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException {
        if(emailOrLoginExist(userDto.getEmail(), userDto.getLogin())){
            throw new UserAlreadyExistException();
        }
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(Set.of(userRoleRepository.findByRole(role)));
        user.setEnabled(false);
        User userToReturn = userRepository.save(user);
        sendVerificationToken(userToReturn);
    }

    public User confirmRegistration(String token){
        VerificationToken verificationToken = verificationTokenRepository.getByConfirmationToken(token);
        User user = verificationToken.getUser();
        Calendar calendar = Calendar.getInstance();

        if((verificationToken.getExpiryDate().getTime() - calendar.getTime().getTime()) <= 0){
           verificationTokenRepository.delete(verificationToken);
           return user;
        }else{
            user.setEnabled(true);
            verificationTokenRepository.delete(verificationToken);
            return userRepository.save(user);
        }
    }
    public void resendVerificationToken(Long userId){
        Optional<User> user = userRepository.findById(userId);
        sendVerificationToken(user.get());
    }

    private void sendVerificationToken(User user){
        VerificationToken verificationToken = new VerificationToken(user);
        verificationTokenRepository.save(verificationToken);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setSubject("Dokończ rejestrację");
        simpleMailMessage.setFrom("ardas0002@gmail.com");
        simpleMailMessage.setText("Aby potwierdzić swoją rejestrację, proszę kliknij w ten link:"
        + " http://localhost:8080/user/confirm-account?token=" + verificationToken.getConfirmationToken());

        emailSenderService.sendEmail(simpleMailMessage);
    }

    private boolean emailOrLoginExist(String email, String login){
        return userRepository.findByEmail(email) != null || userRepository.findByLogin(login) != null;
    }
}
