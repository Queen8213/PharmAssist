package com.example.pharmassist.patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pharmassist.R;
import com.example.pharmassist.pharmacy.NearbyPharmacies;
import com.example.pharmassist.profile.Grid;
import com.example.pharmassist.store.OrderPage;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Link the store (convinience) to the store activity
        ImageButton store = findViewById(R.id.imageStore);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrderPage.class);
                startActivity(intent);

            }
        });
        //This is for the healthy tips
        recyclerViewList = findViewById(R.id.view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        ArrayList<ListDomain> articles = new ArrayList<>();
        articles.add(new ListDomain("Stay hydrated!", "hydrate"));
        articles.add(new ListDomain("Keep it moving!", "exercise"));
        articles.add(new ListDomain("Eat Healthy", "diet"));
        articles.add(new ListDomain("Get enough sleep", "sleep"));
        adapter = new DashboardAdapter(articles);
        recyclerViewList.setAdapter(adapter);

        //link to shop
        TextView view1 = findViewById(R.id.textView6);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrderPage.class);
                startActivity(intent);

            }
        });
            //link to pharmacies
        ImageButton image = findViewById(R.id.imagePharm);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent n = new Intent(MainActivity.this, NearbyPharmacies.class);
               startActivity(n);
            }
        });

        ImageButton image2 = findViewById(R.id.imageProf);
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n = new Intent(MainActivity.this, Grid.class);
                startActivity(n);
            }
        });


    }
}