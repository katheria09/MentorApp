package com.logicturtle.hackathon.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class AllMentors {

    @Expose
    @SerializedName("id")
    int id;

    @Expose
    @SerializedName("name")
    String name;

    @Expose
    @SerializedName("email")
    String email;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
