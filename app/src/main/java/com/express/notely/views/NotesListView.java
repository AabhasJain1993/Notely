package com.express.notely.views;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.express.notely.R;
import com.express.notely.adapter.NotesListAdapter;
import com.express.notely.interfaces.INoteClickListener;
import com.express.notely.model.Note;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by root on 20/1/18.
 */

public class NotesListView extends RelativeLayout implements INoteClickListener {

    @Bind(R.id.noteslistview)
    RecyclerView listView;

    private NotesListAdapter mNotesListAdapter;
    private List<Note> mNotesList;

    public NotesListView(Context context) {
        this(context, null);

    }

    public NotesListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    private void init(Context context) {
        inflate(context, R.layout.snippet_noteslistview, this);
        ButterKnife.bind(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listView.setLayoutManager(linearLayoutManager);

        mNotesListAdapter = new NotesListAdapter(this, mNotesList);
        listView.setAdapter(mNotesListAdapter);
    }

    @Override
    public void onNoteClick(int position) {

    }
}
