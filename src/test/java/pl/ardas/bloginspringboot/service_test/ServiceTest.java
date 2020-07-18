package pl.ardas.bloginspringboot.service_test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import pl.ardas.bloginspringboot.exception.PageNotFound;
import pl.ardas.bloginspringboot.model.Post;
import pl.ardas.bloginspringboot.repository.PostRepository;
import pl.ardas.bloginspringboot.service.HomeService;
import static org.mockito.BDDMockito.given;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiceTest extends HomeService {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private HomeService homeService;

    @Test
    void shouldThrowExceptionWithPageNotFound(){
        int i = 10;
        int pageSize = 3;
        Pageable pageable = PageRequest.of(i - 1, pageSize);

        given(postRepository.findAll(pageable)).willReturn(Page.empty());

        assertThatThrownBy(() -> homeService.listAll(i))
                          .isInstanceOf(PageNotFound.class)
                          .hasMessage("Page " + i + " not found");
    }

    @Test
    void shouldReturnPage() throws PageNotFound {
        int i = 1;
        int pageSize = 3;
        Pageable pageable = PageRequest.of(i - 1, pageSize);
        List<Post> postList = List.of(new Post());
        PageImpl<Post> page = new PageImpl<>(postList);

        given(postRepository.findAll(pageable)).willReturn(page);

        assertThat(homeService.listAll(i)).isNotEmpty();
    }
}

