package com.example.wilder.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String departList = intent.getStringExtra("extradeparture");
        String departName = intent.getStringExtra("extraname");
        setTitle(departList+" >> "+departName);


    }
}
