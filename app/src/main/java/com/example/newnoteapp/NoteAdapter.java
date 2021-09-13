package com.example.newnoteapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NotesViewHolder> {

    private final ArrayList<NoteStructure> data = new ArrayList<>();

    private OnNoteClickedListener listener;

    private OnNoteLongClickedListener longClickListener;

    private final Fragment fragment;

    public NoteAdapter(Fragment fragment) {
        this.fragment = fragment;
    }



    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listContainer = view.findViewById(R.id.list_container_view);


    }

    interface OnNoteClickedListener {
        void onNoteClicked(NoteStructure note);
    }

    interface OnNoteLongClickedListener {
        void onNoteLongClicked(NoteStructure note);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_list, container, false);
    }

    class NotesViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;


        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);

            fragment.registerForContextMenu(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (getListener() != null) {
                        getListener().onNoteClicked(data.get(getAdapterPosition()));
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    itemView.showContextMenu();

                    if (getLongClickListener() != null) {
                        getLongClickListener().onNoteLongClicked(data.get(getAdapterPosition()));
                    }
                    return true;
                }
            });

            title = itemView.findViewById(R.id.note_title);

        }

        public TextView getTitle() {
            return title;
        }
    }
}

}
