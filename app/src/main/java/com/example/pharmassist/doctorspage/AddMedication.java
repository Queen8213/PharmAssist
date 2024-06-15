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

public class AddMedication extends AppCompatActivity {
    EditText medicationid;
    EditText dosage;
    EditText frequency;
    EditText amount;
    EditText instructions;
    EditText refills;

    Button add;
    Button finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medication);
        medicationid = findViewById(R.id.medicationid);
        dosage = findViewById(R.id.dosage);
        frequency = findViewById(R.id.frequency);
        amount = findViewById(R.id.amount);
        instructions = findViewById(R.id.instruction);
        refills = findViewById(R.id.refills);
        add = findViewById(R.id.addmedication);
        finish = findViewById(R.id.finish);

        Intent i = getIntent();
        int prescriptionid = i.getIntExtra("prescriptionId", 0);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int medicationId = Integer.parseInt(medicationid.getText().toString());
                String dosageStr = dosage.getText().toString();
                String frequencyStr = frequency.getText().toString();
                int amountInt = Integer.parseInt(amount.getText().toString());
                String instructionsStr = instructions.getText().toString();
                int refillsInt = Integer.parseInt(refills.getText().toString());

                // Send data to PHP script
                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                Call<MedicationResponse> call = apiService.insertMedication(
                        prescriptionid, medicationId, dosageStr, frequencyStr, amountInt, instructionsStr, refillsInt
                );

                call.enqueue(new Callback<MedicationResponse>() {
                    @Override
                    public void onResponse(Call<MedicationResponse> call, Response<MedicationResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            MedicationResponse medicationResponse = response.body();
                            Toast.makeText(AddMedication.this, "Response from server: " + medicationResponse.getMessage(), Toast.LENGTH_LONG).show();
                            if ("true".equals(medicationResponse.getSuccess())) {
                                clearFields();
                            }
                        } else {
                            Toast.makeText(AddMedication.this, "Error: " + response.message(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<MedicationResponse> call, Throwable t) {
                        Toast.makeText(AddMedication.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddMedication.this, ChooseUser.class);
                startActivity(i);
            }
        });
    }

    private void clearFields() {
        medicationid.setText("");
        dosage.setText("");
        frequency.setText("");
        amount.setText("");
        instructions.setText("");
        refills.setText("");
    }
}
