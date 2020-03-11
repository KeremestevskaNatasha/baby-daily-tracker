package com.example.dailybabytrucker.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dailybabytrucker.R;
import com.example.dailybabytrucker.adapter.GrowthRecyclerViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class GrowthFragment extends Fragment {

    private RecyclerView rvGrowth;
    int[] imgGrowth;
    String[] imgTitle;
    String[] descGrowth;
    String[] placeGuide;


    public GrowthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_growth, container, false);
        rvGrowth = view.findViewById(R.id.rvGrowth);

        imgGrowth = new int[]{
                R.drawable.promo_1_month, R.drawable.promo_2_month, R.drawable.promo_3_month,
                R.drawable.promo_4_month, R.drawable.promo_5_month, R.drawable.promo_6_month,
                R.drawable.promo_7_month, R.drawable.promo_8_month, R.drawable.promo_9_month,
                R.drawable.promo_10_month, R.drawable.promo_11_month, R.drawable.promo_12_month
        };

        imgTitle = new String[]{
                "Your baby's growth and development - 1 month old",
                "Your baby's growth and development - 2 months old",
                "Your baby's growth and development - 3 months old",
                "Your baby's growth and development - 4 months old",
                "Your baby's growth and development - 5 months old",
                "Your baby's growth and development - 6 months old",
                "Your baby's growth and development - 7 months old",
                "Your baby's growth and development - 8 months old",
                "Your baby's growth and development - 9 months old",
                "Your baby's growth and development - 10 months old",
                "Your baby's growth and development - 11 months old",
                "Your baby's growth and development - 12 months old"
        };

        descGrowth = new String[]{
                "Infant development begins at at birth and they grow fast and learn a lot.\n" +
                        "\t\tAt 1 month, cuddling, sleeping and feeding are all that really matters to your baby.\n" +
                        "\t\tThe time you spend with them will help their brain to grow and develop as they start to experience the world.",
                "Your 2-month-old is growing fast and becoming more alert.\n" +
                        "\t\tThey will be making more sounds and getting more skilled at moving their body.\n" +
                        "\t\tThey will still be crying a lot - but you’ve probably already seen that magic first smile (usually at 6 weeks) which somehow makes all the hard work worthwhile.",
                "By 3 months, your baby will have formed a strong attachment to you.\n" +
                        "\t\tThey will respond to you with lots of smiles, and might even talk back to you in their own way.\n" +
                        "\t\tThe worst of the crying should be nearly over, and you can really enjoy your baby as they grow into their own little person",
                "From 4 months, your baby will quickly be learning to coordinate their body.\n" +
                        "\t\tThey will have more control over what they do, their vision, touch and hearing will be much more developed, and they will start to move around much more.\n" +
                        "\t\tThey can communicate much better too, and the number of hours for which they cry should have settled by now.",
                "Your baby will be growing and developing rapidly now.\n" +
                        "\t\tThey are learning more about the world and how they fit into it. Many of the new things your baby is learning at 5 months are preparing them for eating solid food.\n" +
                        "\t\tIt is usually recommended you introduce solids at 6 months, but some babies are ready as early as 4 months.\n" +
                        "\t\tSo, if you think it’s time, it’s fine to start experimenting with solids now.",
                "Six months is an exciting time and your baby will now be developing very fast.\n" +
                        "\t\tThe left side of their brain will have has started communicating with the right side, meaning they can coordinate their body better.\n" +
                        "\t\tYou will be understanding your baby much better now as they let you know whether they’re happy or sad and start to respond to words",
                "Your baby is now growing up fast.\n" +
                        "\t\tThey may well be sitting on their own, eating solid foods - although breastmilk or formula will still be their main source of nutrition - and understanding more about what you want from them.\n" +
                        "\t\tIt’s an exciting time to watch them grow",
                "Your 8-month-old is probably getting into everything and moving around a lot as they explore the world.\n" +
                        "\t\tThis means more work for you, but it’s wonderful to watch their fascination grow.",
                "At around 9 months, babies’ brains have a growth spurt.\n" +
                        "\t\tThey will really be developing a personality now, and you’ll be getting a glimpse of the child they’re going to grow into.",
                "Your 10-month-old will now be very active.\n" +
                        "\t\tYou’ll probably be chasing around after them as they crawl and pull themselves up onto furniture, and you’ll be learning more about your baby’s developing personality.",
                "At 11 months old, your baby will be almost a toddler, and they will be maturing fast.\n" +
                        "\t\tYou’ll probably be surprised how quickly they can move around your home and how independent they are becoming",
                "At 12 months, your baby is officially a toddler.\n" +
                        "\t\tIf they haven’t already, it won’t be long now before they take their first steps, develop a sense of humour, and tell you they love you.",
        };

        placeGuide = new String[]{
                "https://www.pregnancybirthbaby.org.au/babys-growth-and-development-1-month-old",
                "https://www.pregnancybirthbaby.org.au/babys-growth-and-development-2-months-old",
                "https://www.pregnancybirthbaby.org.au/babys-growth-and-development-3-months-old",
                "https://www.pregnancybirthbaby.org.au/babys-growth-and-development-4-months-old",
                "https://www.pregnancybirthbaby.org.au/babys-growth-and-development-5-months-old",
                "https://www.pregnancybirthbaby.org.au/babys-growth-and-development-6-months-old",
                "https://www.pregnancybirthbaby.org.au/babys-growth-and-development-7-months-old",
                "https://www.pregnancybirthbaby.org.au/babys-growth-and-development-8-months-old",
                "https://www.pregnancybirthbaby.org.au/babys-growth-and-development-9-months-old",
                "https://www.pregnancybirthbaby.org.au/babys-growth-and-development-10-months-old",
                "https://www.pregnancybirthbaby.org.au/babys-growth-and-development-11-months-old",
                "https://www.pregnancybirthbaby.org.au/babys-growth-and-development-12-months-old"
        };


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvGrowth.setLayoutManager(linearLayoutManager);
        GrowthRecyclerViewAdapter adapter =
                new GrowthRecyclerViewAdapter(getContext(), imgGrowth, imgTitle, descGrowth, placeGuide);
        rvGrowth.setAdapter(adapter);


        return view;
    }
}
