package pl.ardas.bloginspringboot.exception;

public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException(){
        super("User with that email or login already exists.");
    }
}
