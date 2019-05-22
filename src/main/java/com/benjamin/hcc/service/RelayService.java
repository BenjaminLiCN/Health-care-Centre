package com.benjamin.hcc.service;

import com.alibaba.fastjson.JSONObject;
import com.benjamin.hcc.dto.UserContextDTO;
import com.benjamin.hcc.dto.UserDTO;
import com.benjamin.hcc.dto.UserRegisterReqDTO;

/**
 * @author Benjamin Li li.benjamincn@gmail.com
 * @date 2018/8/9 14:04
 */
@org.springframework.stereotype.Service
public interface RelayService {
    /**
     * Register an account
     * @return
     */
    void execute(JSONObject message);
}
