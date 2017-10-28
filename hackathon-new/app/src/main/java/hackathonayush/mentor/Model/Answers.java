package hackathonayush.mentor.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kunwar on 7/9/17.
 */

public class Answers {


    @Expose
    @SerializedName("id")
    int id;

    @Expose
    @SerializedName("question_id")
    String questionId;

    @Expose
    @SerializedName("mentor_id")
    String mentorId;

    @Expose
    @SerializedName("answer")
    String answer;

    @Expose
    @SerializedName("upvote")
    int upvote;

    @Expose
    @SerializedName("downvote")
    int downvote;

    @Expose
    @SerializedName("weight")
    int weight;

    @Expose
    @SerializedName("karma_points")
    int karma;

    @Expose
    @SerializedName("mentor")
    Mentor mentor;


    public int getId() {
        return id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public String getMentorId() {
        return mentorId;
    }

    public String getAnswer() {
        return answer;
    }

    public int getUpvote() {
        return upvote;
    }

    public int getDownvote() {
        return downvote;
    }

    public int getWeight() {
        return weight;
    }

    public int getKarma() {
        return karma;
    }

    public Mentor getMentor() {
        return mentor;
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
