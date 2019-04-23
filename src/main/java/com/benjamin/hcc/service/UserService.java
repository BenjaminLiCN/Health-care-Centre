package com.benjamin.hcc.service;

import com.benjamin.hcc.dto.UserContextDTO;
import com.benjamin.hcc.dto.UserDTO;
import com.benjamin.hcc.dto.UserRegisterReqDTO;

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
