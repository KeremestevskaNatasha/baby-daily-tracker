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
public class ExpandableMain7Fragment extends Fragment {


    public ExpandableMain7Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_expandable_main7, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.expandRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<NutritionSort> nutritionSorts = new ArrayList<>();


        ArrayList<Product> cerealsAndSeeds = new ArrayList<>();
        cerealsAndSeeds.add(new Product("Corn Semolina"));


        NutritionSort crealSeeds = new NutritionSort("Cereals and Seeds", cerealsAndSeeds);
        nutritionSorts.add(crealSeeds);


        ArrayList<Product> vegetables = new ArrayList<>();
        vegetables.add(new Product("Garlic"));
        vegetables.add(new Product("Pepper, green and red"));
        vegetables.add(new Product("Spinach"));
        vegetables.add(new Product("Leek"));
        vegetables.add(new Product("Celery"));
        vegetables.add(new Product("Swallows"));

        NutritionSort vegetable = new NutritionSort("Vegetable", vegetables);
        nutritionSorts.add(vegetable);

        ArrayList<Product> fruits = new ArrayList<>();
        fruits.add(new Product("Cherries"));
        fruits.add(new Product("Sour Cherries"));



        NutritionSort fruit = new NutritionSort("Fruit", fruits);
        nutritionSorts.add(fruit);

        ArrayList<Product> supplements = new ArrayList<>();
        supplements.add(new Product("Cinnamon"));


        NutritionSort supplement = new NutritionSort("Supplements", supplements);
        nutritionSorts.add(supplement);

        ProductAdapter productAdapter = new ProductAdapter(nutritionSorts);
        recyclerView.setAdapter(productAdapter);

        return view;
    }

}
