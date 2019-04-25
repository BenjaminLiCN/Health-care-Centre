package com.benjamin.hcc.controllers;

import com.benjamin.hcc.dto.UserDTO;
import com.benjamin.hcc.dto.UserRegisterReqDTO;
import com.benjamin.hcc.service.UserService;
import com.benjamin.hcc.utils.WebResults;
import com.benjamin.hcc.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public WebResults register(@RequestBody UserRegisterReqDTO userRegisterReqDTO) {
        userService.register(userRegisterReqDTO);
        return WebUtils.success();
    }
    @PostMapping("refresh")
    public WebResults refreshToken(){
        String newToken = userService.refreshToken();
        return WebUtils.success(newToken);
    }
    @PostMapping("login")
    public WebResults login(@RequestBody UserDTO userDTO){
        String token = userService.getTokenByLogin(userDTO);
        return WebUtils.success(token);
    }
    @PostMapping("getUser")
    public WebResults getMyUserContext(){
        return WebUtils.success(userService.getMyUserContext());
    }
    //this interface will be used by admin
    //to be finished
    @GetMapping("getUsers")
    public WebResults getAllUsers(){
        return WebUtils.success();
    }

}
