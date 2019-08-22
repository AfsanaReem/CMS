package com.project.cms.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.project.cms.R;


import androidx.recyclerview.widget.RecyclerView;

public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.MyViewHolder> {

    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView iconView;
        TextView titleView, descriptionView;

        public MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }


    public TimeTableAdapter(Context context) {
        this.context = context;
    }

    @Override
    public TimeTableAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_time_table, parent, false);


        return new TimeTableAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TimeTableAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}