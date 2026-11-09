package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data //自动生成getter,setter等方法。
@TableName("user")
public class User {
    @TableId(value = "UserId",type = IdType.ASSIGN_ID)
    private Long UserId;
    @TableField("UserName")
    private String UserName;
    @TableField("PassWord")
    private String Password;
    @TableField("Email")
    private String Email;
    @TableField("CreateTime")
    private String CreateTime;
}
