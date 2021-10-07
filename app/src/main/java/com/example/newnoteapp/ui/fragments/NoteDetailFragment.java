package com.example.newnoteapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.newnoteapp.R;
import com.example.newnoteapp.domain.NoteStructure;

public class NoteDetailFragment extends Fragment {

    public NoteDetailFragment() {
    }

    public static NoteDetailFragment newInstance(NoteStructure note) {
        NoteDetailFragment fragment = new NoteDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_detail, container, false);
    }
}
