package me.zhengjie.modules.system.domain;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Table(name = "site_collection")
@Entity
public class SiteCollection implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String siteName;
    @CreationTimestamp
    private Timestamp createTime;
    private long userId;
    private long isDelete;
    private String gps;


}
