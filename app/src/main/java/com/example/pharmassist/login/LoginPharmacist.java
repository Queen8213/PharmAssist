package com.example.pharmassist.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pharmassist.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginPharmacist extends AppCompatActivity {

    EditText edtemail;
    EditText edtpassword;
    Button loginButton;

    MyApiPharmacist myApiPharmacist;

    String email;
    String password;
    private static final String BaseUrl = "https://lamp.ms.wits.ac.za/home/s2684367/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pharmacist);

        edtemail = findViewById(R.id.email_edit_text);
        edtpassword = findViewById(R.id.password_edit_text);
        loginButton = findViewById(R.id.Login_button);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myApiPharmacist = retrofit.create(MyApiPharmacist.class);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginUser();
            }
        });

    }
    private void loginUser() {
        email = edtemail.getText().toString();
        password = edtpassword.getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(LoginPharmacist.this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
            return;
        }

        Call<User> call = myApiPharmacist.loginUser(email, password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() && response.body() != null) {
                    User user = response.body();
                    if ("ok".equals(user.getResponse())) {
                        // Login successful, proceed with the user ID
                        String userId = user.getId();
                        // Navigate to the next activity
                        Intent intent = new Intent(LoginPharmacist.this, ChooseUser.class); // Replace NextActivity with your target activity
                        intent.putExtra("userId", userId);
                        startActivity(intent);

                    } else {
                        // Login failed
                        Toast.makeText(LoginPharmacist.this, "Login failed. Please check your email and password.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Handle the error response
                    Toast.makeText(LoginPharmacist.this, "Error: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Handle the network error or other errors
                Toast.makeText(LoginPharmacist.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}