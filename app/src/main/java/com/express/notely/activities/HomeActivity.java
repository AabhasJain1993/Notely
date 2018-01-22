package com.express.notely.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;

import com.express.notely.R;
import com.express.notely.views.NotesListView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by root on 18/1/18.
 */

public class HomeActivity extends AppCompatActivity {


    @Bind(R.id.notely_toolbar)
    Toolbar toolbar;

    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Bind(R.id.filterDrawer)
    RelativeLayout filterDrawer;

    @Bind(R.id.notely_list)
    NotesListView notelyList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);


        setSupportActionBar(toolbar);

    }


}
