package music.kamilaself.top.sugar_music.repository;

import music.kamilaself.top.sugar_music.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {

    User getByUsername(String username);

    Optional<User> findByUsername(String username);

    User getUserById(String id);

    Page<User> findAll(Pageable pageable);

}
