package me.zhengjie.modules.system.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Table(name = "route_collection")
@Entity
public class RouteCollection implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "is_delete")
    private long isDelete;

    @Column(name = "begin_site")
    private String beginSite;

    @Column(name = "end_site")
    private String endSite;

    @Column(name = "begin_gps")
    private String beginGps;

    @Column(name = "end_gps")
    private String endGps;

    @Column(name = "user_id")
    private long userId;


}
