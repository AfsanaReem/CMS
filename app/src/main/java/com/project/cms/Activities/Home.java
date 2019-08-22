package com.project.cms.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.project.cms.Adapters.EventAdapter;
import com.project.cms.Adapters.TimeTableAdapter;
import com.project.cms.R;

public class Home extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    private RecyclerView timeTableView, eventsView;
    private LinearLayoutManager mLayoutManager;
    private TimeTableAdapter mAdapter;
    private LinearLayoutManager mLayoutManager2;
    private EventAdapter mAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
    }

    private void initViews() {
        toolbar = findViewById(R.id.app_bar);
        drawerLayout = findViewById(R.id.activity_main);
        navigationView = findViewById(R.id.navigation);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close);
        setTitle("Home");
        setSupportActionBar(toolbar);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerItemClickHandler();

        timeTableView = findViewById(R.id.my_recycler_view);
        timeTableView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        timeTableView.setLayoutManager(mLayoutManager);
        mAdapter = new TimeTableAdapter(this);
        timeTableView.setAdapter(mAdapter);

        eventsView = findViewById(R.id.events_view);
        eventsView.setHasFixedSize(true);
        mLayoutManager2 = new LinearLayoutManager(this);
        eventsView.setLayoutManager(mLayoutManager2);
        mAdapter2 = new EventAdapter(this);
        eventsView.setAdapter(mAdapter2);

        // Textview
        TextView textView = findViewById(R.id.timeTableTitleView);
        SpannableString content = new SpannableString("Time Table");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);

        TextView textView2 = findViewById(R.id.eventTextView);
        content = new SpannableString("Upcoming Events");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView2.setText(content);

    }

    private void drawerItemClickHandler() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.profile:
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.submitGrades:
                        Intent intent = new Intent(Home.this, GradeActivity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.logout:
                        Intent intent2 = new Intent(Home.this, MainActivity.class);
                        startActivity(intent2);
                        finish();
                        break;
                    default:
                        drawerLayout.closeDrawers();
                        break;
                }
                return true;

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

