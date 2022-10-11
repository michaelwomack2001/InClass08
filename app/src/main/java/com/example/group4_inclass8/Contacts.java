package com.example.group4_inclass8;

public class Contacts {

    private String name;
    private String email;
    private String phoneNum;
    private String type;

    public Contacts(String name, String email, String phoneNum, String type){
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.type = type;
    }

    //Getters
    public String getName(){
        return this.name;
    }
    public String  getEmail(){
        return this.email;
    }
    public String getPhoneNum(){
        return this.phoneNum;
    }
    public String getType(){
        return this.type;
    }
}
