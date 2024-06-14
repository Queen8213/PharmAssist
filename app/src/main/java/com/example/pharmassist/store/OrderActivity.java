package com.example.pharmassist.store;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.pharmassist.R;
import com.example.pharmassist.store.products.Product1;
import com.example.pharmassist.store.products.Product10;
import com.example.pharmassist.store.products.Product11;
import com.example.pharmassist.store.products.Product12;
import com.example.pharmassist.store.products.Product13;
import com.example.pharmassist.store.products.Product14;
import com.example.pharmassist.store.products.Product15;
import com.example.pharmassist.store.products.Product2;
import com.example.pharmassist.store.products.Product3;
import com.example.pharmassist.store.products.Product4;
import com.example.pharmassist.store.products.Product5;
import com.example.pharmassist.store.products.Product6;
import com.example.pharmassist.store.products.Product7;
import com.example.pharmassist.store.products.Product8;
import com.example.pharmassist.store.products.Product9;

public class OrderActivity extends AppCompatActivity {
    CardView view1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order);

        view1 = findViewById(R.id.cardview1);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this,Product1.class);
                startActivity(intent);
            }
        });

        CardView view2 = findViewById(R.id.cardview2);
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, Product2.class);
                startActivity(intent);
            }
        });

        CardView view3 = findViewById(R.id.cardView3);
        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, Product3.class);
                startActivity(intent);
            }
        });

        CardView view4 = findViewById(R.id.cardView4);
        view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, Product4.class);
                startActivity(intent);
            }
        });
        CardView view5 = findViewById(R.id.cardView5);
        view5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, Product5.class);
                startActivity(intent);
            }
        });
        CardView view6 = findViewById(R.id.cardView6);
        view6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, Product6.class);
                startActivity(intent);
            }
        });
        CardView view7 = findViewById(R.id.cardView7);
        view7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, Product7.class);
                startActivity(intent);
            }
        });
        CardView view8 = findViewById(R.id.cardView8);
        view8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, Product8.class);
                startActivity(intent);
            }
        });
        CardView view9 = findViewById(R.id.cardView9);
        view9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, Product9.class);
                startActivity(intent);
            }
        });
        CardView view10 = findViewById(R.id.cardView10);
        view10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, Product10.class);
                startActivity(intent);
            }
        });
    CardView view11 = findViewById(R.id.cardView11);
        view11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, Product11.class);
                startActivity(intent);
            }
        });
        CardView view12 = findViewById(R.id.cardView12);
        view12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, Product12.class);
                startActivity(intent);
            }
        });
        CardView view13 = findViewById(R.id.cardView13);
        view13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, Product13.class);
                startActivity(intent);
            }
        });
        CardView view14 = findViewById(R.id.cardView14);
        view14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, Product14.class);
                startActivity(intent);
            }
        });

        CardView view15 = findViewById(R.id.cardView15);
        view15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, Product15.class);
                startActivity(intent);
            }
        });




    }
}
