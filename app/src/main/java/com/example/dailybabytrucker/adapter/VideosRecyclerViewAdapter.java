package com.example.dailybabytrucker.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailybabytrucker.R;

public class VideosRecyclerViewAdapter extends RecyclerView.Adapter<VideosRecyclerViewAdapter.VideosHolder> {

    Context context;
    int[] imgVideos;
    String[] videoTitle;
    String[] placeGuideVideos;
    Button btnWatch;

    public VideosRecyclerViewAdapter(Context context, int[] imgVideos, String[] videoTitle, String[] placeGuideVideos, Button btnWatch) {
        this.context = context;
        this.imgVideos = imgVideos;
        this.videoTitle = videoTitle;
        this.placeGuideVideos = placeGuideVideos;
        this.btnWatch = btnWatch;
    }


    @NonNull
    @Override
    public VideosRecyclerViewAdapter.VideosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View rootView = inflater.inflate(R.layout.videolist_layout, parent, false);
        VideosHolder videosHolder = new VideosHolder(rootView);


        return videosHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final VideosRecyclerViewAdapter.VideosHolder holder, int position) {

        holder.tvVideoTitle.setText(videoTitle[position]);
        holder.ivVideo.setImageResource(imgVideos[position]);

        holder.btnWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(placeGuideVideos[holder.getAdapterPosition()]));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return imgVideos.length;
    }

    public class VideosHolder extends RecyclerView.ViewHolder {

        ImageView ivVideo;
        TextView tvVideoTitle;
        Button btnWatch;

        public VideosHolder(@NonNull View itemView) {
            super(itemView);
            ivVideo = itemView.findViewById(R.id.ivVideo);
            tvVideoTitle = itemView.findViewById(R.id.tvVideoTitle);
            btnWatch = itemView.findViewById(R.id.btnWatchVideo);
        }
    }
}
