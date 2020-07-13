package pl.ardas.bloginspringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PageNotFound extends Exception {

    public PageNotFound(String message){
        super(message);
    }
}
