package pl.ardas.bloginspringboot.model.dto;

import lombok.Getter;
import lombok.Setter;
import pl.ardas.bloginspringboot.validation.PasswordMatches;
import pl.ardas.bloginspringboot.validation.ValidEmail;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@PasswordMatches
public class UserDto {

    @NotNull
    @NotEmpty
    private String login;
    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String lastName;
    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;
    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;
}
