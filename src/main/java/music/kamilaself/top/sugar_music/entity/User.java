package music.kamilaself.top.sugar_music.entity;

import lombok.Data;
import music.kamilaself.top.sugar_music.enums.Gender;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class User extends BaseEntity {

    @Column(unique = true)
    private String username;

    private String nickname;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Boolean locked;

    private  Boolean enabled;

    private String last_login_ip;

    private Date last_login_time;


}
