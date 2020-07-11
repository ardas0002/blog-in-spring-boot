package pl.ardas.bloginspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.ardas.bloginspringboot.model.Comment;
import pl.ardas.bloginspringboot.model.Post;
import pl.ardas.bloginspringboot.repository.CommentRepository;
import pl.ardas.bloginspringboot.repository.PostRepository;
import pl.ardas.bloginspringboot.repository.UserRepository;

import java.util.List;

@SpringBootApplication
public class BlogInSpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(BlogInSpringBootApplication.class, args);
        PostRepository postRepository = ctx.getBean(PostRepository.class);
        CommentRepository commentRepository = ctx.getBean(CommentRepository.class);

        List<Comment> comment = commentRepository.findAllByPostId(1L);
        comment.forEach(System.out::println);
    }

}
