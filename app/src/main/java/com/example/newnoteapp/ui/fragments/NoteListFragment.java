package com.example.newnoteapp.ui.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newnoteapp.R;
import com.example.newnoteapp.domain.NoteAdapter;
import com.example.newnoteapp.domain.NoteStructure;

import java.util.List;

public class NoteListFragment extends Fragment {

    public static final String KEY_SELECTED = "KEY_SELECTED";
    public static final String ARG_NOTE = "ARG_NOTE";

    private NoteAdapter adapter;
    private onNoteOnClicked onNoteOnClicked;

    public NoteListFragment() {
        super(R.layout.fragment_note_list);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof onNoteOnClicked) {
            onNoteOnClicked = (onNoteOnClicked) context;
        }
    }

    @Override
    public void onDetach() {
        onNoteOnClicked = null;
        super.onDetach();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView noteList = view.findViewById(R.id.notes_list);

        noteList.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        noteList.setAdapter(adapter);
    }

    public void showNotes(List<NoteStructure> notes) {
        adapter.setNotes(notes);
        adapter.notifyDataSetChanged();
    }

    public interface onNoteOnClicked {
        void onNoteOnClicked(NoteStructure note);
    }
}
