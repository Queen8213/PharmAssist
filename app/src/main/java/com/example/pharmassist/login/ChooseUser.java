package com.example.pharmassist.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.pharmassist.R;

public class ChooseUser extends AppCompatActivity {
    CardView doctor;
    CardView pharmacist;
    CardView patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user);
        patient =findViewById(R.id.patient);
        doctor =findViewById(R.id.doctor);
        pharmacist =findViewById(R.id.pharmacist);

        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ChooseUser.this, Patientsignup.class);
                startActivity(i);
            }
        });

        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(ChooseUser.this, DoctorSignup.class);
                startActivity(i);
            }
        });

        pharmacist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChooseUser.this, Pharmacistsignup.class);
                startActivity(i);

            }
        });
    }
}