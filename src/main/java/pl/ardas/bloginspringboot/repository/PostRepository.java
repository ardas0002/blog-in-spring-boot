package pl.ardas.bloginspringboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.ardas.bloginspringboot.model.Post;
import java.util.List;
import java.util.Optional;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p")
    Page<Post> findPosts(Pageable pageable);

    @Query("Select p FROM Post p WHERE p.title=:title")
    Post findPost(@Param("title")String title);
}
