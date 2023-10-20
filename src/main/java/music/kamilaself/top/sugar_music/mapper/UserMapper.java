package music.kamilaself.top.sugar_music.mapper;

import music.kamilaself.top.sugar_music.dto.UserCreateRequest;
import music.kamilaself.top.sugar_music.dto.UserDTO;
import music.kamilaself.top.sugar_music.dto.UserUpdateRequest;
import music.kamilaself.top.sugar_music.entity.User;
import music.kamilaself.top.sugar_music.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);

    UserVo toVO(UserDTO userDTO);

    User createEntity(UserCreateRequest userCreateRequest);

    User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);

}
