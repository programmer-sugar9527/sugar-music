package music.kamilaself.top.sugar_music.service.impl;

import music.kamilaself.top.sugar_music.dto.UserCreateDTO;
import music.kamilaself.top.sugar_music.dto.UserDTO;
import music.kamilaself.top.sugar_music.entity.User;
import music.kamilaself.top.sugar_music.enums.ExceptionType;
import music.kamilaself.top.sugar_music.exception.BizException;
import music.kamilaself.top.sugar_music.mapper.UserMapper;
import music.kamilaself.top.sugar_music.repository.UserRepository;
import music.kamilaself.top.sugar_music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {

    UserRepository repository;

    UserMapper userMapper;

    PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> list() {
        return repository.findAll()
                .stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO create(UserCreateDTO userCreateDTO) {
        checkUserName(userCreateDTO.getUsername());
        User user = userMapper.createEntity(userCreateDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toDTO(repository.save(user));
    }

    @Override
    public User loadUserByUsername(String username) {
        Optional<User> user = repository.findByUsername(username);
        if (user.isEmpty()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }

        return user.get();
    }

    private void checkUserName(String username) {
        Optional<User> user = repository.findByUsername(username);
        if(user.isPresent()) {
            throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
        }
    }


    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
