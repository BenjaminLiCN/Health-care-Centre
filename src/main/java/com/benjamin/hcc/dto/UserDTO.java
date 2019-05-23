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
        return "UserDTO{" +
                ", Email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    private String email;
    private String password;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
