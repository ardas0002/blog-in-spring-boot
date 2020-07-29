package pl.ardas.bloginspringboot.exception;

public class VerificationTokenExpired extends Exception {

    public VerificationTokenExpired(){
        super("Link ten wygasł");
    }
}
