package com.express.notely.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.express.notely.R;

import butterknife.ButterKnife;

/**
 * Created by root on 20/1/18.
 */

public class AddEditNoteActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addedit);
        ButterKnife.bind(this);
    }


}
