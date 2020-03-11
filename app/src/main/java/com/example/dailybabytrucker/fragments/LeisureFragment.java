package com.example.dailybabytrucker.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dailybabytrucker.R;
import com.example.dailybabytrucker.adapter.VideosRecyclerViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeisureFragment extends Fragment {

    private RecyclerView recyclerViewVideos;
    int[] imgVideos;
    String[] videoTitle;
    String[] placeGuideVideos;
    private Button btnWatchVideo;


    public LeisureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_leisure, container, false);
        recyclerViewVideos = rootView.findViewById(R.id.recyclerViewVideos);

        imgVideos = new int[]{
                R.drawable.learn_abc_phonics_shapes_with_morphle,
                R.drawable.learn_colors_with_morphle,
                R.drawable.learn_numbers_letters_with_morphle,
                R.drawable.learn_shapes_with_morphle,
                R.drawable.morphle_in_space};

        videoTitle = new String[]{
                "Learn ABC,phonics,shapes with Morphle",
                "Learn colors with Morphle",
                "Learn numbers,letters with Morphle",
                "Learn shapes with Morphle",
                "Morphle in space"};

        placeGuideVideos = new String[]{
                "https://www.youtube.com/watch?v=v3VLDuRpq6k",
                "https://www.youtube.com/watch?v=Y0ENlAyZ4Oo",
                "https://www.youtube.com/watch?v=TImGKb4aqag",
                "https://www.youtube.com/watch?v=xhN5Zkm82DA",
                "https://www.youtube.com/watch?v=EzARdgcOvlo"};


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewVideos.setLayoutManager(linearLayoutManager);
        VideosRecyclerViewAdapter adapter =
                new VideosRecyclerViewAdapter(getContext(),
                        imgVideos, videoTitle, placeGuideVideos, btnWatchVideo);
        recyclerViewVideos.setAdapter(adapter);

        return rootView;

    }

}
