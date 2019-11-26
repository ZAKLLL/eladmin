package me.zhengjie.modules.system.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @program: eladmin
 * @description:
 * @author: ZakL
 * @create: 2019-11-26 14:41
 **/
@Data
public class DtoParam {
    @Data
    public static class EditUserInfoParam {
        @NotBlank
        private String userName;

        @NotBlank
        private String phone;

        @NotBlank
        private String Email;
    }

}
