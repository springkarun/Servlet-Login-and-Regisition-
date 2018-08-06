package com.sawan.model;

public class RegisterModel {

    private String user_id;
    private String fname;
    private String lname;
    private String email;
    private String mobile;
    private String age;
    private String sex;
    private String password;
    private String city;
    private String address;

    public RegisterModel() { }

    public RegisterModel(String user_id, String fname, String lname, String email, String mobile, String age, String sex, String password, String city, String address) {
        this.user_id = user_id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.mobile = mobile;
        this.age = age;
        this.sex = sex;
        this.password = password;
        this.city = city;
        this.address = address;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getPassword() {
        return password;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}