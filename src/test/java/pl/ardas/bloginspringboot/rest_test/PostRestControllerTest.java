package pl.ardas.bloginspringboot.rest_test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.ardas.bloginspringboot.controller.rest_controller.PostRestController;
import pl.ardas.bloginspringboot.controller.rest_controller.rest_exception_handling.RestControllerExceptionHandling;
import pl.ardas.bloginspringboot.exception.PostNotFound;
import pl.ardas.bloginspringboot.model.Comment;
import pl.ardas.bloginspringboot.model.Post;
import pl.ardas.bloginspringboot.model.User;
import pl.ardas.bloginspringboot.service.PostService;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PostRestControllerTest {


    private MockMvc mvc;

    @Mock
    private PostService postService;

    @InjectMocks
    private PostRestController postRestController;

    @BeforeEach
    void setup() {
        mvc = MockMvcBuilders.standaloneSetup(postRestController)
                .setControllerAdvice(new RestControllerExceptionHandling())
                .build();
    }

    @Test
    void shouldReturnPostDto() throws Exception {
        String title = "Lorem Ipsum";
        User user = new User();
        user.setLogin("Ardas");

        Post post = new Post();
        post.setId(1L);
        post.setAuthor(user);
        post.setTitle(title);
        post.setSummary("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae turpis a turpis " +
                "sagittis blandit eu in augue. Nulla tristique finibus blandit.");
        post.setContent("Quisque vel risus sed metus luctus malesuada. Fusce vitae massa eget nulla vulputate pulvinar. " +
                "Donec elementum sem sit amet viverra aliquet. Pellentesque non metus mollis, blandit mi sit amet, " +
                "aliquam lacus. Sed semper vel arcu ornare rutrum. Suspendisse nec massa vel ex faucibus rutrum. " +
                "Aenean vulputate, neque vulputate tristique placerat, nisi turpis semper dolor, et rutrum turpis " +
                "lacus quis odio. Quisque congue sem rhoncus nisl dapibus mollis.");
        post.setCreateDateTime(LocalDateTime.of(2020, Month.JULY, 20, 10, 10, 10));
        post.setUpdateDateTime(LocalDateTime.of(2020, Month.JULY, 21, 10, 10, 10));

        given(postService.getPost(title)).willReturn(post);

        mvc.perform(MockMvcRequestBuilders.get("/api/post/{title}", title)
                                          .accept(MediaType.APPLICATION_JSON))
                                          .andExpect(status().isOk())
                                          .andExpect(jsonPath("$[*]", hasSize(7)))
                                          .andExpect(jsonPath("$.authorLogin", is("Ardas")))
                                          .andExpect(jsonPath("$.title", is(title)));
    }

    @Test
    void shouldReturnPostCommentsDto() throws Exception {
        String title = "Lorem Ipsum";
        User user = new User();
        user.setLogin("Ardas");

        Post post = new Post();
        post.setId(1L);
        post.setAuthor(user);
        post.setTitle(title);
        post.setSummary("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae turpis a turpis " +
                "sagittis blandit eu in augue. Nulla tristique finibus blandit.");
        post.setContent("Quisque vel risus sed metus luctus malesuada. Fusce vitae massa eget nulla vulputate pulvinar. " +
                "Donec elementum sem sit amet viverra aliquet. Pellentesque non metus mollis, blandit mi sit amet, " +
                "aliquam lacus. Sed semper vel arcu ornare rutrum. Suspendisse nec massa vel ex faucibus rutrum. " +
                "Aenean vulputate, neque vulputate tristique placerat, nisi turpis semper dolor, et rutrum turpis " +
                "lacus quis odio. Quisque congue sem rhoncus nisl dapibus mollis.");
        post.setCreateDateTime(LocalDateTime.of(2020, Month.JULY, 20, 10, 10, 10));
        post.setUpdateDateTime(LocalDateTime.of(2020, Month.JULY, 21, 10, 10, 10));


        Comment comment1 = new Comment();
        comment1.setId(1L);
        comment1.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        comment1.setUser(user);
        comment1.setPost(post);
        comment1.setCreateDateTime(LocalDateTime.of(2020, Month.JULY, 23, 10, 10, 10));

        Comment comment2 = new Comment();
        comment2.setId(2L);
        comment2.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        comment2.setUser(user);
        comment2.setPost(post);
        comment2.setCreateDateTime(LocalDateTime.of(2020, Month.JULY, 20, 11, 10, 10));

        Comment comment3 = new Comment();
        comment3.setId(3L);
        comment3.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        comment3.setUser(user);
        comment3.setPost(post);
        comment3.setCreateDateTime(LocalDateTime.of(2020, Month.JULY, 22, 12, 10, 10));

        List<Comment> commentList = Arrays.asList(comment1, comment2, comment3);

        post.setComments(commentList);

        given(postService.getPost(anyString())).willReturn(post);

        mvc.perform(MockMvcRequestBuilders.get("/api/post/{title}", title)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(8)))
                .andExpect(jsonPath("$.commentDtos", hasSize(3)));
    }

    @Test
    void shouldThrowPostNotFoundException() throws Exception{
        String title = "false";

        given(postService.getPost(anyString())).willThrow(new PostNotFound(title));

        mvc.perform(MockMvcRequestBuilders.get("/api/post/{title}", title)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error", is("Post " + title + " not found")));

    }
}
