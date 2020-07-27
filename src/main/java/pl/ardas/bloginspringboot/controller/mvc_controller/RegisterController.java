package pl.ardas.bloginspringboot.controller.mvc_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.ardas.bloginspringboot.exception.UserAlreadyExistException;
import pl.ardas.bloginspringboot.model.User;
import pl.ardas.bloginspringboot.model.dto.UserDto;
import pl.ardas.bloginspringboot.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {

    private UserService userService;

    @Autowired
    public RegisterController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user/registration")
    public String showRegistrationForm(Model model, @RequestParam(required = false) String result){
        if(result != null){
            if(result.equals("success"))
                model.addAttribute("message", "Zostałeś zarejestrowany!");
            else
                model.addAttribute("message", "Email lub login jest już zajęty");
        }
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/user/registration")
    public String register(@Valid @ModelAttribute("user") UserDto user, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "registration";
        }
        try{
           userService.registerNewUserAccount(user);
        }catch (UserAlreadyExistException e){
           return "redirect:/user/registration?result=fail";
        }
        return "redirect:/user/registration?result=success";
    }
}
