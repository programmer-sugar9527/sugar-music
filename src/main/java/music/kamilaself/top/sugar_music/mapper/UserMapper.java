package music.kamilaself.top.sugar_music.mapper;

import music.kamilaself.top.sugar_music.dto.UserCreateDTO;
import music.kamilaself.top.sugar_music.dto.UserDTO;
import music.kamilaself.top.sugar_music.entity.User;
import music.kamilaself.top.sugar_music.vo.UserVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);

    UserVo toVO(UserDTO userDTO);

    User createEntity(UserCreateDTO userCreateDTO);

}
