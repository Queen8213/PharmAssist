package com.example.pharmassist.login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MyPatientApi {
    @FormUrlEncoded
    @POST("loginpatient.php") // Replace with your login PHP script path
    Call<User> loginUser(
            @Field("email") String email,
            @Field("password") String password
    );
}
