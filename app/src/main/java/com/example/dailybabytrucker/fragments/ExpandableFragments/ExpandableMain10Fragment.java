package com.example.dailybabytrucker.fragments.ExpandableFragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dailybabytrucker.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExpandableMain10Fragment extends Fragment {


    public ExpandableMain10Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expandable_main10, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.expandRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<NutritionSort> nutritionSorts = new ArrayList<>();

        ArrayList<Product> cerealsAndSeeds = new ArrayList<>();
        cerealsAndSeeds.add(new Product("Buckwheat"));

        NutritionSort cerealSeeds = new NutritionSort("Cereals and Seeds", cerealsAndSeeds);
        nutritionSorts.add(cerealSeeds);


        ArrayList<Product> vegetables = new ArrayList<>();
        vegetables.add(new Product("Cabbage"));
        vegetables.add(new Product("Kale"));
        vegetables.add(new Product("Tomatoes"));
        vegetables.add(new Product("Eggplants"));

        NutritionSort vegetable = new NutritionSort("Vegetable", vegetables);
        nutritionSorts.add(vegetable);

        ArrayList<Product> meat = new ArrayList<>();
        meat.add(new Product("White Fish"));

        NutritionSort meats = new NutritionSort("Meat", meat);
        nutritionSorts.add(meats);

        ArrayList<Product> fruits = new ArrayList<>();
        fruits.add(new Product("Figs"));

        NutritionSort fruit = new NutritionSort("Fruit", fruits);
        nutritionSorts.add(fruit);

        ArrayList<Product> supplements = new ArrayList<>();
        supplements.add(new Product("Vanilla"));
        supplements.add(new Product("Pumpkin Oil"));
        supplements.add(new Product("Coconut Milk"));
        supplements.add(new Product("Coconut"));

        NutritionSort supplement = new NutritionSort("Supplements", supplements);
        nutritionSorts.add(supplement);

        ProductAdapter productAdapter = new ProductAdapter(nutritionSorts);
        recyclerView.setAdapter(productAdapter);

        return view;
    }
}
