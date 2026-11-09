package com.example.demo.service.impl;

import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.example.demo.entity.note_information;
import com.example.demo.mapper.NoteMapper;
import com.example.demo.service.noteService;
import org.springframework.stereotype.Service;

@Service
public class noteServiceImpl extends ServiceImpl<NoteMapper, note_information> implements noteService {

}
