package pl.ardas.bloginspringboot.rest_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.ardas.bloginspringboot.controller.rest_controller.HomeRestController;
import pl.ardas.bloginspringboot.controller.rest_controller.rest_exception_handling.HomeRestControllerExceptionHandling;
import pl.ardas.bloginspringboot.exception.CustomErrorResponse;
import pl.ardas.bloginspringboot.exception.PageNotFound;
import pl.ardas.bloginspringboot.model.Post;
import pl.ardas.bloginspringboot.model.User;
import pl.ardas.bloginspringboot.model.dto.ItemMapper;
import pl.ardas.bloginspringboot.model.dto.PostDto;
import pl.ardas.bloginspringboot.repository.PostRepository;
import pl.ardas.bloginspringboot.service.HomeService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class HomeRestControllerTest {

    private MockMvc mvc;

    @Mock
    private HomeService homeService;

    @InjectMocks
    private HomeRestController homeRestController;

    private JacksonTester<PostDto> jsonPost;


    @BeforeEach
    void setup() {
        JacksonTester.initFields(this, new ObjectMapper());

        mvc = MockMvcBuilders.standaloneSetup(homeRestController)
                .setControllerAdvice(new HomeRestControllerExceptionHandling())
                .build();
    }

    @Test
    void shouldReturnListOfPostsDto() throws Exception{
        User user = new User();
        user.setLogin("Ardas");

        Post post = new Post(1L, user, "Lorem Ipsum", "Lorem Ipsum asc no de asuta", "Lorem Ipsum easr tqhsa jufhnasd",
                              LocalDateTime.of(2020, 8, 21, 21, 54, 42), LocalDateTime.of(2020, 8, 21, 21, 54, 42));
        Post post2 = new Post(2L, user, "Lorem Ipsum", "Lorem Ipsum asc no de asuta", "Lorem Ipsum easr tqhsa jufhnasd",
                LocalDateTime.of(2020, 8, 21, 21, 54, 42), LocalDateTime.of(2020, 8, 21, 21, 54, 42));
        Post post3 = new Post(3L, user, "Lorem Ipsum", "Lorem Ipsum asc no de asuta", "Lorem Ipsum easr tqhsa jufhnasd",
                LocalDateTime.of(2020, 8, 21, 21, 54, 42), LocalDateTime.of(2020, 8, 21, 21, 54, 42));

        List<Post> pageList = Arrays.asList(post, post2, post3);
        List<PostDto> postDtos = pageList.stream()
                                         .map(ItemMapper::mapToPostDto)
                                         .collect(Collectors.toList());


        when(homeService.listAll(1)).thenReturn(new PageImpl<>(pageList));

        mvc.perform(MockMvcRequestBuilders.get("/api/page/{number}", 1)
                                          .accept(MediaType.APPLICATION_JSON))
                                          .andExpect(status().isOk())
                                          .andExpect(jsonPath("$[*]", hasSize(3)));
    }
}
