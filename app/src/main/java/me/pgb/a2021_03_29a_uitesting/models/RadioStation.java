package me.pgb.a2021_03_29a_uitesting.models;

import android.os.Parcel;
import android.os.Parcelable;

public class RadioStation implements Parcelable, Cloneable {

    private String streamLink;
    private String name;

    public RadioStation(String streamLink, String name) {
        this.streamLink = streamLink;
        this.name = name;
    }

    public RadioStation(Parcel in) {
        this.streamLink =  in.readString();
        this.name = in.readString();
    }

    public String getStreamLink() {
        return streamLink;
    }
    public void setStreamLink(String streamLink) {
        this.streamLink = streamLink;
    }
    public String getName(){ return name; }
    public void setName(String name){
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(streamLink);
        dest.writeString(name);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public RadioStation createFromParcel(Parcel in) {
            return new RadioStation(in);
        }

        public RadioStation[] newArray(int size) {
            return new RadioStation[size];
        }
    };

    @Override
    public String toString() {
        return "link: " + this.streamLink
                + "\n" +
                "name: " + this.name
                + "\n";
    }

    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
}