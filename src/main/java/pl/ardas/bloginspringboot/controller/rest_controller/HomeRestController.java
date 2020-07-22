package pl.ardas.bloginspringboot.controller.rest_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ardas.bloginspringboot.exception.PageNotFound;
import pl.ardas.bloginspringboot.model.Post;
import pl.ardas.bloginspringboot.model.dto.ItemMapper;
import pl.ardas.bloginspringboot.model.dto.PostDto;
import pl.ardas.bloginspringboot.service.HomeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HomeRestController {

    private HomeService service;

    @Autowired
    public HomeRestController(HomeService homeService){
        this.service = homeService;
    }

    @GetMapping("/api/page/{number}")
    public ResponseEntity<List<PostDto>> home(@PathVariable int number) throws PageNotFound {
        Page<Post> page = service.getPage(number);
        List<PostDto> postDtos = page.getContent()
                                     .stream()
                                     .map(ItemMapper::mapToPostDto)
                                     .collect(Collectors.toList());
        return ResponseEntity.ok(postDtos);
    }
}
