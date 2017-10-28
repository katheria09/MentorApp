package hackathonayush.mentor.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kunwar on 7/9/17.
 */

public class StudentLogin {

    @Expose
    @SerializedName("id")
    int id;

    @Expose
    @SerializedName("name")
    String name;

    @Expose
    @SerializedName("email")
    String email;

    @Expose
    @SerializedName("validation")
    String validation;


    public int getId() {
        return id;
    }

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
