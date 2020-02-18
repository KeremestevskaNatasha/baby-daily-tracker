package com.example.dailybabytrucker.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dailybabytrucker.R;
import com.example.dailybabytrucker.fragments.ExpandableFragments.ExpandableMainFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedingFragment extends Fragment {

    private Button button6PlusMonths;
    private Button button7PlusMonths;
    private Button button8PlusMonths;
    private Button button9PlusMonths;
    private Button button10PlusMonths;
    private Button button11PlusMonths;
    private Button button12PlusMonths;


    public FeedingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feeding, container, false);

        getFragmentManager().beginTransaction()
                .replace(R.id.main_container, new ExpandableMainFragment())
                .commit();

        button6PlusMonths=view.findViewById(R.id.months6);
        button6PlusMonths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                ExpandableMainFragment expandableMainFragment = new ExpandableMainFragment();
                if (fragmentManager != null) {
                    fragmentManager.beginTransaction().replace(R.id.main_container, expandableMainFragment).commit();
                }

            }
        });



        return view;
    }

}
