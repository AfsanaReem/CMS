package com.project.cms.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.project.cms.Adapters.GradeSemesterAdapter;
import com.project.cms.Adapters.TimeTableAdapter;
import com.project.cms.R;

public class GradeActivity extends AppCompatActivity {
    RecyclerView gradesTableView;
    private LinearLayoutManager mLayoutManager;
    private GradeSemesterAdapter mAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        initToolbar();
        initViews();
    }

    private void initViews() {
        gradesTableView = findViewById(R.id.grades_view);
        mLayoutManager = new LinearLayoutManager(this);
        gradesTableView.setLayoutManager(mLayoutManager);
        mAdapter = new GradeSemesterAdapter(this);
        gradesTableView.setAdapter(mAdapter);
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.app_bar);
        toolbar.setTitle("Grades");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
