package com.example.dailybabytrucker.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dailybabytrucker.R;
import com.example.dailybabytrucker.adapter.NotesAdapter;
import com.example.dailybabytrucker.model.Note;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class SleepingFragment extends Fragment {

    TextView tvSleepingSchadule;
    EditText etTakeNotes;
    ImageButton btnAddNote;

    ArrayList<Note> arrayList = new ArrayList<>();
    ArrayList<String> notes = null;

    public SleepingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sleeping, container, false);

        tvSleepingSchadule = view.findViewById(R.id.tv_sleepingSchedule);



        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("myprefs", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        final EditText etTakeNotes = view.findViewById(R.id.etNote);
        btnAddNote = view.findViewById(R.id.btnAddNote);

        Map<String, String> map = (Map<String, String>) sharedPreferences.getAll();
        Set<String> keySet = map.keySet();

        notes = new ArrayList<>(keySet);

        for (int i = 0; i < notes.size(); i++) {
            String title = map.get(notes.get(i));
            String timeStamp = notes.get(i);
            arrayList.add(new Note(title, timeStamp));
        }


        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        final NotesAdapter notesAdapter = new NotesAdapter(arrayList);


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(notesAdapter);

        btnAddNote = view.findViewById(R.id.btnAddNote);
        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long sec = System.currentTimeMillis();
                String etText = etTakeNotes.getText().toString();
                if (etText.equals("")) {
                    return;
                }
                editor.putString("" + sec, etText);
                arrayList.add(new Note(etTakeNotes.getText().toString(), "" + sec));
                notesAdapter.notifyDataSetChanged();
                editor.apply();
                etTakeNotes.setText("");


//                FragmentManager fragmentManager = getFragmentManager();
//                NotesFragment notesFragment = new NotesFragment();
//                if (fragmentManager != null) {
//                    fragmentManager.beginTransaction().replace(R.id.main_container, notesFragment).commit();
//                }
            }
        });


        return view;
    }
}


