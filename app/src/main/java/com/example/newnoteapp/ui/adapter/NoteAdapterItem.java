package com.example.newnoteapp.ui.adapter;

import com.example.newnoteapp.domain.NoteStructure;

import java.util.Objects;

public class NoteAdapterItem implements AdapterItem {

    private final NoteStructure note;

    public NoteAdapterItem(NoteStructure note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteAdapterItem that = (NoteAdapterItem) o;
        return Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(note);
    }

    public NoteStructure getNote() {
        return note;
    }

    @Override
    public String getUniqueKey() {
        return note.getId();
    }
}
