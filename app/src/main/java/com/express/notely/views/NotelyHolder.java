package com.express.notely.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.express.notely.R;
import com.express.notely.interfaces.INoteClickListener;

import butterknife.ButterKnife;

/**
 * Created by root on 20/1/18.
 */

public class NotelyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView mTitle;
    TextView mGist;
    TextView mDateUpdated;
    ImageView mHearted;
    ImageView mStarred;
    Context mContext;
    boolean mCurrentHeartState = false;
    boolean mCurrentStarState = false;
    INoteClickListener mNoteClickListener =  null;


    public NotelyHolder(View view, INoteClickListener noteClickListener) {
        super(view);
        mTitle = (TextView) view.findViewById(R.id.title);
        mGist = (TextView)view.findViewById(R.id.gist);
        mDateUpdated =(TextView) view.findViewById(R.id.dateUpdated);
        mHearted = (ImageView) view.findViewById(R.id.heart);
        mStarred = (ImageView) view.findViewById(R.id.star);
        mContext = view.getContext();
        itemView.setOnClickListener(this);
        mHearted.setOnClickListener(this);
        mStarred.setOnClickListener(this);
        mNoteClickListener = noteClickListener;
    }

    private void setHeartImageResource(boolean state) {
        if(state) {
            mHearted.setImageResource(R.drawable.heart_pressed);
        } else {
            mHearted.setImageResource(R.drawable.heart_unpressed);
        }
    }

    private void setStarImageResource(boolean state) {
        if(state) {
            mStarred.setImageResource(R.drawable.star_pressed);
        } else {
            mStarred.setImageResource(R.drawable.star_unpressed);
        }
    }

    public void bind(String title, String desc, String lastUpdatedTime, boolean ishearted, boolean isStar) {
        mTitle.setText(title);
        mGist.setText(desc);
        mDateUpdated.setText(lastUpdatedTime);
        mCurrentHeartState = ishearted;
        mCurrentStarState = isStar;

        setHeartImageResource(mCurrentHeartState);
        setStarImageResource(mCurrentStarState);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.heart:
                mCurrentHeartState = !mCurrentHeartState;
                setHeartImageResource(mCurrentHeartState);
                break;
            case R.id.star:
                mCurrentStarState = !mCurrentStarState;
                setStarImageResource(mCurrentStarState);
                break;
            default:
                if(mNoteClickListener != null) {
                    mNoteClickListener.onNoteClick(getAdapterPosition());
                }

        }
    }
}
