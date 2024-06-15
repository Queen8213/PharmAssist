package com.example.pharmassist.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.pharmassist.R;

public class Grid extends AppCompatActivity{

    GridLayout gridLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        setSingleEvent(gridLayout);









    }

    private void setSingleEvent(GridLayout gridLayout) {
        for (int i=0;i< gridLayout.getChildCount(); i++){
            CardView cardView = (CardView) gridLayout.getChildAt(i);
            final int finali = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (finali == 0) {
                        Intent intent = new Intent(Grid.this, personaldetails.class);
                        startActivity(intent);
                    } else if (finali == 1) {
                        Intent intent = new Intent(Grid.this, medicalhistory.class);
                        startActivity(intent);
                    } else if (finali == 2) {
                        Intent intent = new Intent(Grid.this, ongoingtreatment.class);
                        startActivity(intent);
                    } else if (finali == 3) {
                        Intent intent = new Intent(Grid.this, measurement.class);
                        startActivity(intent);
                    } else if (finali == 5) {
                        Intent intent = new Intent(Grid.this, accountsettings.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Grid.this, "No Item", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }
}