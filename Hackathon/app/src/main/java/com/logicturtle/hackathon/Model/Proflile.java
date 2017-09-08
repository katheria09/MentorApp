package com.logicturtle.hackathon.Model;

/**
 * Created by kunwar on 7/9/17.
 */

public class Proflile {


    public String name;


    public String email;


    public String techs;


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTechs() {
        return techs;
    }

    public Proflile(String name, String email, String techs) {
        this.name = name;
        this.email = email;
        this.techs = techs;
    }
}
