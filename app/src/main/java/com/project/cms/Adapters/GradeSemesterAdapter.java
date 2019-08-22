package com.project.cms.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.cms.R;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GradeSemesterAdapter extends RecyclerView.Adapter<GradeSemesterAdapter.MyViewHolder> {

    private Context context;
    private LinearLayoutManager mLayoutManager;
    private GradeSemesterItemAdapter mAdapter;
    private String[] semester = new String[2];

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RecyclerView gradeListView;
        TextView titleView;

        public MyViewHolder(View view) {
            super(view);
            titleView = view.findViewById(R.id.titleView);
            gradeListView = view.findViewById(R.id.gradeListView);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }
    }

    public GradeSemesterAdapter(Context context) {
        this.context = context;

        this.semester[0] = "Spring 2019";
        this.semester[1] = "Summer 2019";
    }

    @Override
    public GradeSemesterAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_grade, parent, false);
        return new GradeSemesterAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GradeSemesterAdapter.MyViewHolder holder, int position) {
        holder.titleView.setText(this.semester[position]);
        mLayoutManager = new LinearLayoutManager(context);
        holder.gradeListView.setLayoutManager(mLayoutManager);
        mAdapter = new GradeSemesterItemAdapter(context);
        holder.gradeListView.setAdapter(mAdapter);
    }

    @Override
    public int getItemCount() {
        return semester.length;
    }
}