package me.zhengjie.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: eladmin
 * @description:
 * @author: ZakL
 * @create: 2019-11-27 09:30
 **/

@Data
public class ResultMessage {
    private String code;
    private String message;
    private Map resmap;

    public ResultMessage() {
        this("200", "No Message", new HashMap());
    }

    public ResultMessage(String code, String message, Map map) {
        this.code = code;
        this.message = message;
        this.resmap = map;
    }

    public ResultMessage(Map map) {
        this("200", "No Message", map);
    }

    public ResultMessage(Object object) {
        this();
        resmap.put("res", object);
    }
}
