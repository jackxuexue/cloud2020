package com.jackxue.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AjaxResult implements Serializable {
    private int code;
    private String msg;
    private Object data;

    public static AjaxResult success(String msg){
        return new AjaxResult(200, msg, null);
    }
    public static AjaxResult success(String msg, Object data){
        return new AjaxResult(200, msg, data);
    }
}
