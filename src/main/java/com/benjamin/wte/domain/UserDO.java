package com.benjamin.wte.domain;
import com.benjamin.wte.core.BaseDO;

import javax.persistence.*;

/**
 * @Auther Benjamin Li li.benjamincn@gmail.com
 * @id 961543
 * @date 2018/9/28下午12:53
 */
@Entity(name = "user_info")
public class UserDO extends BaseDO {

    @Override
    public String toString() {
        return "UserDO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }


    @Column(name = "name",length = 40)
    private String name;
    @Column(name = "username" , unique=true, nullable = false , length = 20)
    private String username;
    @Column(name = "password" , nullable = false , length = 20)
    private String password;
    @Column(name = "email" , length =  40)
    private String email;
    @Column(name = "gender")
    private String gender;
    @Column(name = "phone",length = 15)
    private String phone;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}