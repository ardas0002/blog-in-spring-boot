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
    void shouldReturnPost() throws PostNotFound {
        User user = new User();
        user.setLogin("Ardas");
        user.setId(1L);

        String title = "Lorem Ipsum";

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

        List<Comment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);
        comments.add(comment3);

        Optional<List<Comment>> optionalComments = Optional.of(comments);

        given(postRepository.findPost(title)).willReturn(post);
        given(commentRepository.findAllByPostId(1L)).willReturn(optionalComments);

        assertThat(postService.getPost(title).getComments()).hasSize(3);
        assertThat(postService.getPost(title).getComments().get(0)).isEqualTo(comment1);
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
