package com.benjamin.wte.dto;


/**
 * @author Benjamin Li li.benjamincn@gmail.com
 * @date 2018/8/9 14:02
 */
public class RegisterDTO {
    public RegisterDTO(){

    }
    @Override
    public String toString() {
        return "RegisterDTO{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    private String username;
    private String password;
    private String email;


    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassWord() {
        return password;
    }

    public void setPassWord(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
