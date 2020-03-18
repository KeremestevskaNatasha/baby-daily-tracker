package com.example.dailybabytrucker.fragments.ExpandableFragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.dailybabytrucker.R;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class ProductAdapter extends ExpandableRecyclerViewAdapter<NutritionSortViewHolder, ProductViewHolder> {
    public ProductAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public NutritionSortViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expandable_recyclerview_nutrition_sort, parent, false);

        return new NutritionSortViewHolder(view);
    }

    @Override
    public ProductViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expandable_recyclerview_product,parent,false);

        return new ProductViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ProductViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {

        final Product product = (Product) group.getItems().get(childIndex);
        holder.bind(product);

    }

    @Override
    public void onBindGroupViewHolder(NutritionSortViewHolder holder, int flatPosition, ExpandableGroup group) {

        final NutritionSort nutritionSort = (NutritionSort) group;
        holder.bind(nutritionSort);

    }
}
