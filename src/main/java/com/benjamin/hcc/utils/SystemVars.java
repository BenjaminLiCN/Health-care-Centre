package com.benjamin.hcc.utils;

/**
 * @author Benjamin Li li.benjamincn@gmail.com
 * @date 2018/3/9 9:07
 */
public interface SystemVars {
    /**
     * Jwt使用的签名种子
     */
    public final String JWT_SECRET = "foxzjwtcode";
    /**
     * Jwt验证头部标志
     */
    public final String AUTHENTICATION_HEAD = "Bearer ";
}
