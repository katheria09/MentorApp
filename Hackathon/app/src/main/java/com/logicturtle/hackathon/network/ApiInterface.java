package com.logicturtle.hackathon.network;


import com.logicturtle.hackathon.Model.MentorSignUp;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {


    @POST("signup/mentor")
    @FormUrlEncoded
    Call<MentorSignUp> signUpMentor(@Field("name") String username,
                                    @Field("email") String email,
                                    @Field("password") String password

    );


}
