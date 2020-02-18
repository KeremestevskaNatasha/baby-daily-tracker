package com.example.dailybabytrucker.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dailybabytrucker.model.RandomRecipes;
import com.example.dailybabytrucker.R;

import java.util.List;


/**
 * Adapter used to show an asymmetric grid of products, with 2 items in the first column, and 1
 * item in the second column, and so on.
 */

public class StaggeredRecipesCardRecyclerViewAdapter extends RecyclerView.Adapter<StaggeredRecipesCardViewHolder> {

    List<RandomRecipes> recipesList;
    private Context context;

    public StaggeredRecipesCardRecyclerViewAdapter(Context context,List<RandomRecipes> recipes) {
        this.context = context;
        recipesList = recipes;
    }


    @Override
    public int getItemViewType(int position) {
        return position % 3;
    }

    @NonNull
    @Override
    public StaggeredRecipesCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        int layoutId = R.layout.stagged_recipe_card_first;
//        if (viewType == 1) {
//            layoutId = R.layout.stagged_recipe_card_second;
//        } else if (viewType == 2) {
//            layoutId = R.layout.stagged_recipe_card_third;
//        }
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_card, parent, false);
        return new StaggeredRecipesCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull StaggeredRecipesCardViewHolder holder, int position) {

        if (recipesList != null && position < recipesList.size()) {

            final RandomRecipes recipes = recipesList.get(holder.getAdapterPosition());

            holder.recipeId.setText(recipes.getId());
            holder.recipeTitle.setText(recipes.getTitle());
            Glide.with(holder.recipeImage.getContext())
                    .load(recipes.getImage())
                    .into(holder.recipeImage);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "recipes");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, recipes.getTitle());
                    context.startActivity(Intent.createChooser(sharingIntent, "Share via"));


                }
            });


        }


    }

    @Override
    public int getItemCount() {
        return recipesList.size();
    }
}
