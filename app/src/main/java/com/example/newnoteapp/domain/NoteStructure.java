package com.example.newnoteapp.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.Objects;

public class NoteStructure implements Parcelable {

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
    private final Date createdAt;
    private String id;
    private String title;

    public NoteStructure(String id, String title, Date createdAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
    }

    protected NoteStructure(Parcel in) {
        id = in.readString();
        title = in.readString();
        createdAt = (Date) in.readSerializable();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flag) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeSerializable(createdAt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteStructure note = (NoteStructure) o;
        return Objects.equals(id, note.id) &&
                Objects.equals(title, note.title);
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
