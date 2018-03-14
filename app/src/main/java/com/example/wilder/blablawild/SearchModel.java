package com.example.wilder.blablawild;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wilder on 13/03/18.
 */

public class SearchModel implements Parcelable{
    private String departure;
    private String destination;
    private String date;



    public String getDeparture(){return departure;}
    public String getDestination(){return destination;}
    public String getDate(){return date;}

    public SearchModel(String departure,String destination,String date)
    {
        this.departure = departure;
        this.destination = destination;
        this.date = date;
    }

    public SearchModel(Parcel in) {
        departure= in.readString();
        destination= in.readString();
        date= in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(departure);
        dest.writeString(destination);
        dest.writeString(date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<SearchModel> CREATOR = new Parcelable.Creator<SearchModel>() {
        @Override
        public SearchModel createFromParcel(Parcel in) {
            return new SearchModel(in);
        }

        @Override
        public SearchModel[] newArray(int size) {
            return new SearchModel[size];
        }
    };

}
