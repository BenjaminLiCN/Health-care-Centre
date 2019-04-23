package com.benjamin.hcc.dto;


/**
 * @author Benjamin Li li.benjamincn@gmail.com
 * @date 2018/8/9 14:02
 */
public class UserDTO {
    public UserDTO(){

    }
    @Override
    public String toString() {
        return "RegisterDTO{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
