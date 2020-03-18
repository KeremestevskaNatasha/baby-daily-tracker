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
public class ExpandableMain12Fragment extends Fragment {


    public ExpandableMain12Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expandable_main12, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.expandRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<NutritionSort> nutritionSorts = new ArrayList<>();

        ArrayList<Product> cerealsAndSeeds = new ArrayList<>();
        cerealsAndSeeds.add(new Product("Nettle Seed"));
        cerealsAndSeeds.add(new Product("Sunflower"));
        cerealsAndSeeds.add(new Product("Pumpkin seeds"));
        cerealsAndSeeds.add(new Product("Cia Seeds"));
        cerealsAndSeeds.add(new Product("Sesame"));

        NutritionSort cerealSeeds = new NutritionSort("Cereals and Seeds", cerealsAndSeeds);
        nutritionSorts.add(cerealSeeds);


        ArrayList<Product> nuts = new ArrayList<>();
        nuts.add(new Product("Nuts"));
        nuts.add(new Product("Almonds"));
        nuts.add(new Product("Hazelnut"));
        nuts.add(new Product("Peanuts"));

        NutritionSort nut = new NutritionSort("Nuts", nuts);
        nutritionSorts.add(nut);

        ArrayList<Product> vegetables = new ArrayList<>();
        vegetables.add(new Product("Cucumber"));
        vegetables.add(new Product("Lens"));


        NutritionSort vegetable = new NutritionSort("Vegetable", vegetables);
        nutritionSorts.add(vegetable);

        ArrayList<Product> diaryProducts = new ArrayList<>();
        diaryProducts.add(new Product("Milk"));
        diaryProducts.add(new Product("Sour cream"));
        diaryProducts.add(new Product("Cheese"));
        diaryProducts.add(new Product("All dairy products should be whole fat"));


        NutritionSort diaryProduct = new NutritionSort("Diary Product", diaryProducts);
        nutritionSorts.add(diaryProduct);

        ArrayList<Product> fruits = new ArrayList<>();
        fruits.add(new Product("Lemon"));
        fruits.add(new Product("Orange"));
        fruits.add(new Product("Strawberries"));
        fruits.add(new Product("Kiwi"));
        fruits.add(new Product("Aronia"));
        fruits.add(new Product("Mango"));
        fruits.add(new Product("Pineapple"));
        fruits.add(new Product("Dates"));
        fruits.add(new Product("Pomegranate"));


        NutritionSort fruit = new NutritionSort("Fruit", fruits);
        nutritionSorts.add(fruit);

        ArrayList<Product> supplements = new ArrayList<>();
        supplements.add(new Product("Salt"));
        supplements.add(new Product("Cacao"));
        supplements.add(new Product("Honey"));
        supplements.add(new Product("Pepper"));
        supplements.add(new Product("Almond milk"));
        supplements.add(new Product("Flax oil"));

        NutritionSort supplement = new NutritionSort("Supplements", supplements);
        nutritionSorts.add(supplement);

        ProductAdapter productAdapter = new ProductAdapter(nutritionSorts);
        recyclerView.setAdapter(productAdapter);

        return view;
    }
}
