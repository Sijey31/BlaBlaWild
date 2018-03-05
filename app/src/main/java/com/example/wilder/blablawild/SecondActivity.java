package com.example.wilder.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button buttonsearch = findViewById(R.id.button_search);
        buttonsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editdeparture = findViewById(R.id.edit_departure);
                String departure = editdeparture.getText().toString();
                EditText editname = findViewById(R.id.edit_name);
                String name = editname.getText().toString();
                EditText editdate = findViewById(R.id.edit_date);
                String date = editdate.getText().toString();

                if
                        (departure.equals("") || (name.equals("")))
                {
                    Toast.makeText(SecondActivity.this, "Please fill your departure and destination!",Toast.LENGTH_LONG).show();
                }

                else
                {
                    Intent intent = new Intent(SecondActivity.this,ItineraryListActivity.class);
                    intent.putExtra("extradeparture",departure);
                    intent.putExtra("extraname",name);
                    startActivity(intent);
                }


            }
        });
    }
}

