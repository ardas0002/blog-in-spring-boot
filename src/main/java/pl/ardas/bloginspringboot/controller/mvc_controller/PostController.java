package pl.ardas.bloginspringboot.controller.mvc_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.ardas.bloginspringboot.exception.PageNotFound;
import pl.ardas.bloginspringboot.exception.PostNotFound;
import pl.ardas.bloginspringboot.model.Post;
import pl.ardas.bloginspringboot.repository.PostRepository;
import pl.ardas.bloginspringboot.service.PostService;

@Controller
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }
    @GetMapping("/post/{title}")
    public String post(@PathVariable String title, Model model) throws PostNotFound {
        Post post = postService.getPost(title);
        if(post.getComments().size() > 0){
            model.addAttribute("comments", post.getComments());
        }
        model.addAttribute("post", post);
        return "post";
    }

    @ExceptionHandler(PostNotFound.class)
    public String pageNotFound(Model model, Exception ex){
        model.addAttribute("message", ex.getMessage());
        return "fatalError";
    }
}
