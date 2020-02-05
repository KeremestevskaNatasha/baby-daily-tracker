package com.example.dailybabytrucker.network;

import com.example.dailybabytrucker.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

  private static RandomRecipesApi randomRecipesApi;


  public static RandomRecipesApi getRandomRecipesApi(){

      if (randomRecipesApi == null){
      createRandomRecipesApi();

      }

      return randomRecipesApi;
  }

    private static void createRandomRecipesApi() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
         randomRecipesApi = retrofit.create(RandomRecipesApi.class);


    }


}
