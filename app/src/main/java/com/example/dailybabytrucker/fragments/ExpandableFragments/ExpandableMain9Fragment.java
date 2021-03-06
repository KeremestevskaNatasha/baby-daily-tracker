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
public class ExpandableMain9Fragment extends Fragment {


    public ExpandableMain9Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_expandable_main9, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.expandRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<NutritionSort> nutritionSorts = new ArrayList<>();

        ArrayList<Product> cerealsAndSeeds = new ArrayList<>();
        cerealsAndSeeds.add(new Product("Pasta no eggs"));
        cerealsAndSeeds.add(new Product("Bread no eggs"));


        NutritionSort cerealSeeds = new NutritionSort("Cereals and Seeds", cerealsAndSeeds);
        nutritionSorts.add(cerealSeeds);


        ArrayList<Product> vegetables = new ArrayList<>();
        vegetables.add(new Product("Peas"));
        vegetables.add(new Product("Red lens"));


        NutritionSort vegetable = new NutritionSort("Vegetable", vegetables);
        nutritionSorts.add(vegetable);

        ArrayList<Product> fruits = new ArrayList<>();
        fruits.add(new Product("Quince"));

        NutritionSort fruit = new NutritionSort("Fruit", fruits);
        nutritionSorts.add(fruit);

     ArrayList<Product> eggs = new ArrayList<>();
     eggs.add(new Product("Yolk"));

     NutritionSort egg = new NutritionSort("Eggs", eggs);
     nutritionSorts.add(egg);

        ArrayList<Product> supplements = new ArrayList<>();
        supplements.add(new Product("Basil"));

        NutritionSort supplement = new NutritionSort("Supplements", supplements);
        nutritionSorts.add(supplement);

        ProductAdapter productAdapter = new ProductAdapter(nutritionSorts);
        recyclerView.setAdapter(productAdapter);

        return view;
    }

}
