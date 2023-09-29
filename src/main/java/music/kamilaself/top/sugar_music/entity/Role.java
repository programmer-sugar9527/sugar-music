package music.kamilaself.top.sugar_music.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
public class Role extends BaseEntity {

    private String name;

    private String title;

}
