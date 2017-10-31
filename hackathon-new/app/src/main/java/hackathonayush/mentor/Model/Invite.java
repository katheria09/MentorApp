package hackathonayush.mentor.Model;

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

    public int getId() {
        return id;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public String getMentorStatus() {
        return mentorStatus;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getMentorId() {
        return mentorId;
    }

    public Student getStudent() {
        return student;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public class Student {

        @Expose
        @SerializedName("data")
        StudentData data;

        public StudentData getData() {
            return data;
        }

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

    public class Mentor {

        @Expose
        @SerializedName("data")
        private MentorDetails details;


        public MentorDetails getDetails() {
            return details;
        }
    }

    public class MentorDetails {

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
