package com.example.pharmassist.doctorspage;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("insert_prescription.php")
    Call<MedicationResponse> insertMedication(
            @Field("prescription_id") int prescriptionId,
            @Field("medication_id") int medicationId,
            @Field("dosage") String dosage,
            @Field("frequency") String frequency,
            @Field("amount") int amount,
            @Field("instructions") String instructions,
            @Field("refills") int refills
    );
}
