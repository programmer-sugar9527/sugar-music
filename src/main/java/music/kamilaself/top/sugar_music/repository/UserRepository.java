package music.kamilaself.top.sugar_music.repository;

import music.kamilaself.top.sugar_music.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {

    User getByUsername(String username);

}
