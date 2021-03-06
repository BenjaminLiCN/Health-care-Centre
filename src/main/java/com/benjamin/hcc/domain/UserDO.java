package com.benjamin.hcc.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.benjamin.hcc.core.BaseDO;

@Entity(name = "user_info")
public class UserDO{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @Override
    public String toString() {
        return "UserDO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public UserDO(){
        this.isAdmin = 0;
    }


    @OneToMany(mappedBy = "userDO", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy(value = "id ASC")
    private Set<BookingDO> userBookings = new HashSet<>();

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
    @Column(name = "number",length = 15)
    private String number;
    @Column(name = "homeAddress",length = 100)
    private String homeAddress;
    @Column(name = "is_admin")
    private int isAdmin;

    public int getIsAdmin(){
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin){
        this.isAdmin = isAdmin;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

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

    public String getNumber() {
        return number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}