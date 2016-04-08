package com.example.allen.volleymanager.entity;

/**
 * Created by Allen Lin on 2016/02/17.
 */
//实体类
public class Person {

    private String gender;

    private String first_name;

    private String last_name;


    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    @Override
    public String toString() {
        return this.first_name + " " + last_name + " " + gender;
    }
}
