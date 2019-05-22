package com.benjamin.hcc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.benjamin.hcc.dao.UserDAO;
import com.benjamin.hcc.domain.UserDO;
import com.benjamin.hcc.dto.UserContextDTO;
import com.benjamin.hcc.dto.UserDTO;
import com.benjamin.hcc.dto.UserRegisterReqDTO;
import com.benjamin.hcc.exceptions.hccException;
import com.benjamin.hcc.mapper.UserRegisterReqMapper;
import com.benjamin.hcc.service.RelayService;
import com.benjamin.hcc.service.UserService;
import com.benjamin.hcc.utils.SystemVars;
import com.benjamin.hcc.utils.WebUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Path;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther Benjamin Li li.benjamincn@gmail.com
 * @id 961543
 * @date 2018/9/30下午7:19
 */
@org.springframework.stereotype.Service
public class RelayServiceImpl extends BaseServiceImpl implements RelayService {


    @Override
    public void execute(JSONObject message){
        //parse url
        //send it to destination
    }

}