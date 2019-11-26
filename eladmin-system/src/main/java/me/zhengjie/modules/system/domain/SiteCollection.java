package me.zhengjie.modules.system.domain;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Table(name = "site_collection")
@Entity
public class SiteCollection implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    @ApiModelProperty("站点名称")
    private String siteName;
    @CreationTimestamp
    private Timestamp createTime;
    private long userId;
    private long isDelete;
    @NotBlank
    @ApiModelProperty("gps地址")
    private String gps;



}
