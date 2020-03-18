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

public class GrowthRecyclerViewAdapter extends RecyclerView.Adapter<GrowthRecyclerViewAdapter.GrowthHolder> {

    Context context;
    int[] imgGrowth;
    String [] imgTitle;
    String[] descGrowth;
    String[] placeGuide;

    public GrowthRecyclerViewAdapter(Context context, int[] imgGrowth, String[] imgTitle, String[] descGrowth, String[] placeGuide) {
        this.context = context;
        this.imgGrowth = imgGrowth;
        this.imgTitle = imgTitle;
        this.descGrowth = descGrowth;
        this.placeGuide = placeGuide;
    }

    @NonNull
    @Override
    public GrowthRecyclerViewAdapter.GrowthHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View rootView = inflater.inflate(R.layout.item_growth, parent, false);
        GrowthHolder growthHolder = new GrowthHolder(rootView);


        return growthHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final GrowthRecyclerViewAdapter.GrowthHolder holder, int position) {

        holder.ivGrowth.setImageResource(imgGrowth[position]);
        holder.tvTitleGrowth.setText(imgTitle[position]);
        holder.tvGrowth.setText(descGrowth[position]);

        holder.btnVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(placeGuide[holder.getAdapterPosition()]));
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return imgGrowth.length;
    }

     class GrowthHolder extends RecyclerView.ViewHolder {

        ImageView ivGrowth ;
        TextView tvTitleGrowth;
        TextView tvGrowth;
        Button btnVisit;

        public GrowthHolder(@NonNull View itemView) {
            super(itemView);

            ivGrowth = itemView.findViewById(R.id.ivGrowth);
            tvTitleGrowth = itemView.findViewById(R.id.tvTitleGrowth);
            tvGrowth = itemView.findViewById(R.id.tvGrowth);
            btnVisit = itemView.findViewById(R.id.btnVisit);

        }
    }
}
