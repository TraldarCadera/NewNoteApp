package com.example.newnoteapp.ui;

import com.example.newnoteapp.domain.NoteRepo;
import com.example.newnoteapp.domain.NoteStructure;
import com.example.newnoteapp.ui.adapter.AdapterItem;
import com.example.newnoteapp.ui.adapter.HeaderAdapterItem;
import com.example.newnoteapp.ui.adapter.NoteAdapterItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NoteListPresenter {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy", Locale.getDefault());
    private final NoteListView view;
    private final NoteRepo repository;
    private final ArrayList<NoteStructure> notes = new ArrayList<>();

    public NoteListPresenter(NoteListView view, NoteRepo repository) {
        this.view = view;
        this.repository = repository;
    }

    public void requestNotes() {
        view.showProgress();

        repository.getNotes(data -> {

            notes.clear();
            notes.addAll(data);

            buildList();

            view.hideProgress();
        });
    }

    public void addNote(String title, String imageUrl) {
        view.showProgress();

        repository.addNote(title, imageUrl, data -> {
            view.hideProgress();

            notes.add(data);

            buildList();
        });
    }

    public void removeNote(NoteStructure selectedNote) {
        view.showProgress();
        repository.removeNote(selectedNote, data -> {
            view.hideProgress();

            notes.remove(selectedNote);

            buildList();
        });

    }

    public void updateNote(NoteStructure note) {
        int index = notes.indexOf(note);
    }

    private void buildList() {

        List<AdapterItem> items = new ArrayList<>();
        Date currentDate = null;
        Calendar calendar = Calendar.getInstance();

        for (NoteStructure note : notes) {

            if (currentDate == null) {

                currentDate = note.getCreatedAt();

                items.add(new HeaderAdapterItem(simpleDateFormat.format(currentDate)));
            } else {

                calendar.setTime(currentDate);

                int currentDayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

                calendar.setTime(note.getCreatedAt());

                int noteDayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

                if (currentDayOfYear != noteDayOfYear) {
                    currentDate = note.getCreatedAt();

                    items.add(new HeaderAdapterItem(simpleDateFormat.format(currentDate)));
                }

            }
            items.add(new NoteAdapterItem(note));
        }

        view.showNotes(items);
    }
}
