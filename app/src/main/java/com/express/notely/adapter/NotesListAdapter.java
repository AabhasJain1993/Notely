package com.express.notely.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.express.notely.R;
import com.express.notely.interfaces.INoteClickListener;
import com.express.notely.model.Note;
import com.express.notely.views.NotelyHolder;

import java.util.List;

/**
 * Created by root on 20/1/18.
 */

public class NotesListAdapter extends RecyclerView.Adapter<NotelyHolder> {

    private INoteClickListener mNoteClickListener = null;
    private List<Note> mNotesList;

    public NotesListAdapter(INoteClickListener iNoteClickListener, List<Note> list) {
        mNoteClickListener = iNoteClickListener;
        mNotesList = list;
    }


    @Override
    public NotelyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.snippet_notelistitem,parent,false);
        return new NotelyHolder(view,mNoteClickListener);
    }

    @Override
    public void onBindViewHolder(NotelyHolder holder, int position) {
        Note note = mNotesList.get(position);
        holder.bind(note.getTitle(), note.getGist(), note.getLastUpdatedTime(), note.isHearted(), note.isStarred());

    }

    @Override
    public int getItemCount() {
        return mNotesList.size();
    }
}
