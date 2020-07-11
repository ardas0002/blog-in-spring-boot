package pl.ardas.bloginspringboot.mvc_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.ardas.bloginspringboot.model.Post;
import pl.ardas.bloginspringboot.repository.PostRepository;
import pl.ardas.bloginspringboot.service.HomeService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private HomeService service;

    @GetMapping("/")
    public String viewPage(Model model, @RequestParam(defaultValue = "1") int pageNum){
        Page<Post> page = service.listAll(pageNum);
        List<Post> posts = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalPosts", page.getTotalElements());
        model.addAttribute("posts", posts);

        return "viewPage";
    }
}
