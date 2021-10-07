package com.example.newnoteapp.domain;

import java.util.List;

public interface NoteRepo {
    void getNotes(Callback<List<NoteStructure>> callback);

    void addNote(String title, String image, Callback<NoteStructure> callback);

    void removeNote(NoteStructure note, Callback<Void> callback);
}
