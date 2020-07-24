package pl.ardas.bloginspringboot.service_test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.ardas.bloginspringboot.exception.PageNotFound;
import pl.ardas.bloginspringboot.exception.PostNotFound;
import pl.ardas.bloginspringboot.model.Comment;
import pl.ardas.bloginspringboot.model.Post;
import pl.ardas.bloginspringboot.model.User;
import pl.ardas.bloginspringboot.repository.CommentRepository;
import pl.ardas.bloginspringboot.repository.PostRepository;
import pl.ardas.bloginspringboot.service.PostService;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @InjectMocks
    private PostService postService;

    @Mock
    private PostRepository postRepository;
    @Mock
    private CommentRepository commentRepository;

    @Test
    void shouldReturnPostWithCommentsInDescendingDateOrder() throws PostNotFound {

        Post post = new Post();
        post.setId(1L);

        Comment comment1 = new Comment();
        comment1.setCreateDateTime(LocalDateTime.of(2020, Month.JULY, 23, 10, 10, 10));

        Comment comment2 = new Comment();
        comment2.setCreateDateTime(LocalDateTime.of(2020, Month.JULY, 20, 11, 10, 10));

        Comment comment3 = new Comment();
        comment3.setCreateDateTime(LocalDateTime.of(2020, Month.JULY, 22, 12, 10, 10));

        List<Comment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);
        comments.add(comment3);

        Optional<List<Comment>> optionalComments = Optional.of(comments);

        given(postRepository.findPost(anyString())).willReturn(post);
        given(commentRepository.findAllByPostId(1L)).willReturn(optionalComments);

        assertThat(postService.getPost(anyString()).getComments()).hasSize(3);
        assertThat(postService.getPost(anyString()).getComments().get(0)).isEqualTo(comment1);
    }

    @Test
    void shouldThrowPostNotFoundException(){
        String title = "konstantynopolitańczykowianeczka";

        given(postRepository.findPost(title)).willReturn(null);

        assertThatThrownBy(() -> postService.getPost(title))
                .isInstanceOf(PostNotFound.class)
                .hasMessage("Post " + title + " not found");
    }
}
