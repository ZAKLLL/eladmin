package me.zhengjie.modules.system.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @program: eladmin
 * @description:
 * @author: ZakL
 * @create: 2019-11-25 10:21
 **/
@Data
public class UserDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    @Pattern(regexp = "([a-z0-9A-Z]+[-|.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}",message = "格式错误")
    private String email;
    @NotBlank
    private String phone;
}
