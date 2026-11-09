package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("note_information")
public class note_information {
    private String Course;
    private String Title;
    private String TextConten;
    private String Attachment;
    private int NoteId;
    private int NumberOfLike;
    private int NumberOfDownLoad;
}
