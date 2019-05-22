package com.benjamin.hcc.controllers;

import com.alibaba.fastjson.JSONObject;
import com.benjamin.hcc.dto.UserDTO;
import com.benjamin.hcc.dto.UserRegisterReqDTO;
import com.benjamin.hcc.service.RelayService;
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
public class RelayController {
    @Autowired
    private RelayService service;
    @PostMapping("relay")
    public WebResults register(@RequestBody JSONObject message) {
        service.execute(message);
        return WebUtils.success();
    }


}
