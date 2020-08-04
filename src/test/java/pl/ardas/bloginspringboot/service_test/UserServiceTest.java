package pl.ardas.bloginspringboot.service_test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.ardas.bloginspringboot.exception.VerificationTokenExpired;
import pl.ardas.bloginspringboot.model.User;
import pl.ardas.bloginspringboot.register.VerificationToken;
import pl.ardas.bloginspringboot.repository.UserRepository;
import pl.ardas.bloginspringboot.repository.VerificationTokenRepository;
import pl.ardas.bloginspringboot.service.UserService;
import static org.assertj.core.api.Assertions.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private VerificationTokenRepository verificationTokenRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnEnabledUserAfterConfirmRegistration(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Timestamp(calendar.getTime().getTime()));
        calendar.add(Calendar.MINUTE, 60 * 24);

        Date date = new Date(calendar.getTime().getTime());

        User user = new User();

        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setUser(user);
        verificationToken.setExpiryDate(date);

        when(verificationTokenRepository.getByConfirmationToken(anyString())).thenReturn(verificationToken);
        when(userRepository.save(user)).thenReturn(user);

        assertThat(userService.confirmRegistration(anyString())).extracting("enabled").isEqualTo(true);
    }

    @Test
    void shouldReturnDisabledUserAfterConfirmRegistration(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Timestamp(calendar.getTime().getTime()));

        Date date = new Date(calendar.getTime().getTime());

        User user = new User();

        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setUser(user);
        verificationToken.setExpiryDate(date);

        when(verificationTokenRepository.getByConfirmationToken(anyString())).thenReturn(verificationToken);

        assertThat(userService.confirmRegistration(anyString())).extracting("enabled").isEqualTo(false);
    }
}
