package pl.ardas.bloginspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "login", nullable = false, unique = true)
    @Length(min = 3, max = 20, message = "Your login must be between 3 and 20 characters.")
    private String login;
    @Column(name = "password", nullable = false)
    @Length(min = 5, message = "Your password must have at least 5 characters")
    @NotEmpty(message = "Please provide your password")
    @JsonIgnore
    private String password;
    @Column(name = "first_name", nullable = false)
    @NotEmpty(message = "Please provide your first name.")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    @NotEmpty(message = "Please provide your last name.")
    private String lastName;
    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "Please provide correct email.")
    private String email;
    @CreationTimestamp
    private LocalDateTime createDateTime;
    @ManyToMany
    @JoinTable(name = "user_role",
    joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    private Set<UserRole> roles = new HashSet<>();
    @OneToMany(mappedBy = "author")
    private List<Post> posts = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    public User(String login, String firstName, String lastName, String email){
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
