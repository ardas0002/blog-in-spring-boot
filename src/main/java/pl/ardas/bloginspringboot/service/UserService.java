package pl.ardas.bloginspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.ardas.bloginspringboot.exception.UserAlreadyExistException;
import pl.ardas.bloginspringboot.model.User;
import pl.ardas.bloginspringboot.model.dto.UserDto;
import pl.ardas.bloginspringboot.repository.UserRepository;
import pl.ardas.bloginspringboot.repository.UserRoleRepository;

import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private PasswordEncoder passwordEncoder;
    private final static String role = "ROLE_USER";

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
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
        user.setEnabled(true);
        userRepository.save(user);
    }

    private boolean emailOrLoginExist(String email, String login){
        return userRepository.findByEmail(email) != null || userRepository.findByLogin(login) != null;
    }
}
