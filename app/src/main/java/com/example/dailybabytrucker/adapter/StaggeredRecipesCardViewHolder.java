package com.example.dailybabytrucker.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailybabytrucker.R;


public class StaggeredRecipesCardViewHolder extends RecyclerView.ViewHolder {

    public ImageView recipeImage;
    public TextView recipeTitle;
    public TextView recipeId;

    public StaggeredRecipesCardViewHolder(@NonNull View itemView) {
        super(itemView);

        recipeImage = itemView.findViewById(R.id.recipe_image);
        recipeTitle = itemView.findViewById(R.id.recipe_title);
        recipeId = itemView.findViewById(R.id.recipe_id);

    }
}
