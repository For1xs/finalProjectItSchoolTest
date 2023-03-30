package com.example.testfinalproject;

import static android.os.Build.VERSION_CODES.M;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import java.util.ArrayList;

public class SetEventFragment extends Fragment {

    private Button saveEventButton;
    private EditText editTextNameOfTheCompetition;
    private EditText editTextDistance;
    private EditText editTextСategory;
    private EditText editTextResult;
    MainActivity mainActivity;


    public SetEventFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_event, null);
        saveEventButton = view.findViewById(R.id.saveEventButton);
        editTextNameOfTheCompetition = view.findViewById(R.id.editTextNameOfTheCompetition);
        editTextDistance = view.findViewById(R.id.editTextDistance);
        editTextСategory = view.findViewById(R.id.editTextСategory);
        editTextResult = view.findViewById(R.id.editTextResult);

        onClick(view);

        return view;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainActivity = (MainActivity) getActivity();

    }
    public void onClick(View view) {
        saveEventButton.setOnClickListener( v -> {
            String valNameOfTheCompetition = editTextNameOfTheCompetition.getText().toString();
            String valDistance = editTextDistance.getText().toString();
            String valСategory = editTextСategory.getText().toString();
            String valResult = editTextResult.getText().toString();
            ArrayList<String> membersOfEvent = new ArrayList<>();
            membersOfEvent.add(valNameOfTheCompetition);
            membersOfEvent.add(valDistance);
            membersOfEvent.add(valСategory);
            membersOfEvent.add(valResult);

            mainActivity.getEventDatabaseReference().child(mainActivity.getStringDateSelected()).setValue(membersOfEvent);

        });
    }


}