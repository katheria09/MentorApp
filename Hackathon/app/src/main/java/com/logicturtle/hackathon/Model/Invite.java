package com.logicturtle.hackathon.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kunwar on 7/9/17.
 */

public class Invite {

    @Expose
    @SerializedName("id")
    int id;

    @Expose
    @SerializedName("student_status")
    String studentStatus;

    @Expose
    @SerializedName("mentor_status")
    String mentorStatus;

    @Expose
    @SerializedName("student_id")
    String studentId;

    @Expose
    @SerializedName("mentor_id")
    String mentorId;

    @Expose
    @SerializedName("student")
    Student student;


    @Expose
    @SerializedName("mentor")
    Mentor mentor;


    private class Student {

        @Expose
        @SerializedName("data")
        StudentData data;


        private class StudentData {

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
    }

    private class Mentor {

        @Expose
        @SerializedName("data")
        private List<MentorDetails> details;


        public List<MentorDetails> getDetails() {
            return details;
        }
    }

    private class MentorDetails {

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

}
