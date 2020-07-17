package pl.ardas.bloginspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PageNotFound extends Exception {

    public PageNotFound(int number){
        super("Page " + number + " not found");
    }
}
