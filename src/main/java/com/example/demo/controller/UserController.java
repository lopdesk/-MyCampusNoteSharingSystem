package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
@RequiredArgsConstructor
public class UserController {
    private final UserSevice userSevice;

    @PostMapping("/regist")
    public String Register(@RequestBody User user){
        BCryptPasswordEncoder Encryption = new BCryptPasswordEncoder();
        user.setPassword(Encryption.encode(user.getPassword()));
        userSevice.save(user);
        return "注册成功，很高兴您能使用本系统" + user.getUserName();
    }

    @PostMapping("/login")
    public String Login(@RequestBody User user){
        BCryptPasswordEncoder Encryption = new BCryptPasswordEncoder();
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        User Tuser = userSevice.getOne(lambdaQueryWrapper.eq(User::getUserId, user.getUserId()));
        if (Tuser == null){
            return "无该用户";
        }
        else if (!Tuser.getPassword().equals(Encryption.encode(user.getPassword()))){
            return "密码错误";
        }
        else{
            return "登录成功，欢迎回来" + Tuser.getUserName();
        }
    }

    @GetMapping("/Search")
    public Result Search(@RequestParam String UserName){
        LambdaQueryWrapper<User> wrapper =  Wrappers.lambdaQuery();
        wrapper.like(UserName != null && !UserName.trim().isEmpty(), User::getUserName, UserName);
        List<User> user = userSevice.list(wrapper);
        if (user.isEmpty()){

            return Result.Search_fail();
        }
        else {
            return Result.Search_success(user);
        }
    }

}
