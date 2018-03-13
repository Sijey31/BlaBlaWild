package com.example.wilder.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonitinerary = findViewById(R.id.button_itinerary);
        buttonitinerary.setOnClickListener(new View.OnClickListener()
            {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this,ItinerarySearchActivity.class));
            }
            });
        Button buttongo = findViewById(R.id.button_go);
        buttongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this,VehicleActivity.class));
            }
        });
    }

}
