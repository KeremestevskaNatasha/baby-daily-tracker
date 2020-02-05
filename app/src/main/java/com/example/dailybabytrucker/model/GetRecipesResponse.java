package com.example.dailybabytrucker.model;

import java.util.List;

public class GetRecipesResponse {

    private List<RandomRecipes> recipes;

    public GetRecipesResponse() {

    }

    public GetRecipesResponse(List<RandomRecipes> recipes) {
        this.recipes = recipes;
    }

    public List<RandomRecipes> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RandomRecipes> recipes) {
        this.recipes = recipes;
    }
}