package com.example.dailybabytrucker.fragments;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import com.example.dailybabytrucker.R;
import com.example.dailybabytrucker.UI.activities.MyAccountActivity;
import com.example.dailybabytrucker.UI.activities.NavigationIconClickListener;
import com.example.dailybabytrucker.UI.activities.SettingsActivity;



/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Button buttonHome, buttonFeeding, buttonSleeping, buttonGrowth, buttonLeisure;
    private Button buttonMyAccount, buttonSettings;
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

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setUpToolbar(view); // setup the toolBar
        getFragmentManager().beginTransaction()
                .replace(R.id.main_container, new RecipesFragment())
                .commit();



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view.findViewById(R.id.main_container)
                    .setBackgroundResource(R.drawable.product_grid_background_shape);
        }
        buttonHome = view.findViewById(R.id.homeButton);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationIconClickListener.onClick(null);
                FragmentManager fragmentManager = getFragmentManager();
                RecipesFragment recipesFragment = new RecipesFragment();
                if (fragmentManager != null) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.main_container, recipesFragment)
                            .addToBackStack(null).commit();
                }
            }
        });

        buttonFeeding = view.findViewById(R.id.feedingButton);
        buttonFeeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationIconClickListener.onClick(null);
                FragmentManager fragmentManager = getFragmentManager();
                FeedingFragment feedingFragment = new FeedingFragment();
                if (fragmentManager != null) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.main_container, feedingFragment)
                            .addToBackStack(null).commit();
                }

            }
        });

        buttonSleeping = view.findViewById(R.id.sleepingButton);
        buttonSleeping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationIconClickListener.onClick(null);
                FragmentManager fragmentManager = getFragmentManager();
                SleepingFragment sleepingFragment = new SleepingFragment();
                if (fragmentManager != null) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.main_container, sleepingFragment)
                            .addToBackStack(null).commit();
                }

            }
        });


        buttonGrowth = view.findViewById(R.id.growthButton);
        buttonGrowth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationIconClickListener.onClick(null);
                FragmentManager fragmentManager = getFragmentManager();
                GrowthFragment growthFragment = new GrowthFragment();
                if (fragmentManager != null) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.main_container, growthFragment)
                            .addToBackStack(null).commit();
                }

            }
        });

        buttonLeisure = view.findViewById(R.id.leisureButton);
        buttonLeisure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationIconClickListener.onClick(null);
                FragmentManager fragmentManager = getFragmentManager();
                LeisureFragment leisureFragment = new LeisureFragment();
                if (fragmentManager != null) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.main_container, leisureFragment)
                            .addToBackStack(null).commit();
                }

            }
        });
        buttonMyAccount = view.findViewById(R.id.myAccountButton);
        buttonMyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyAccountActivity.class);
                startActivity(intent);
            }
        });

        buttonSettings = view.findViewById(R.id.settingsButton);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);
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


//    protected void setTitle(@StringRes int stringId) {
//        setTitle(getString(stringId));
//    }
//
//    protected void setTitle(String title) {
//        FragmentActivity activity = getActivity();
//        if (activity != null) {
//            activity.setTitle(title);
//        }
//    }
}
