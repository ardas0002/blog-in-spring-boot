package pl.ardas.bloginspringboot.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String content;
    @ManyToOne
    @JoinColumn(name = "comment_author")
    private User user;

    public Comment(){}

    public Comment(String content){
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
