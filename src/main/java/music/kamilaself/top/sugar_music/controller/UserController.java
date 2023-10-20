package music.kamilaself.top.sugar_music.controller;

import music.kamilaself.top.sugar_music.dto.UserCreateRequest;
import music.kamilaself.top.sugar_music.dto.UserUpdateRequest;
import music.kamilaself.top.sugar_music.mapper.UserMapper;
import music.kamilaself.top.sugar_music.service.UserService;
import music.kamilaself.top.sugar_music.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(("/users"))
@CrossOrigin
public class UserController {

    UserService userService;

    UserMapper userMapper;

    @GetMapping("/")
    Page<UserVo> search(@PageableDefault(sort = {"createdTime"}, direction = Sort.Direction.ASC)Pageable pageable) {
        return userService.search(pageable).map(userMapper::toVO);
    }

    @PostMapping("/")
    UserVo create(@Validated @RequestBody UserCreateRequest userCreateRequest) {
        return userMapper.toVO(userService.create(userCreateRequest));
    }

    @GetMapping("/{id}")
    UserVo get(@PathVariable String id) {
        return userMapper.toVO(userService.get(id));
    }

    @PutMapping("/{id}")
    UserVo update(@PathVariable String id,
                  @Validated @RequestBody UserUpdateRequest userUpdateRequest) {
        return userMapper.toVO(userService.update(id, userUpdateRequest));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        userService.delete(id);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
