package com.example.wishcloud.model;

public class UserModel {

    private String name;
    private String username;
    private int userId;
    private String password;


    public UserModel(String name, String username, int userId, String password){
        this.name = name;
        this.username = username;
        this.userId = userId;
        this.password = password;
    }

    public UserModel() {

    }

    public String getName(){
        return name;
    }

    public String getUsername(){
        return username;
    }

    public int getUserId(){
        return userId;
    }

    public String getPassword(){
        return password;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public void setPassword(String password){
        this.password = password;
    }


}
