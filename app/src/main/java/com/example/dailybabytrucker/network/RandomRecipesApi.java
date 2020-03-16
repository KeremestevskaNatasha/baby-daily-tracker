package com.example.dailybabytrucker.network;

import com.example.dailybabytrucker.BuildConfig;
import com.example.dailybabytrucker.model.GetRecipesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RandomRecipesApi {

    @GET("recipes/random/?apiKey=" + BuildConfig.API_KEY)
     Call<GetRecipesResponse> getRandomRecipes();
}
