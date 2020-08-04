package pl.ardas.bloginspringboot.service_test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;
import pl.ardas.bloginspringboot.exception.PageNotFound;
import pl.ardas.bloginspringboot.model.Post;
import pl.ardas.bloginspringboot.repository.PostRepository;
import pl.ardas.bloginspringboot.service.HomeService;


import java.util.List;
import static org.mockito.BDDMockito.given;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HomeServiceTest extends HomeService {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private HomeService homeService;

    @Test
    void shouldThrowPageNotFoundException() {
        int i = 10;
        int pageSize = 3;
        Pageable pageable = PageRequest.of(i - 1, pageSize, Sort.by("createDateTime").descending());

        given(postRepository.findPosts(pageable)).willReturn(Page.empty());

        assertThatThrownBy(() -> homeService.getPage(i))
                .isInstanceOf(PageNotFound.class)
                .hasMessage("Page " + i + " not found");
    }

    @Test
    void shouldReturnPage() throws PageNotFound {
        int i = 1;
        int pageSize = 3;
        Pageable pageable = PageRequest.of(i - 1, pageSize, Sort.by("createDateTime").descending());
        List<Post> postList = List.of(new Post(), new Post(), new Post());
        PageImpl<Post> page = new PageImpl<>(postList);

        given(postRepository.findPosts(pageable)).willReturn(page);

        assertThat(homeService.getPage(i)).isNotEmpty().hasSize(3);
    }
}

