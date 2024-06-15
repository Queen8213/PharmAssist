package com.example.pharmassist.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pharmassist.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DoctorSignup extends AppCompatActivity {

    EditText edtemail;
    EditText edtpassword;
    EditText edtpasswordconfirm;
    Button signup;

    MyApi myApi;
    String email;
    String password;
    String passwordconfirm;
    TextView movelogin;

    private static final String BaseUrl = "https://lamp.ms.wits.ac.za/home/s2684367/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_signup);

        edtemail = findViewById(R.id.email_edit_text);
        edtpassword = findViewById(R.id.password_edit_text);
        edtpasswordconfirm = findViewById(R.id.confirmpassword);
        signup = findViewById(R.id.signup_button);
        movelogin = findViewById(R.id.signup_text);

        movelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DoctorSignup.this, Logindoctor.class);
                startActivity(i);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myApi = retrofit.create(MyApi.class);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerdoctor();
            }

            private void registerdoctor() {
                email = edtemail.getText().toString();
                password = edtpassword.getText().toString();
                passwordconfirm = edtpasswordconfirm.getText().toString();

                if (email.isEmpty()) {
                    edtemail.setError("Please enter an email.");
                } else if (password.isEmpty()) {
                    edtpassword.setError("Please enter a password.");
                } else if (passwordconfirm.isEmpty()) {
                    edtpasswordconfirm.setError("Please confirm your password.");
                } else if (!password.equals(passwordconfirm)) {
                    edtpasswordconfirm.setError("Passwords do not match!");
                } else {
                    Call<Model> modelCall = myApi.insertdata(email, password);
                    modelCall.enqueue(new Callback<Model>() {
                        @Override
                        public void onResponse(Call<Model> call, Response<Model> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                Model model = response.body();
                                if (model.getSuccess().equals("true")) {
                                    Toast.makeText(DoctorSignup.this, "Sign up successful! You can now login.", Toast.LENGTH_SHORT).show();
                                    Intent move = new Intent(DoctorSignup.this, Logindoctor.class);
                                    startActivity(move);
                                } else {
                                    Toast.makeText(DoctorSignup.this, model.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                edtemail.setError("Email already exists");
                            }
                        }

                        @Override
                        public void onFailure(Call<Model> call, Throwable t) {
                            Toast.makeText(DoctorSignup.this, "Failed to sign up. Please try again.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
