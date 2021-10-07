package com.example.newnoteapp.domain;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newnoteapp.R;

import java.util.ArrayList;
import java.util.List;


public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NotesViewHolder> {

    private final ArrayList<NoteStructure> data = new ArrayList<>();
    private final Fragment fragment;
    private OnNoteClickedListener listener;
    private OnNoteLongClickedListener longClickListener;

    public NoteAdapter(Fragment fragment) {
        this.fragment = fragment;
    }


    public void setNotes(List<NoteStructure> toSet) {
        data.clear();
        data.addAll(toSet);
    }

    public void addNote(NoteStructure note) {
        data.add(note);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    @NonNull
    @Override
    public NoteAdapter.NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note_list, parent, false);

        return new NotesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.NotesViewHolder holder, int position) {
        NoteStructure note = data.get(position);

        holder.getTitle().setText(note.getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public OnNoteClickedListener getListener() {
        return listener;
    }

    public void setListener(OnNoteClickedListener listener) {
        this.listener = listener;
    }

    public OnNoteLongClickedListener getLongClickListener() {
        return longClickListener;
    }

    public void setLongClickListener(OnNoteLongClickedListener longClickListener) {
        this.longClickListener = longClickListener;
    }

    public int removeNote(NoteStructure selectedNote) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(selectedNote)) {
                data.remove(i);
                return i;
            }
        }
        return -1;
    }

    public int updateNote(NoteStructure note) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(note)) {
                data.set(i, note);
                return i;
            }
        }
        return -1;
    }

    interface OnNoteClickedListener {
        void onNoteClicked(NoteStructure note);
    }

    interface OnNoteLongClickedListener {
        void onNoteLongClicked(NoteStructure note);
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
