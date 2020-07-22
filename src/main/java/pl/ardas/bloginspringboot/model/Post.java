package pl.ardas.bloginspringboot.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "post_author")
    private User author;
    @NotEmpty(message = "Title can't be empty.")
    @Column(name = "post_title")
    @Length(min = 5, message = "Title must be at least 5 characters.")
    private String title;
    @Lob
    @Column(name = "post_summary")
    private String summary;
    @Lob
    @NotEmpty(message = "Content of post can't be empty.")
    @Column(name = "post_content")
    private String content;
    @CreationTimestamp
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    public Post(Long id, User author, String title, String summary, String content, LocalDateTime createDateTime,
                LocalDateTime updateDateTime) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }


}
