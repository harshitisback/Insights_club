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
import com.example.menu.modelss.ongoing;
import com.example.menu.R;

import java.util.List;

public class OngoingAdapter extends RecyclerView.Adapter<OngoingAdapter.ViewHolder> {
    Context context;
    List<ongoing> list;

    public OngoingAdapter(Context context, List<ongoing> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ongoingevents_rec,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getUrlImg()).into(holder.imageView);
        holder.name.setText(list.get(position).getName());
        holder.date.setText(list.get(position).getDate());
        holder.mode.setText(list.get(position).getMode());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, date, mode;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ongoing_events_photo);
            name = itemView.findViewById(R.id.ongoing_event_name);
            mode = itemView.findViewById(R.id.ongoing_mode);
            date = itemView.findViewById(R.id.ongoing_date);

        }
    }
}
