package pl.ardas.bloginspringboot.model.dto;

import pl.ardas.bloginspringboot.model.Post;

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
}
