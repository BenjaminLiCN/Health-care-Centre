package com.benjamin.hcc;

import com.benjamin.hcc.dto.UserDTO;
import com.benjamin.hcc.dto.UserRegisterReqDTO;
import com.benjamin.hcc.service.UserService;
import com.benjamin.hcc.utils.WebResults;
import com.benjamin.hcc.utils.WebUtils;
import com.benjamin.hcc.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("getMyUserContext")
    public WebResults getMyUserContext(){
        return WebUtils.success(userService.getMyUserContext());
    }
}
