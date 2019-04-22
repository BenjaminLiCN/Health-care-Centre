package com.benjamin.wte;

import com.benjamin.wte.dto.*;
import com.benjamin.wte.service.UserService;
import com.benjamin.wte.utils.WebResults;
import com.benjamin.wte.utils.WebUtils;
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
