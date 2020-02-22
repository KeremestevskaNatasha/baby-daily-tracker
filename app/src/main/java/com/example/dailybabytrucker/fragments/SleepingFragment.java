package com.example.dailybabytrucker.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dailybabytrucker.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class SleepingFragment extends Fragment {

    TextView tvSleepingSchadule, tvDescriptionSchadule ;
    EditText etTakeNotes;
    Button buttonSave, buttonClear;
    JSONObject saved = new JSONObject();
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    View rootView;

    public SleepingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_sleeping, container, false);

        tvSleepingSchadule= rootView.findViewById(R.id.tv_sleepingSchadule);
        tvDescriptionSchadule= rootView.findViewById(R.id.tv_descriptionSchadule);
        etTakeNotes = rootView.findViewById(R.id.et_takeNotes);
        buttonSave = rootView.findViewById(R.id.save_button);
        buttonClear = rootView.findViewById(R.id.clear_button);

//      init();

      // When we want to replace Fragment, use FragmentManager and FragmentTransaction. ToDO

//        Intent intent = getIntent();
//        if (intent.getIntExtra("position",-1) != -1){
//            try{
//                String s = etTakeNotes.getText().toString();
//                if(!preferences.getString("saved","").equals(""))
//                    saved = new JSONObject(preferences.getString("saved",""));
//                etTakeNotes.setText(saved.getString("name"+intent.getIntExtra("position",0)));
//                s = saved.getString("saved"+intent.getIntExtra("position",0));
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = etTakeNotes.getText().toString();
                if(s.isEmpty()){
                    Toast.makeText(getContext(),"Take a note!!", Toast.LENGTH_SHORT).show();
                } else {
                    etTakeNotes.setText("");
                }
            }
        });

//        buttonSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String s = etTakeNotes.getText().toString();
//                if (!s.equals("")){
//                } try {
//                    if(!preferences.getString("saved","").equals(""))
//                        saved= new JSONObject(preferences.getString("saved","0"))
//                                saved.put("saved"+saved.length(),s);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                Log.d("testing", saved+"");
//                editor.putString("saved", saved.toString());
//                editor.apply();
//                etTakeNotes.setText("");
//                Intent intent1 = new Intent (getContext().SleepingNotesFragment.class)
//            }
//        });

        return rootView;
    }

//    private void init() {
//
//        preferences = getSharedPreferences("text", Context.MODE_PRIVATE);
//        editor = preferences.edit();
//        etTakeNotes = rootView.findViewById(R.id.et_takeNotes);
//        buttonSave = rootView.findViewById(R.id.save_button);
//        buttonClear = rootView.findViewById(R.id.clear_button);
//    }
//
//    private SharedPreferences getSharedPreferences(String text, int modePrivate) {
//        return saved;
//    }

}
