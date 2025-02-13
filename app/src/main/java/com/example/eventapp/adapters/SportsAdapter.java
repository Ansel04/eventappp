package com.example.eventapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventapp.EventViewActivity;
import com.example.eventapp.R;
import com.example.eventapp.models.PopularModel;
import com.example.eventapp.models.SportsModel;

import java.util.List;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder> {

    private Context context;
    private List<SportsModel> itemList;

    public SportsAdapter(Context context, List<SportsModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SportsModel item = itemList.get(position);
        holder.itemText.setText(item.getTitle());
        holder.itemImage.setImageResource(item.getImageResId());


        holder.eventcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent eventIntent = new Intent(context, EventViewActivity.class);
                eventIntent.putExtra("eventTitle", item.getTitle());
                context.startActivity(eventIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout eventcard;
        ImageView itemImage;
        TextView itemText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemText = itemView.findViewById(R.id.item_text);
            eventcard = itemView.findViewById(R.id.eventcard);
        }
    }
}

