package music.kamilaself.top.sugar_music.service;

import music.kamilaself.top.sugar_music.dto.UserCreateRequest;
import music.kamilaself.top.sugar_music.dto.UserDTO;
import music.kamilaself.top.sugar_music.dto.UserUpdateRequest;
import music.kamilaself.top.sugar_music.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Arrays;
import java.util.List;


public interface UserService extends UserDetailsService {
    List<UserDTO> list();

    UserDTO create(UserCreateRequest userCreateRequest);

    @Override
    User loadUserByUsername(String username);

    UserDTO get(String id);

    UserDTO update(String id, UserUpdateRequest userUpdateRequest);

    void delete(String id);

    Page<UserDTO> search(Pageable pageable);
}
