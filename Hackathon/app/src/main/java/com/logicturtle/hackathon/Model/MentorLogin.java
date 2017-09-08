package com.logicturtle.hackathon.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MentorLogin {

//    @Expose
//    @SerializedName("id")
//    int id;

    @Expose
    @SerializedName("name")
    String name;

    @Expose
    @SerializedName("email")
    String email;

    @Expose
    @SerializedName("validation")
    String validation;


    public String getName() {

        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getValidation() {
        return validation;
    }
}
