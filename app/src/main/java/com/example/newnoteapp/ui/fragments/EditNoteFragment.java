package com.example.newnoteapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.newnoteapp.R;
import com.example.newnoteapp.domain.NoteStructure;

public class EditNoteFragment extends Fragment {
    public static final String ARG_NOTE = "ARG_NOTE";
    public static final String KEY_NOTE_RESULT = "KEY_NOTE_RESULT";

    public EditNoteFragment() {
    }

    public static EditNoteFragment newInstance(NoteStructure note) {
        EditNoteFragment fragment = new EditNoteFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTE, note);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText editText = view.findViewById(R.id.title);

        NoteStructure note = requireArguments().getParcelable(ARG_NOTE);

        editText.setText(note.getTitle());

        view.findViewById(R.id.btn_save).setOnClickListener(v -> {

            note.setTitle(editText.getText().toString());

            Bundle bundle = new Bundle();
            bundle.putParcelable(ARG_NOTE, note);

            getParentFragmentManager()
                    .setFragmentResult(KEY_NOTE_RESULT, bundle);

            getParentFragmentManager().popBackStack();
        });
    }
}
