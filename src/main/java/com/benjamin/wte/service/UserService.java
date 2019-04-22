package com.benjamin.wte.service;

import com.benjamin.wte.dto.RegisterDTO;
import com.benjamin.wte.dto.UserContextDTO;
import com.benjamin.wte.dto.UserDTO;
import com.benjamin.wte.dto.UserRegisterReqDTO;

import java.util.List;

/**
 * @author Benjamin Li li.benjamincn@gmail.com
 * @date 2018/8/9 14:04
 */
@org.springframework.stereotype.Service
public interface UserService {


    /**
     * Login(return JwtToken)
     * @param userDTO
     * @return
     */
    String getTokenByLogin(UserDTO userDTO);

    /**
     * refreshToken
     * @return
     */
    String refreshToken();

    /**
     * Get user information by id
     * @param id
     * @return
     */
    UserContextDTO getUserContextById(String id);

    /**
     * Get current user information
     * @return
     */
    UserContextDTO getMyUserContext();

    /**
     * Register an account
     * @return
     */
    void register(UserRegisterReqDTO userRegisterReqDTO);

}
