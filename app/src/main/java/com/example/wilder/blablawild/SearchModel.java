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


    protected SearchModel(Parcel in) {
        departure = in.readString();
        destination = in.readString();
        date = in.readString();
    }

    public static final Creator<SearchModel> CREATOR = new Creator<SearchModel>() {
        @Override
        public SearchModel createFromParcel(Parcel in) {
            return new SearchModel(in);
        }

        @Override
        public SearchModel[] newArray(int size) {
            return new SearchModel[size];
        }
    };

    public String getDeparture(){return departure;}
    public String getDestination(){return destination;}
    public String getDate(){return date;}


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(departure);
        parcel.writeString(destination);
        parcel.writeString(date);
    }
}
