package com.benjamin.hcc.controllers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.benjamin.hcc.dto.UserContextDTO;
import com.benjamin.hcc.dto.UserDTO;
import com.benjamin.hcc.dto.UserRegisterReqDTO;
import com.benjamin.hcc.service.UserService;
import com.benjamin.hcc.utils.WebResults;
import com.benjamin.hcc.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther Benjamin(Jingyi Li) Li
 * @Email jili@student.unimelb.edu.au
 * @ID 961543
 * @Date 2019-04-20 16:31
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("register")
    public WebResults register(UserRegisterReqDTO userRegisterReqDTO) {
        userService.register(userRegisterReqDTO);
        return WebUtils.success();
    }
    @PostMapping("refresh")
    public WebResults refreshToken(){
        String newToken = userService.refreshToken();
        System.out.println(newToken);

        return WebUtils.success(newToken);
    }

    @PostMapping("update")
    public WebResults updateInfo(UserRegisterReqDTO userRegisterReqDTO){
        userService.updateUserInfo(userRegisterReqDTO);
        return WebUtils.success();
    }

    @RequestMapping(value = "/login", consumes = "application/json")
    public JSONObject login(@RequestBody UserDTO userDTO){
        //String token = userService.getTokenByLogin(userDTO);
        JSONObject user = userService.getUserByLogin(userDTO);
        //System.out.println(token);
        System.out.println(user);
        return user;
    }
    @PostMapping("get")
    public WebResults getMyUserContext(){
        return WebUtils.success(userService.getMyUserContext());
    }
    //this interface will be used by admin
    //to be finished
    @GetMapping("getAll")
    public WebResults getAllUsers(){
        List<UserContextDTO> users = userService.getAllUsers();
        return WebUtils.success(users);
    }



}
