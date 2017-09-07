package com.logicturtle.hackathon.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class MentorSignUp {

    @Expose
    @SerializedName("name")
    String name;

    @Expose
    @SerializedName("email")
    String email;

    @Expose
    @SerializedName("registration")
    String status;


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }
}
