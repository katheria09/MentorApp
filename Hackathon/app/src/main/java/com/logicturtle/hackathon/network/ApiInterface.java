package com.logicturtle.hackathon.network;


import com.logicturtle.hackathon.Model.AllMentors;
import com.logicturtle.hackathon.Model.Invite;
import com.logicturtle.hackathon.Model.MentorLogin;
import com.logicturtle.hackathon.Model.MentorSignUp;
import com.logicturtle.hackathon.Model.StudentLogin;
import com.logicturtle.hackathon.Model.StudentSignUp;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

}
