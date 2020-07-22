package pl.ardas.bloginspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ardas.bloginspringboot.exception.PostNotFound;
import pl.ardas.bloginspringboot.model.Comment;
import pl.ardas.bloginspringboot.model.Post;
import pl.ardas.bloginspringboot.repository.CommentRepository;
import pl.ardas.bloginspringboot.repository.PostRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public PostService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public Post getPost(String title) throws PostNotFound {
        String postTitle = title.replace('-', ' ');
        Post post = postRepository.findPost(postTitle);
        if(post == null) throw new PostNotFound(title);
        Optional<List<Comment>> optionalComments = commentRepository.findAllByPostId(post.getId());
        if(optionalComments.isPresent()){
            List<Comment> comments = optionalComments.get();
            comments.sort(Comparator.comparing(Comment::getCreateDateTime).reversed());
            post.setComments(comments);
        }
        return post;
    }
}
