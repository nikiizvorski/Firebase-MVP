package com.niki.mvpexample.app.model;

import android.os.Parcel;
import android.os.Parcelable;
import javax.inject.Inject;

/**
 * The type Knigi.
 */
public class Knigi implements Parcelable {
    private String name;
    private String text;

    /**
     * Instantiates a new Knigi.
     */
    @Inject
    Knigi() {}

    private Knigi(Parcel in) {
        name = in.readString();
        text = in.readString();
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets text.
     *
     * @param text the text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * The constant CREATOR.
     */
    public static final Creator<Knigi> CREATOR = new Creator<Knigi>() {
        @Override
        public Knigi createFromParcel(Parcel in) {
            return new Knigi(in);
        }

        @Override
        public Knigi[] newArray(int size) {
            return new Knigi[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(text);
    }
}
