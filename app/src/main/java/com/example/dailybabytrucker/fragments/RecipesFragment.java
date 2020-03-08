package com.example.dailybabytrucker.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

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
public class RecipesFragment extends Fragment {
    private static final int NUM_COLUMNS = 2;
    private ProgressBar progressBar;
    private TextView tvError;

    public RecipesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recipes_grid, container, false);

        progressBar = rootView.findViewById(R.id.progressBar);
        tvError = rootView.findViewById(R.id.tvError);

//         set up recyclerView
//        final RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
//        recyclerView.setHasFixedSize(true);

        final RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.HORIZONTAL, false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position % 3 == 2 ? 2 : 1;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);


        //RW, want TO BE
        // staggered asymmetric grid layout cards, BUT m doing something wrong, just set as linear

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager
//                (getContext(), RecyclerView.HORIZONTAL, false);
//        recyclerView.setLayoutManager(linearLayoutManager);


        // set the call-retrofit

        RetrofitClient.getRandomRecipesApi().getRandomRecipes().enqueue(new Callback<GetRecipesResponse>() {
            @Override
            public void onResponse(Call<GetRecipesResponse> call, Response<GetRecipesResponse> response) {

                progressBar.setVisibility(View.GONE);
                tvError.setVisibility(View.GONE);

                List<RandomRecipes> recipes = response.body().getRecipes();

//                StaggeredRecipesCardRecyclerViewAdapter adapter =
//                        new StaggeredRecipesCardRecyclerViewAdapter(getContext(), recipes);
//                recyclerView.setAdapter(adapter);   // the 2 lines set in the onResponse od Retrofit


                StaggeredRecipesCardRecyclerViewAdapter adapter =
                        new StaggeredRecipesCardRecyclerViewAdapter(getContext(), recipes);
                 recyclerView.setAdapter(adapter);
                int largePadding = getResources().getDimensionPixelSize(R.dimen.shr_staggered_product_grid_spacing_large);
                int smallPadding = getResources().getDimensionPixelSize(R.dimen.shr_staggered_product_grid_spacing_small);
                recyclerView.addItemDecoration(new ProductGridItemDecoration(largePadding, smallPadding));



//                int largePadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing);
//                int smallPadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small);
//                recyclerView.addItemDecoration(new ProductGridItemDecoration(largePadding, smallPadding));

            }

            @Override
            public void onFailure(Call<GetRecipesResponse> call, Throwable t) {

                progressBar.setVisibility(View.GONE);
                tvError.setVisibility(View.GONE);

            }
        });


        return rootView;
    }

}
