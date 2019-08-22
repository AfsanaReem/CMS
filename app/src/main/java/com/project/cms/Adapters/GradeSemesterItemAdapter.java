package com.project.cms.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.cms.R;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GradeSemesterItemAdapter extends RecyclerView.Adapter<GradeSemesterItemAdapter.MyViewHolder> {

    private Context context;
    private String[] courses = new String[3];
    private String[] grades = new String[3];

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleView, gradeView;

        public MyViewHolder(View view) {
            super(view);
            titleView = view.findViewById(R.id.titleView);
            gradeView = view.findViewById(R.id.gradeView);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }
    }

    public GradeSemesterItemAdapter(Context context) {
        this.context = context;

        this.courses[0] = "CSE 327 - Software Engineering (C)";
        this.courses[1] = "EEE 452 - Engineering Economics (A)";
        this.courses[2] = "ENV 203 - Introduction to Geography (B)";

        this.grades[0] = "Grade: A";
        this.grades[1] = "Grade: A-";
        this.grades[2] = "Grade: B";
    }

    @Override
    public GradeSemesterItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_grade_table, parent, false);
        return new GradeSemesterItemAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GradeSemesterItemAdapter.MyViewHolder holder, int position) {
        holder.titleView.setText(this.courses[position]);
        holder.gradeView.setText(this.grades[position]);
    }

    @Override
    public int getItemCount() {
        return this.courses.length;
    }
}