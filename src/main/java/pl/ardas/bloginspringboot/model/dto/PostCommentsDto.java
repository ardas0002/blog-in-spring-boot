package pl.ardas.bloginspringboot.model.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostCommentsDto extends PostDto {

    private Long id;
    private String authorLogin;
    private String title;
    private String summary;
    private String content;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
    private List<CommentDto> commentDtos;
}

