package pl.ardas.bloginspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ardas.bloginspringboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
    User findByEmail(String email);
}
