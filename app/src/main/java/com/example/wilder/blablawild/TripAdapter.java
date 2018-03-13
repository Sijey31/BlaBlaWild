package com.example.wilder.blablawild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by wilder on 06/03/18.
 */
public class TripAdapter extends ArrayAdapter<TripModel>
{

    public TripAdapter(Context context, ArrayList<TripModel> trips)
    {
        super(context, 0, trips);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Get the data item for this position
        TripModel trip = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_trip, parent, false);
        }
        // Lookup view for data population
        TextView firstName = (TextView) convertView.findViewById(R.id.text_firstname);
        TextView lastName = (TextView) convertView.findViewById(R.id.text_lastname);
        TextView textDate = (TextView) convertView.findViewById(R.id.text_date);
        TextView textPrice = (TextView) convertView.findViewById(R.id.text_price);
        // Populate the data into the template view using the data object
        firstName.setText(trip.getFirstname());
        lastName.setText(trip.getLastname());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String dateformat = sdf.format(trip.getDate());
        String date = dateformat + "PM";
        textDate.setText(date);
        String price = "$" +String.valueOf(trip.getPrice());
        textPrice.setText(price);

        return convertView;
    }
}