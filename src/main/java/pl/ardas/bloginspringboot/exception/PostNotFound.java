package pl.ardas.bloginspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PostNotFound extends Exception {

    public PostNotFound(String title){
        super("Post " + title + " not found");
    }
}
