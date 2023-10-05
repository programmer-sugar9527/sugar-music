package music.kamilaself.top.sugar_music.dto;

import lombok.Data;
import music.kamilaself.top.sugar_music.enums.Gender;

import java.util.Date;
import java.util.List;

@Data
public class UserDTO {
    private String id;

    private String username;

    private String nickname;

    private List<RoleDTO> roles;

    private Gender gender;

    private Boolean locked;

    private Boolean enabled;

    private String lastLoginIp;

    private Date lastLoginTime;
}
