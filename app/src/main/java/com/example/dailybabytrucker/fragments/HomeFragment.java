package com.example.dailybabytrucker.fragments;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;

import com.example.dailybabytrucker.R;
import com.example.dailybabytrucker.UI.activities.NavigationIconClickListener;
import com.example.dailybabytrucker.UI.activities.SettingsActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Button buttonFeeding;
    private Toolbar toolbar;
    private NavigationIconClickListener navigationIconClickListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        setUpToolbar(view); // setup the toolBar

        getFragmentManager().beginTransaction()
                .replace(R.id.main_container, new RecipesFragment())
                .commit();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view.findViewById(R.id.main_container).setBackgroundResource(R.drawable.product_grid_background_shape);
        }

        buttonFeeding = view.findViewById(R.id.feedingButton);
        buttonFeeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FeedingFragment feedingFragment = new FeedingFragment();
                if (fragmentManager != null) {
                    fragmentManager.beginTransaction().replace(R.id.main_container, feedingFragment).commit();
                }

            }
        });



        return view;
    }

    private void setUpToolbar(View view) {
        toolbar = view.findViewById(R.id.app_bar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
        }

        navigationIconClickListener = new NavigationIconClickListener(
                getContext(),
                view.findViewById(R.id.main_container),
                new AccelerateDecelerateInterpolator(),
                getContext().getResources().getDrawable(R.drawable.dbt_menu), // Menu open icon
                getContext().getResources().getDrawable(R.drawable.close_menu));
        toolbar.setNavigationOnClickListener(navigationIconClickListener); // Menu close icon
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.dbt_toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.settings1) {
            Intent intent = new Intent(getContext(), SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
}