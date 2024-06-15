package com.example.pharmassist.doctorspage;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiPrescription {
    @FormUrlEncoded
    @POST("makeprescription.php")
    Call<ModelClass> insertdata(
            @Field("patientId") int patientId,
            @Field("doctorId") int doctorId
    );
}
