package hackathonayush.mentor.network;


import hackathonayush.mentor.Model.AllMentors;
import hackathonayush.mentor.Model.AllQuestions;
import hackathonayush.mentor.Model.Answers;
import hackathonayush.mentor.Model.Invite;
import hackathonayush.mentor.Model.MentorDetails;
import hackathonayush.mentor.Model.MentorLogin;
import hackathonayush.mentor.Model.MentorSignUp;
import hackathonayush.mentor.Model.StudentLogin;
import hackathonayush.mentor.Model.StudentSignUp;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {


    @POST("signup/mentor")
    @FormUrlEncoded
    Call<ItemResponse<MentorSignUp>> signUpMentor(@Field("name") String username,
                                                  @Field("email") String email,
                                                  @Field("password") String password

    );


    @POST("signup/student")
    @FormUrlEncoded
    Call<ItemResponse<StudentSignUp>> signUpStudent(@Field("name") String username,
                                                    @Field("email") String email,
                                                    @Field("password") String password

    );

    @GET("authenticate/mentor")
    Call<ItemResponse<MentorLogin>> loginMentor(@Query("email") String email,
                                                @Query("password") String password

    );


    @GET("authenticate/student")
    Call<ItemResponse<StudentLogin>> loginStudent(@Query("email") String email,
                                                  @Query("password") String password

    );


    @GET("mentor/all")
    Call<ListResponse<AllMentors>> getAllMentors();


    @POST("invite")
    @FormUrlEncoded
    Call<ItemResponse<Invite>> getInvites(@Field("student_id") String studentId,
                                          @Field("mentor_id") String mentorId,
                                          @Field("student_status") String studentStatus,
                                          @Field("mentor_status") String mentorStatus

    );

    @GET("question/student/{student_id}")
    Call<ListResponse<AllQuestions>> getQuestions(@Path("student_id") int id);

    @GET("question/all")
    Call<ListResponse<AllQuestions>> getQuestionsTrending();

    @GET("answer/{question_id}")
    Call<ListResponse<Answers>> getAnswers(@Path("question_id") String ques_id);

    @POST("answer/upvote/{answer_id}")
    @FormUrlEncoded
    Call<Void> upvote(@Path("answer_id") int answer_id);

    @POST("answer/downvote/{answer_id}")
    Call<Void> downvote(@Path("answer_id") int answer_id);


    @GET("mentor/{mentor_id}")
    Call<ItemResponse<MentorDetails>> getMentor(@Path("mentor_id") int id);


    @POST("invite")
    @FormUrlEncoded
    Call<ItemResponse<Invite>> sendInvite(@Field("student_id") int studentId,
                                          @Field("mentor_id") int mentorId,
                                          @Field("mentor_status") String mentorStatus,
                                          @Field("student_status") String studentStatus
    );

    @GET("invite/student/{student_id}")
    Call<ListResponse<Invite>> getInvites(@Path("student_id") int id);
}
