package com.example.dailybabytrucker.UI.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;


import com.example.dailybabytrucker.fragments.RecipesGridFragment;
import com.example.dailybabytrucker.R;


public class MainActivity extends AppCompatActivity implements NavigationHost {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){


            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new RecipesGridFragment())
                    .commit();
        }

    }

    @Override

    public void navigateTo (Fragment fragment, boolean addToBackstack){
        FragmentTransaction transaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment);

        if(addToBackstack){
            transaction.addToBackStack(null);
        }
        transaction.commit();

    }
}