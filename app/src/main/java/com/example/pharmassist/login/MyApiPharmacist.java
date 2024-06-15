package com.example.pharmassist.login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MyApiPharmacist {

    @FormUrlEncoded
    @POST("loginpharmacist.php")
    Call<User> loginUser(
            @Field("email") String email,
            @Field("password") String password
    );
}
