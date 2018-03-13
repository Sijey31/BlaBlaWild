package com.example.wilder.blablawild;

/**
 * Created by wilder on 13/03/18.
 */

public class VehiclePlane extends VehicleAbstract {
    private int speed;



    public VehiclePlane(String brand, String model, int speed) {
        super(brand, model);
        this.speed = speed;
    }



    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }



    @Override
    public String getDescription() {
        return String.format("%s, %s, %s", getBrand(), getModel(), getSpeed());
    }
}