package me.zhengjie.modules.system.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Table(name = "query_history")
@Entity
public class QueryHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;


    @Column(name = "is_delete")
    private Boolean isDelete = false;

    @Column(name = "begin_site")
    @NotBlank
    @ApiModelProperty("开始站点")
    private String beginSite;

    @Column(name = "end_site")
    @NotBlank
    @ApiModelProperty("结束站点")
    private String endSite;

    @Column(name = "begin_gps")
    @NotBlank
    @ApiModelProperty("开始站点的GPS地址")
    private String beginGps;

    @Column(name = "create_gps")
    @NotBlank
    @ApiModelProperty("结束站点的GPS")
    private String endGps;

    @Column(name = "user_id")
    private long userId;


}
