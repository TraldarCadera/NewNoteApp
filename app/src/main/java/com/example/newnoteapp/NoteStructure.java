package com.example.newnoteapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class NoteStructure implements Parcelable {

    private String id;
    private String date;
    private String title;


    public NoteStructure(String id, String date, String title) {
        this.id = id;
        this.date = date;
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public static final Creator<NoteStructure> CREATOR = new Creator<NoteStructure>() {
        @Override
        public NoteStructure createFromParcel(Parcel in) {
            return new NoteStructure(in);
        }

        @Override
        public NoteStructure[] newArray(int size) {
            return new NoteStructure[size];
        }
    };

    protected NoteStructure(Parcel in) {
        id = in.readString();
        title = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flag) {
        dest.writeString(id);
        dest.writeString(title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteStructure note = (NoteStructure) o;
        return Objects.equals(id, note.id) && Objects.equals(title, note.title);
    }
}
