package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("linked_list")
public class linked_list {
    private String studenId;
    private int userId;
    private int noteId;
}
