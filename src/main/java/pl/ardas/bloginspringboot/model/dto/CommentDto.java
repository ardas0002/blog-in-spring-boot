package pl.ardas.bloginspringboot.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {

    private Long id;
    private String content;
    private String authorLogin;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
}
