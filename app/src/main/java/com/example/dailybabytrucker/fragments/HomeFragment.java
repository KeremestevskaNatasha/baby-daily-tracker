package com.example.dailybabytrucker.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dailybabytrucker.R;
import com.example.dailybabytrucker.adapter.StaggeredRecipesCardRecyclerViewAdapter;
import com.example.dailybabytrucker.model.GetRecipesResponse;
import com.example.dailybabytrucker.model.RandomRecipes;
import com.example.dailybabytrucker.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        final RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2,
                GridLayoutManager.HORIZONTAL, false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position % 3 == 2 ? 2 : 1;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);

        RetrofitClient.getRandomRecipesApi().getRandomRecipes().enqueue(new Callback<GetRecipesResponse>() {
            @Override
            public void onResponse(Call<GetRecipesResponse> call, Response<GetRecipesResponse> response) {

                List<RandomRecipes> recipes = response.body().getRecipes();
                StaggeredRecipesCardRecyclerViewAdapter adapter = new StaggeredRecipesCardRecyclerViewAdapter(recipes);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<GetRecipesResponse> call, Throwable t) {

            }
        });


        return rootView;
    }

}
