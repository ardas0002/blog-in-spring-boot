package pl.ardas.bloginspringboot.controller.mvc_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.ardas.bloginspringboot.exception.UserAlreadyExistException;
import pl.ardas.bloginspringboot.model.User;
import pl.ardas.bloginspringboot.model.dto.UserDto;
import pl.ardas.bloginspringboot.service.UserService;

import javax.validation.Valid;


@Controller
public class RegisterController {

    private UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/registration")
    public String showRegistrationForm(Model model, @RequestParam(required = false) String result) {
        if (result != null) {
            if (result.equals("success"))
                model.addAttribute("message", "Zostałeś zarejestrowany, wystarczy już tylko potwierdzić email.");
            else
                model.addAttribute("message", "Email lub login jest już zajęty");
        }
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/user/registration")
    public String register(@Valid @ModelAttribute("user") UserDto user, BindingResult result) throws UserAlreadyExistException {
        if (result.hasErrors()) {
            return "registration";
        }
        userService.registerNewUserAccount(user);
        return "redirect:/user/registration?result=success";
    }

    @GetMapping("/user/confirm-account")
    public String confirmRegistration(@RequestParam String token, Model model){
        User user = userService.confirmRegistration(token);
        if(!user.isEnabled())
            model.addAttribute("user",user.getId());

        return "registerEffect";
    }

    @GetMapping("/user/registration/resend")
    public String resendConfirmation(@RequestParam Long userId){
        userService.resendVerificationToken(userId);
        return "resendVerificationToken";
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public String userAlreadyExists() {
        return "redirect:/user/registration?result=fail";
    }

}
