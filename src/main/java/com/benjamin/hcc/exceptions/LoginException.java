package com.benjamin.hcc.exceptions;

/**
 * @Auther Benjamin Li li.benjamincn@gmail.com
 * @id 961543
 * @date 2018/9/30下午9:26
 */
public class LoginException extends RuntimeException {
    public LoginException(String message){
        super(message);
    }
}
