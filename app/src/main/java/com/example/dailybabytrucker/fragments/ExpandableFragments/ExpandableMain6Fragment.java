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
public class ExpandableMain6Fragment extends Fragment {


    public ExpandableMain6Fragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_expandable_main6, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.expandRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<NutritionSort> nutritionSorts = new ArrayList<>();

        ArrayList<Product> cerealsAndSeeds = new ArrayList<>();
        cerealsAndSeeds.add(new Product("Rice"));
        cerealsAndSeeds.add(new Product("Quinoa"));
        cerealsAndSeeds.add(new Product("Amateur"));
        cerealsAndSeeds.add(new Product("Millet"));

        NutritionSort crealSeeds = new NutritionSort("Cereals and Seeds", cerealsAndSeeds);
        nutritionSorts.add(crealSeeds);


        ArrayList<Product> vegetables = new ArrayList<>();
        vegetables.add(new Product("Potato"));
        vegetables.add(new Product("Carrot"));
        vegetables.add(new Product("Cauliflower"));
        vegetables.add(new Product("Broccoli"));
        vegetables.add(new Product("Onion"));
        vegetables.add(new Product("Sweet Potato"));

        NutritionSort vegetable = new NutritionSort("Vegetable", vegetables);
        nutritionSorts.add(vegetable);

        ArrayList<Product> fruits = new ArrayList<>();
        fruits.add(new Product("Apple"));
        fruits.add(new Product("Pear"));
        fruits.add(new Product("Banana"));
        fruits.add(new Product("Apricot"));
        fruits.add(new Product("Peach"));
        fruits.add(new Product("Avocado"));
        fruits.add(new Product("Plum"));

        NutritionSort fruit = new NutritionSort("Fruit", fruits);
        nutritionSorts.add(fruit);

        ArrayList<Product> supplements = new ArrayList<>();
        supplements.add(new Product("Kim"));
        supplements.add(new Product("Olive Oil"));
        supplements.add(new Product("Coconut Oil"));
        supplements.add(new Product("Anise"));

        NutritionSort supplement = new NutritionSort("Supplements", supplements);
        nutritionSorts.add(supplement);

        ProductAdapter productAdapter = new ProductAdapter(nutritionSorts);
        recyclerView.setAdapter(productAdapter);

        return view;
    }

}
