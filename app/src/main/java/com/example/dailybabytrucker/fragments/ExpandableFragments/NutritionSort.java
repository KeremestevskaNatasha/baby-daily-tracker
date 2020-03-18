package com.example.dailybabytrucker.fragments.ExpandableFragments;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class NutritionSort extends ExpandableGroup<Product> {
    public NutritionSort(String title, List<Product> items) {
        super(title, items);
    }
}
