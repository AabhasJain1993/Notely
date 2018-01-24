package com.express.notely.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.express.notely.R;
import com.express.notely.utils.NotelyPrefSettings;
import com.express.notely.views.NotesListView;

import butterknife.Bind;
import butterknife.BindInt;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by root on 18/1/18.
 */

public class HomeActivity extends AppCompatActivity{


    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Bind(R.id.filterDrawer)
    RelativeLayout filterDrawer;

    @Bind(R.id.notely_list)
    NotesListView notelyList;

    @Bind(R.id.bluedot)
    ImageView bluedot;

    @Bind(R.id.fab)
    FloatingActionButton floatingActionButton;

    @OnClick(R.id.fab)
    void addNote() {

        Intent intent = new Intent(this, AddEditNoteActivity.class);
        startActivity(intent);

    }

    @OnClick(R.id.filterContainer)
    void onClickfilterContainer() {
        if(!NotelyPrefSettings.getInstance().getFilterMode()) {
            bluedot.setVisibility(View.GONE);
            NotelyPrefSettings.getInstance().setFilterMode();
        }

        if(!drawerLayout.isDrawerOpen(findViewById(R.id.nav_view)))
            drawerLayout.openDrawer(findViewById(R.id.nav_view));
        else
            drawerLayout.closeDrawer(findViewById(R.id.nav_view));
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        if (!NotelyPrefSettings.getInstance().getFilterMode()) {
            bluedot.setVisibility(View.VISIBLE);
        }

    }


    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(findViewById(R.id.nav_view)))
            drawerLayout.closeDrawer(findViewById(R.id.nav_view));
        else
            super.onBackPressed();
    }
}
