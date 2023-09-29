package music.kamilaself.top.sugar_music.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseEntity {

    @Id
    @GeneratedValue(generator = "ksuid")
    @GenericGenerator(name = "ksuid",strategy = "music.kamilaself.top.sugar_music.utils.KsuidIdentifierGenerator")
    private String id;

    @CreationTimestamp
    private Date created_time;

    @UpdateTimestamp
    private  Date updated_time;

}