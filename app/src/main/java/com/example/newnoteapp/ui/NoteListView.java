package com.example.newnoteapp.ui;

import com.example.newnoteapp.ui.adapter.AdapterItem;

import java.util.List;

public interface NoteListView {
    void showNotes(List<AdapterItem> notes);

    void showProgress();

    void hideProgress();
}
