package com.example.pharmassist.login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MyApi22 {

    @FormUrlEncoded
    @POST("signuppatient.php")
    Call<Model> insertdata(
            @Field("email")String email, @Field("password")String password
    );
}
