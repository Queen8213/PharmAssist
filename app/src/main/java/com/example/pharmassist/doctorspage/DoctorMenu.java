package com.example.pharmassist.doctorspage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pharmassist.R;

public class DoctorMenu extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_menu);
        button =findViewById(R.id.button);
        Intent i = getIntent();
        String id =i.getStringExtra("userId");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DoctorMenu.this, AddPrescription.class);
                i.putExtra("ID",id);
                startActivity(i);

            }
        });
    }
}