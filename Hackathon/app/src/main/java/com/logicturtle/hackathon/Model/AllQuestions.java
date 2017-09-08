package com.logicturtle.hackathon.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class AllQuestions {

    @Expose
    @SerializedName("ques_id")
    int quesId;

    @Expose
    @SerializedName("student_id")
    String studentId;

    @Expose
    @SerializedName("question")
    String question;

    @Expose
    @SerializedName("technology")
    String technology;

    @Expose
    @SerializedName("weight")
    int weight;


    @Expose
    @SerializedName("student")
    Student student;


    public int getQuesId() {
        return quesId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getQuestion() {
        return question;
    }

    public String getTechnology() {
        return technology;
    }

    public int getWeight() {
        return weight;
    }

    public Student getStudent() {
        return student;
    }

    private class Student {

        @Expose
        @SerializedName("data")
        StudentData data;


        public class StudentData {

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
}
