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
public class ExpandableMain8Fragment extends Fragment {


    public ExpandableMain8Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_expandable_main8, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.expandRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<NutritionSort> nutritionSorts = new ArrayList<>();

        ArrayList<Product> cerealsAndSeeds = new ArrayList<>();
        cerealsAndSeeds.add(new Product("Wheat and wheat flakes"));
        cerealsAndSeeds.add(new Product("Oatmeal and oat flakes"));
        cerealsAndSeeds.add(new Product("Rye and rye flakes"));
        cerealsAndSeeds.add(new Product("Barley and barley flakes"));
        cerealsAndSeeds.add(new Product("Wheat flour"));
        cerealsAndSeeds.add(new Product("Spell(pasta,flakes)"));

        NutritionSort cerealSeeds = new NutritionSort("Cereals and Seeds", cerealsAndSeeds);
        nutritionSorts.add(cerealSeeds);


        ArrayList<Product> vegetables = new ArrayList<>();
        vegetables.add(new Product("Beanie"));
        vegetables.add(new Product("Beetroot"));


        NutritionSort vegetable = new NutritionSort("Vegetable", vegetables);
        nutritionSorts.add(vegetable);

        ArrayList<Product> diaryProducts = new ArrayList<>();
        diaryProducts.add(new Product("Yogurt"));
        diaryProducts.add(new Product("Kefir"));
        diaryProducts.add(new Product("Sour milk"));
        diaryProducts.add(new Product("Butter"));
        diaryProducts.add(new Product("All dairy products should be whole fat"));


        NutritionSort diaryProduct = new NutritionSort("Diary Product", diaryProducts);
        nutritionSorts.add(diaryProduct);


        ArrayList<Product> meat = new ArrayList<>();
        meat.add(new Product("Baby Beef"));
        meat.add(new Product("White Chicken"));
        meat.add(new Product("white Turkey"));

        NutritionSort meats = new NutritionSort("Meat", meat);
        nutritionSorts.add(meats);

        ArrayList<Product> supplements = new ArrayList<>();
        supplements.add(new Product("Agave syrup"));
        supplements.add(new Product("Rape oil"));
        supplements.add(new Product("Rice sweetness"));


        NutritionSort supplement = new NutritionSort("Supplements", supplements);
        nutritionSorts.add(supplement);

        ProductAdapter productAdapter = new ProductAdapter(nutritionSorts);
        recyclerView.setAdapter(productAdapter);

        return view;
    }

}
