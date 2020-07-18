package pl.ardas.bloginspringboot.rest_test;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.ardas.bloginspringboot.controller.rest_controller.HomeRestController;
import pl.ardas.bloginspringboot.controller.rest_controller.rest_exception_handling.HomeRestControllerExceptionHandling;
import pl.ardas.bloginspringboot.exception.PageNotFound;
import pl.ardas.bloginspringboot.model.Post;
import pl.ardas.bloginspringboot.model.User;
import pl.ardas.bloginspringboot.service.HomeService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class HomeRestControllerTest {

    private MockMvc mvc;

    @Mock
    private HomeService homeService;

    @InjectMocks
    private HomeRestController homeRestController;

    @BeforeEach
    void setup() {
        mvc = MockMvcBuilders.standaloneSetup(homeRestController)
                .setControllerAdvice(new HomeRestControllerExceptionHandling())
                .build();
    }

    @Test
    void shouldReturnListOfPostsDto() throws Exception{
        User user = new User();
        user.setLogin("Ardas");

        Post post = new Post(1L, user, "Lorem Ipsum 1", "Lorem Ipsum asc no de asuta", "Lorem Ipsum easr tqhsa jufhnasd",
                              LocalDateTime.of(2020, 8, 21, 21, 54, 42), LocalDateTime.of(2020, 8, 21, 21, 54, 42));
        Post post2 = new Post(2L, user, "Lorem Ipsum 2", "Lorem Ipsum asc no de asuta", "Lorem Ipsum easr tqhsa jufhnasd",
                LocalDateTime.of(2020, 8, 21, 21, 54, 42), LocalDateTime.of(2020, 8, 21, 21, 54, 42));
        Post post3 = new Post(3L, user, "Lorem Ipsum 3", "Lorem Ipsum asc no de asuta", "Lorem Ipsum easr tqhsa jufhnasd",
                LocalDateTime.of(2020, 8, 21, 21, 54, 42), LocalDateTime.of(2020, 8, 21, 21, 54, 42));

        List<Post> pageList = Arrays.asList(post, post2, post3);
        given(homeService.listAll(1)).willReturn(new PageImpl<>(pageList));

        mvc.perform(MockMvcRequestBuilders.get("/api/page/{number}", 1)
                                          .accept(MediaType.APPLICATION_JSON))
                                          .andExpect(status().isOk())
                                          .andExpect(jsonPath("$[*]", hasSize(3)))
                                          .andExpect(jsonPath("$[0].id", Matchers.is(1)))
                                          .andExpect(jsonPath("$[1].id", Matchers.is(2)))
                                          .andExpect(jsonPath("$[2].id", Matchers.is(3)))
                                          .andExpect(jsonPath("$[0].title", Matchers.is("Lorem Ipsum 1")))
                                          .andExpect(jsonPath("$[1].title", Matchers.is("Lorem Ipsum 2")))
                                          .andExpect(jsonPath("$[2].title", Matchers.is("Lorem Ipsum 3")));

    }

    @Test
    void shouldThrowPageNotFoundException() throws Exception{
        int i = 10;
        given(homeService.listAll(i)).willThrow(new PageNotFound(i));


        mvc.perform(MockMvcRequestBuilders.get("/api/page/{number}", 10)
                                          .accept(MediaType.APPLICATION_JSON))
                                          .andExpect(status().isNotFound());

    }
}
