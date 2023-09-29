package music.kamilaself.top.sugar_music.repository;

import music.kamilaself.top.sugar_music.entity.User;
import music.kamilaself.top.sugar_music.enums.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository repository;
    @Test
    void findByUsername() {
        User user = new User();
        user.setUsername("sugar");
        user.setNickname("sugar音乐者");
        user.setEnabled(true);
        user.setLocked(false);
        user.setPassword("sugar9527");
        user.setGender(Gender.MALE);
        user.setLast_login_ip("127.0.0.1");
        user.setLast_login_time(new Date());
        User savedUser = repository.save(user);

        User result =repository.getByUsername("sugar");

        System.out.println(result.toString());
    }
}