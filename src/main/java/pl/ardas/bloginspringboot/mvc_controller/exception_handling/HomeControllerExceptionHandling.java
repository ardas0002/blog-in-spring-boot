package pl.ardas.bloginspringboot.mvc_controller.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.ardas.bloginspringboot.exceptions.PageNotFound;

@Controller
public class HomeControllerExceptionHandling {

    @ExceptionHandler(PageNotFound.class)
    public String pageError(Model model, Exception ex){
        model.addAttribute("message", ex.getMessage());
        return "error";
    }
}
