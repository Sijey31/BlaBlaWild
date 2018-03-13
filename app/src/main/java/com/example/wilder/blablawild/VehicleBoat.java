package com.example.wilder.blablawild;

/**
 * Created by wilder on 13/03/18.
 */

public class VehicleBoat extends VehicleAbstract
{
    private int hours;


    public VehicleBoat(String brand, String model, int hours) {
        super(brand, model);
        this.hours = hours;
    }



    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }


    @Override
    public String getDescription() {
        return String.format("%s, %s, %s", getBrand(), getModel(), getHours());
    }
}
