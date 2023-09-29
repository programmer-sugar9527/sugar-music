package music.kamilaself.top.sugar_music.service;

import music.kamilaself.top.sugar_music.dto.UserDTO;
import music.kamilaself.top.sugar_music.mapper.UserMapper;
import music.kamilaself.top.sugar_music.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService{

    UserRepository repository;

    UserMapper userMapper;

    @Override
    public List<UserDTO> list() {
        return repository.findAll()
                .stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
