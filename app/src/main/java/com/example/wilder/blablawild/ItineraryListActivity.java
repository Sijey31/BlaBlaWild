package com.example.wilder.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static com.example.wilder.blablawild.ItinerarySearchActivity.EXTRA_SEARCH_MODEL;

public class ItineraryListActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        SearchModel searchModel = getIntent().getExtras().getParcelable(EXTRA_SEARCH_MODEL);

        setTitle(searchModel.getDeparture() + " >> " + searchModel.getDestination());

        Toast.makeText(this, searchModel.getDate(), Toast.LENGTH_SHORT).show();

        ListView listTrip = findViewById(R.id.list_view);
        ArrayList<TripModel> results = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");

        try
        {
            results.add(new TripModel("Eric", "Cartman", sdf.parse("21/02/2017-15:30"), 15));
            results.add(new TripModel("Stan", "Marsh", sdf.parse("21/02/2017-16:00"), 20));
            results.add(new TripModel("Kenny", "Broflovski", sdf.parse("21/02/2017-16:30"), 16));
            results.add(new TripModel("Kyle", "McCormick", sdf.parse("21/02/2017-17:00"), 40));
            results.add(new TripModel("Wendy", "Testaburger", sdf.parse("21/02/2017-17:30"), 20));
        } catch (ParseException e) {}

        TripAdapter adapter = new TripAdapter(this, results);
        listTrip.setAdapter(adapter);
    }



}
