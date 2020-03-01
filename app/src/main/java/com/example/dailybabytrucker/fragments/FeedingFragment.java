package com.example.dailybabytrucker.fragments;


import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dailybabytrucker.R;
import com.example.dailybabytrucker.fragments.ExpandableFragments.ExpandableMain10Fragment;
import com.example.dailybabytrucker.fragments.ExpandableFragments.ExpandableMain11Fragment;
import com.example.dailybabytrucker.fragments.ExpandableFragments.ExpandableMain12Fragment;
import com.example.dailybabytrucker.fragments.ExpandableFragments.ExpandableMain6Fragment;
import com.example.dailybabytrucker.fragments.ExpandableFragments.ExpandableMain7Fragment;
import com.example.dailybabytrucker.fragments.ExpandableFragments.ExpandableMain8Fragment;
import com.example.dailybabytrucker.fragments.ExpandableFragments.ExpandableMain9Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedingFragment extends Fragment {

    CardView months6;
    CardView months7;
    CardView months8;
    CardView months9;
    CardView months10;
    CardView months11;
    CardView months12;

    public FeedingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feeding, container, false);
        months6= view.findViewById(R.id.months6);
        months7= view.findViewById(R.id.months7);
        months8= view.findViewById(R.id.months8);
        months9= view.findViewById(R.id.months9);
        months10= view.findViewById(R.id.months10);
        months11= view.findViewById(R.id.months11);
        months12= view.findViewById(R.id.months12);

        months6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                ExpandableMain6Fragment expandableMain6Fragment = new ExpandableMain6Fragment();

                if(fragmentManager != null){
                    fragmentManager.beginTransaction().replace(R.id.main_container,expandableMain6Fragment).commit();
                }

            }
        });


        months7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                ExpandableMain7Fragment expandableMain7Fragment = new ExpandableMain7Fragment();

                if(fragmentManager != null){
                    fragmentManager.beginTransaction().replace(R.id.main_container,expandableMain7Fragment).commit();
                }
            }
        });
        months8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                ExpandableMain8Fragment expandableMain8Fragment = new ExpandableMain8Fragment();

                if(fragmentManager != null){
                    fragmentManager.beginTransaction().replace(R.id.main_container,expandableMain8Fragment).commit();
                }

            }
        });
        months9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                ExpandableMain9Fragment expandableMain9Fragment = new ExpandableMain9Fragment();

                if(fragmentManager != null){
                    fragmentManager.beginTransaction().replace(R.id.main_container,expandableMain9Fragment).commit();
                }

            }
        });
        months10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                ExpandableMain10Fragment expandableMain10Fragment = new ExpandableMain10Fragment();

                if(fragmentManager != null){
                    fragmentManager.beginTransaction().replace(R.id.main_container,expandableMain10Fragment).commit();
                }

            }
        });
        months11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                ExpandableMain11Fragment expandableMain11Fragment = new ExpandableMain11Fragment();

                if(fragmentManager != null){
                    fragmentManager.beginTransaction().replace(R.id.main_container,expandableMain11Fragment).commit();
                }

            }
        });
        months12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                ExpandableMain12Fragment expandableMain12Fragment = new ExpandableMain12Fragment();

                if(fragmentManager != null){
                    fragmentManager.beginTransaction().replace(R.id.main_container,expandableMain12Fragment).commit();
                }

            }
        });

        return view;
    }
}
