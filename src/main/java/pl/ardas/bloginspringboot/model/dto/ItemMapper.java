package pl.ardas.bloginspringboot.model.dto;

import pl.ardas.bloginspringboot.model.Comment;
import pl.ardas.bloginspringboot.model.Post;

import java.util.List;
import java.util.stream.Collectors;

public class ItemMapper {

    public static PostDto mapToPostDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setAuthorLogin(post.getAuthor().getLogin());
        postDto.setTitle(post.getTitle());
        postDto.setSummary(post.getSummary());
        postDto.setContent(post.getContent());
        postDto.setCreateDateTime(post.getCreateDateTime());
        postDto.setUpdateDateTime(post.getUpdateDateTime());
        return postDto;
    }

    public static PostCommentsDto mapToPostCommentsDto(Post post){
        PostCommentsDto postCommentsDto = new PostCommentsDto();
        postCommentsDto.setId(post.getId());
        postCommentsDto.setAuthorLogin(post.getAuthor().getLogin());
        postCommentsDto.setTitle(post.getTitle());
        postCommentsDto.setSummary(post.getSummary());
        postCommentsDto.setContent(post.getContent());
        postCommentsDto.setCreateDateTime(post.getCreateDateTime());
        postCommentsDto.setUpdateDateTime(post.getUpdateDateTime());
        if(post.getComments().size() > 0){
            List<CommentDto> commentDtos = post.getComments()
                                               .stream()
                                               .map(ItemMapper::mapToCommentDto)
                                               .collect(Collectors.toList());
        postCommentsDto.setCommentDtos(commentDtos);
        }
        return postCommentsDto;
    }

    public static CommentDto mapToCommentDto(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setContent(comment.getContent());
        commentDto.setAuthorLogin(comment.getUser().getLogin());
        commentDto.setCreateDateTime(comment.getCreateDateTime());
        commentDto.setUpdateDateTime(comment.getUpdateDateTime());

        return commentDto;
    }
}
