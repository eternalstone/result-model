package com.example.result.pojo;

import java.io.Serializable;

/**
 * @Author lijiangzhou
 * @Date 2019/5/29  11:58
 * @ClassName: User
 * @Description: TODO
 */
public class User implements Serializable{

    private String username;

    private String password;

    private int age;

    private String gender;

    private String school;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
