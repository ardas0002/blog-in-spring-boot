package pl.ardas.bloginspringboot.controller.mvc_controller.exception_handling;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.ardas.bloginspringboot.exception.PageNotFound;

@Controller
public class HomeControllerExceptionHandling {

    @ExceptionHandler(PageNotFound.class)
    public String pageNotFound(Model model, Exception ex){
        model.addAttribute("message", ex.getMessage());
        return "error";
    }
}
