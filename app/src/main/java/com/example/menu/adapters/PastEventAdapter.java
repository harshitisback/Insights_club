package com.example.menu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.menu.R;
import com.example.menu.modelss.past;
import com.example.menu.R;

import java.util.List;

public class PastEventAdapter extends RecyclerView.Adapter<PastEventAdapter.ViewHolder> {

    Context context;
    List<past> list;

    public PastEventAdapter(Context context, List<past> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pastevents_rec,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getUrlImg()).into(holder.pastEventImg);
        holder.pastName.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pastEventImg;
        TextView pastName, pastMode, pastDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pastEventImg = itemView.findViewById(R.id.past_events_photo);
            pastName  = itemView.findViewById(R.id.past_event_name);
            pastMode = itemView.findViewById(R.id.past_event_mode);
            pastDate = itemView.findViewById(R.id.past_event_date);
        }
    }
}
