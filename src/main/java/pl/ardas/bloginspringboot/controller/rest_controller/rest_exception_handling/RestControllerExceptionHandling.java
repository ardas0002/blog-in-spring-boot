package pl.ardas.bloginspringboot.controller.rest_controller.rest_exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.ardas.bloginspringboot.exception.CustomErrorResponse;
import pl.ardas.bloginspringboot.exception.PageNotFound;
import pl.ardas.bloginspringboot.exception.PostNotFound;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestControllerExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler({PageNotFound.class, PostNotFound.class})
    public ResponseEntity<CustomErrorResponse> pageNotFound(Exception ex){
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }


}
