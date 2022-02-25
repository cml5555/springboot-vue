package com.cml.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@TableName("sys_user")
public class User {
    private String username;
    @JsonIgnore
    private String password;
    @TableField(value = "phoneNum")
    private String phoneNum;
    private String email;
    private Integer id;

//    public User(String username, String password, String phoneNum, String email, int id) {
//        this.username = username;
//
//        this.password = password;
//        this.phoneNum = phoneNum;
//        this.email = email;
//        this.id = id;
//    }
//    public User(){}
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", phoneNum='" + phoneNum + '\'' +
//                ", email='" + email + '\'' +
//                ", id=" + id +
//                '}';
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public User(String username, String password, String phoneNum, String email) {
//        this.username = username;
//        this.password = password;
//        this.phoneNum = phoneNum;
//        this.email = email;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void setPhoneNum(String phoneNum) {
//        this.phoneNum = phoneNum;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public String getPhoneNum() {
//        return phoneNum;
//    }
//
//    public String getEmail() {
//        return email;
//    }
}
