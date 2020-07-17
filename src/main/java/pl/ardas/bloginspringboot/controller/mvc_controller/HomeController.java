package pl.ardas.bloginspringboot.controller.mvc_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.ardas.bloginspringboot.exception.PageNotFound;
import pl.ardas.bloginspringboot.model.Post;
import pl.ardas.bloginspringboot.service.HomeService;

import java.util.List;

@Controller
public class HomeController{

    @Autowired
    private HomeService service;

    @GetMapping("/")
    public String home(Model model) throws PageNotFound {
        Page<Post> page = service.listAll(1);
        List<Post> posts = page.getContent();

        model.addAttribute("currentPage", 1);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("posts", posts);
        model.addAttribute("number", 1);
        return "index";
    }

    @GetMapping("/page/{number}")
    public String page(Model model, @PathVariable int number) throws PageNotFound{
        Page<Post> page = service.listAll(number);
        List<Post> posts = page.getContent();

        if(number == 1)
                return "redirect:/";

        model.addAttribute("currentPage", number);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("posts", posts);

        return "index";
    }
}
