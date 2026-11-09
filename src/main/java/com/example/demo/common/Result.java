package com.example.demo.common;

import com.example.demo.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    //
    private int code;
    //
    private String msg;
    //
    private Object data;
    //
    /**
     * 返回查询失败的结果
     */
    public static Result Search_fail(){
        Result search = new Result();
        search.setCode(200);
        search.setMsg("很抱歉，查无此人，请确定正确信息后重新输入查询");
        return search;
    }

    /**
     * 查询成功返回结果
     * @param user
     * @return
     */
    public static Result Search_success(List<User> user){
        Result search_success = new Result();
        search_success.setData(user);
        return search_success;
    }
}
