package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("students")
public class Student {
    private String studentNumber;
    private String studenName;
    private String University;
    private String College;
    private String Major;
    private String ClassName;
}
