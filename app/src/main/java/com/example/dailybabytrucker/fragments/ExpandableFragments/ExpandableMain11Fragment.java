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
public class ExpandableMain11Fragment extends Fragment {


    public ExpandableMain11Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expandable_main11, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.expandRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<NutritionSort> nutritionSorts = new ArrayList<>();

        ArrayList<Product> vegetables = new ArrayList<>();
        vegetables.add(new Product("Beans"));
        vegetables.add(new Product("Corn"));

        NutritionSort vegetable = new NutritionSort("Vegetable", vegetables);
        nutritionSorts.add(vegetable);

        ArrayList<Product> fruits = new ArrayList<>();
        fruits.add(new Product("Watermelon"));
        fruits.add(new Product("Melon"));
        fruits.add(new Product("Grapes"));
        fruits.add(new Product("Blackberries"));
        fruits.add(new Product("Raspberries"));
        fruits.add(new Product("Blueberries"));
        fruits.add(new Product("Grinders"));

        NutritionSort fruit = new NutritionSort("Fruit", fruits);
        nutritionSorts.add(fruit);

        ArrayList<Product> meat = new ArrayList<>();
        meat.add(new Product("Dark turkey"));
        meat.add(new Product("Dark chicken"));
        NutritionSort meats = new NutritionSort("Meat", meat);
        nutritionSorts.add(meats);

        ArrayList<Product> supplements = new ArrayList<>();
        supplements.add(new Product("Breckland Thyme"));
        supplements.add(new Product("Maijun"));


        NutritionSort supplement = new NutritionSort("Supplements", supplements);
        nutritionSorts.add(supplement);

        ProductAdapter productAdapter = new ProductAdapter(nutritionSorts);
        recyclerView.setAdapter(productAdapter);

        return view;
    }

}
