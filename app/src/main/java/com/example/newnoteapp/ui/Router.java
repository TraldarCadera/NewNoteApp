package com.example.newnoteapp.ui;

import androidx.fragment.app.FragmentManager;

import com.example.newnoteapp.R;
import com.example.newnoteapp.domain.NoteStructure;
import com.example.newnoteapp.ui.fragments.AuthFragment;
import com.example.newnoteapp.ui.fragments.EditNoteFragment;
import com.example.newnoteapp.ui.fragments.InfoFragment;
import com.example.newnoteapp.ui.fragments.NoteDetailFragment;
import com.example.newnoteapp.ui.fragments.NoteListFragment;

public class Router {
    private final FragmentManager fragmentManager;

    public Router(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void showNotesList() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, new NoteListFragment())
                .commit();
    }

    public void showAuth() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, new AuthFragment())
                .commit();
    }

    public void showInfo() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, new InfoFragment())
                .commit();
    }

    public void showNoteDetails(NoteStructure note) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, NoteDetailFragment.newInstance(note))
                .addToBackStack(null)
                .commit();
    }

    public void showEditNote(NoteStructure note) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, EditNoteFragment.newInstance(note))
                .addToBackStack(null)
                .commit();
    }
}
