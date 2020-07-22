package pl.ardas.bloginspringboot.controller.rest_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.ardas.bloginspringboot.exception.PageNotFound;
import pl.ardas.bloginspringboot.exception.PostNotFound;
import pl.ardas.bloginspringboot.model.Comment;
import pl.ardas.bloginspringboot.model.Post;
import pl.ardas.bloginspringboot.model.dto.ItemMapper;
import pl.ardas.bloginspringboot.model.dto.PostCommentsDto;
import pl.ardas.bloginspringboot.model.dto.PostDto;
import pl.ardas.bloginspringboot.service.PostService;

@RestController
public class PostRestController {

    private PostService postService;

    @Autowired
    public PostRestController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/api/post/{title}")
    public ResponseEntity<? extends PostDto>  post(@PathVariable String title) throws PostNotFound {
        Post post = postService.getPost(title);
        PostDto postDto;
        if(post.getComments().size() > 0){
            postDto = ItemMapper.mapToPostCommentsDto(post);
        }else{
            postDto = ItemMapper.mapToPostDto(post);
        }
        return ResponseEntity.ok(postDto);
    }
}
