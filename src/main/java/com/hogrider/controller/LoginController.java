package com.hogrider.controller;

import com.hogrider.pojo.User;
import com.hogrider.result.Result;
import com.hogrider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {

    @Autowired
    UserService userService;


    @PostMapping(value = "/login")
    public Result login(@RequestBody User requestUser, HttpSession session) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
        if(null == user){
            return new Result(400);
        }else {
            session.setAttribute("user", user);
            return new Result(200);
        }
    }
}
