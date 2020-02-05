package com.example.dailybabytrucker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dailybabytrucker.R;
import com.example.dailybabytrucker.model.RandomRecipes;

import java.util.List;

/**
 * Adapter used to show a simple grid of products.
 */

public class RecipesCardRecyclerViewAdapter extends RecyclerView.Adapter<RecipesCardViewHolder> {

    List<RandomRecipes> recipesList;

    public RecipesCardRecyclerViewAdapter(List<RandomRecipes> recipesList) {
        this.recipesList = recipesList;
    }

    @NonNull
    @Override
    public RecipesCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_card, parent, false);
        return new RecipesCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesCardViewHolder holder, int position) {

        //The code tells our RecyclerView's adapter what to do with each card, using a ViewHolder.
        if (recipesList != null && position < recipesList.size()) {

            RandomRecipes recipes = recipesList.get(holder.getAdapterPosition());

            holder.recipeId.setText(recipes.getId());
            holder.recipeTitle.setText(recipes.getTitle());
            Glide.with(holder.recipeImage.getContext())
                    .load(recipes.getImage())
                    .into(holder.recipeImage);


        }

    }

    @Override
    public int getItemCount() {
        return recipesList.size();
    }
}
