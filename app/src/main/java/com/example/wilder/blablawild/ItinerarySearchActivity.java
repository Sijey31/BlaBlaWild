package com.example.wilder.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ItinerarySearchActivity extends AppCompatActivity
{
    public static String EXTRA_SEARCH_MODEL = "EXTRA_SEARCH_MODEL";

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);
        final EditText editdate = findViewById(R.id.edit_date);
        final EditText editdeparture = findViewById(R.id.edit_departure);
        final EditText editname = findViewById(R.id.edit_name);

        Button buttonsearch = findViewById(R.id.button_search);
        buttonsearch.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {

                String departure = editdeparture.getText().toString();
                String name = editname.getText().toString();
                String date = editdate.getText().toString();

                if (departure.equals("") || (name.equals("")))
                {
                    Toast.makeText(ItinerarySearchActivity.this, "Please fill your departure and destination!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    SearchModel searchModel = new SearchModel(departure, name, date);
                    Intent intent = new Intent(ItinerarySearchActivity.this, ItineraryListActivity.class);
                    intent.putExtra(EXTRA_SEARCH_MODEL, searchModel);
                    startActivity(intent);
                }
            }
        });

        final Calendar mycalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener datePicker = new DatePickerDialog.OnDateSetListener()
        {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)

            {
                mycalendar.set(Calendar.YEAR, year);
                mycalendar.set(Calendar.MONTH, month);
                mycalendar.set(Calendar.DAY_OF_MONTH, day);
                updateLabel(editdate,mycalendar);
            }
        };

        editdate.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                new DatePickerDialog(ItinerarySearchActivity.this, datePicker, mycalendar.get(Calendar.YEAR),
                        mycalendar.get(Calendar.MONTH),mycalendar.get(Calendar.DAY_OF_MONTH)).show();
            }

        });
    }
    private void updateLabel(EditText edittext, Calendar mycalendar)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
        edittext.setText(sdf.format(mycalendar.getTime()));
    }
}

