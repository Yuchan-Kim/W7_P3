package com.example.w7_p3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<ItemList> dataCollection;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvEptitle, tvEpDescription;
        private RatingBar ratingEp;
        private Button buttonRD;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEptitle = itemView.findViewById(R.id.tvEpisodeTitle);
            tvEpDescription = itemView.findViewById(R.id.tvEpisodeDescription);
            ratingEp = itemView.findViewById(R.id.rbEpisode);
            buttonRD = itemView.findViewById(R.id.btnRandom);
            imageView = itemView.findViewById(R.id.imgEpisode);
        }
    }

    //
    public RecyclerViewAdapter (ArrayList<ItemList> dataSet){
        this.dataCollection = dataSet;
    }





    //Create Viewholder object and return it
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item, parent, false);
        RecyclerViewAdapter.ViewHolder viewHolder = new RecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ViewHolder viewHolder = (RecyclerViewAdapter.ViewHolder) holder;
        viewHolder.tvEptitle.setText(dataCollection.get(position).getTitle());
        viewHolder.tvEpDescription.setText(dataCollection.get(position).getEpisode());
        viewHolder.buttonRD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/w/index.php?search="+ ((Integer)position).toString() + ":"+ viewHolder.tvEptitle.getText().toString() +"&title=Special:Search&profile=advanced&fulltext=1&ns0=1"));
                Context context = view.getContext();
                context.startActivity(browserIntent);
            }
        });

    }

    void addItem(ItemList itemList){
        dataCollection.add(itemList);
    }

    @Override
    public int getItemCount() {
        return dataCollection.size();
    }
}
