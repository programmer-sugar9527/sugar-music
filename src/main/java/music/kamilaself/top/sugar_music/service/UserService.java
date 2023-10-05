package music.kamilaself.top.sugar_music.service;

import music.kamilaself.top.sugar_music.dto.UserCreateDTO;
import music.kamilaself.top.sugar_music.dto.UserDTO;
import music.kamilaself.top.sugar_music.entity.User;
import music.kamilaself.top.sugar_music.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;


public interface UserService extends UserDetailsService {
    List<UserDTO> list();

    UserDTO create(UserCreateDTO userCreateDTO);

    @Override
    User loadUserByUsername(String username);

}
