package com.example.dailybabytrucker.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailybabytrucker.R;
import com.example.dailybabytrucker.model.Note;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesHolder> {

    private ArrayList<Note> arrayList;
    private Context ctx;


    public NotesAdapter(ArrayList<Note> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public NotesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ctx = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View inflatedView = layoutInflater.inflate(R.layout.item_notes, viewGroup, false);
        return new NotesHolder(inflatedView);

    }

    @Override
    public void onBindViewHolder(@NonNull NotesHolder notesHolder, int i) {

        Note note = arrayList.get(i);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.parseLong(note.getTimeStamp()));
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatter.format(calendar.getTime());

        notesHolder.Note.setText(note.getTitle());
        notesHolder.timeStamp.setText(date);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class NotesHolder extends RecyclerView.ViewHolder {

        TextView Note, timeStamp;
        ImageButton delete;

        NotesHolder(@NonNull View itemView) {
            super(itemView);
            Note = itemView.findViewById(R.id.tvNote);
            timeStamp = itemView.findViewById(R.id.tvTimeStamp);
            delete = itemView.findViewById(R.id.btnDelete);

            SharedPreferences sharedPreferences = ctx.getSharedPreferences("myprefs", Context.MODE_PRIVATE);
            final SharedPreferences.Editor editor = sharedPreferences.edit();

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Note currentNote = arrayList.get(getAdapterPosition());
                    editor.remove(currentNote.getTimeStamp());
                    arrayList.remove(currentNote);
                    notifyDataSetChanged();
                    editor.apply();
                }
            });

        }
    }

}
