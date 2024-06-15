package com.example.pharmassist.doctorspage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pharmassist.R;
import com.example.pharmassist.login.ChooseUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddPrescription extends AppCompatActivity {
    EditText idpatient;
    Button enter;
    ApiPrescription apiPrescription;
    private static final String BaseUrl = "https://lamp.ms.wits.ac.za/home/s2684367/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_prescription);

        idpatient = findViewById(R.id.confirmpassword); // Ensure this matches your layout
        enter = findViewById(R.id.signup_button);

        Intent i = getIntent();
        String doctorId = i.getStringExtra("ID");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiPrescription = retrofit.create(ApiPrescription.class);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String patientId = idpatient.getText().toString();

                if (patientId.isEmpty()) {
                    Toast.makeText(AddPrescription.this, "Patient ID cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    int patient = Integer.parseInt(patientId);
                    int doctor = Integer.parseInt(doctorId);

                    Call<ModelClass> call = apiPrescription.insertdata(patient, doctor);

                    call.enqueue(new Callback<ModelClass>() {
                        @Override
                        public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                ModelClass modelClass = response.body();
                                if ("true".equals(modelClass.getSuccess())) {
                                    int prescriptionId = modelClass.getPrescription_id();
                                    Toast.makeText(AddPrescription.this, "New prescription sucessfully created you can now add medication to it", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(AddPrescription.this, ChooseUser.class);
                                    intent.putExtra("prescriptionId", prescriptionId);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(AddPrescription.this, modelClass.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(AddPrescription.this, "Error: " + response.message(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ModelClass> call, Throwable t) {
                            Toast.makeText(AddPrescription.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (NumberFormatException e) {
                    Toast.makeText(AddPrescription.this, "Invalid Patient ID", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
