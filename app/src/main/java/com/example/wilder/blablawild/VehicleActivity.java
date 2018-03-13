package com.example.wilder.blablawild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class VehicleActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);


        Spinner spinner = findViewById(R.id.spinner_vehicle);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_vehicle,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final EditText brand = findViewById(R.id.editBrand);
        final EditText model = findViewById(R.id.editModel);
        final EditText speed = findViewById(R.id.editSpeed);
        final Button buttonSend = findViewById(R.id.buttonSend);
        final EditText km = findViewById(R.id.editKm);
        final EditText hours = findViewById(R.id.editHours);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected (AdapterView < ? > adapterView, View view,int pos, long l)
            {


                if (pos == 1)
                {
                    km.setVisibility(View.VISIBLE);
                    hours.setVisibility(View.GONE);
                    speed.setVisibility(View.GONE);
                    buttonSend.setEnabled(true);
                    buttonSend.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick (View view)
                        {
                            String sBrand = brand.getText().toString();
                            String sModel = model.getText().toString();
                            String sKm = km.getText().toString();
                            int km = 0;
                            if (!sKm.isEmpty())
                            {
                                km = Integer.parseInt(sKm);
                            }
                            VehicleCar car = new VehicleCar(sBrand, sModel, km);
                            Toast.makeText(VehicleActivity.this, car.getDescription(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else if (pos == 2)
                {
                    hours.setVisibility(View.VISIBLE);
                    km.setVisibility(View.GONE);
                    speed.setVisibility(View.GONE);
                    buttonSend.setEnabled(true);

                    buttonSend.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick (View view)
                        {
                            String sBrand = brand.getText().toString();
                            String sModel = model.getText().toString();
                            String sHours = hours.getText().toString();
                            int hours = 0;
                            if (!sHours.isEmpty())
                            {
                                hours = Integer.parseInt(sHours);
                            }
                            VehicleBoat boat = new VehicleBoat(sBrand, sModel, hours);
                            Toast.makeText(VehicleActivity.this, boat.getDescription(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                else if (pos == 3)
                {
                    speed.setVisibility(View.VISIBLE);
                    km.setVisibility(View.GONE);
                    hours.setVisibility(View.GONE);
                    buttonSend.setEnabled(true);

                    buttonSend.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick (View view)
                        {
                            String sBrand = brand.getText().toString();
                            String sModel = model.getText().toString();
                            String sSpeed = speed.getText().toString();
                            int speed = 0;
                            if (!sSpeed.isEmpty())
                            {
                                speed = Integer.parseInt(sSpeed);
                            }
                            VehiclePlane plane = new VehiclePlane(sBrand, sModel, speed);
                            Toast.makeText(VehicleActivity.this, plane.getDescription(), Toast.LENGTH_SHORT).show();
                        }
                    });


                }
                else
                {
                    km.setVisibility(View.GONE);
                    hours.setVisibility(View.GONE);
                    speed.setVisibility(View.GONE);
                    buttonSend.setEnabled(false);
                }

            }
            public void onNothingSelected (AdapterView < ? > parent){}
        });
    }
}



