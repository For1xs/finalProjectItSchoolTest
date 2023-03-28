package com.example.testfinalproject;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CalendarView mainCalendar;
    private Gson gson;
    private EditText textEvent;
    public Button saveEventButton;
    private DatabaseReference databaseReference;
    private String stringDateSelected;
    private DatabaseReference eventDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainCalendar = findViewById(R.id.mainCalendar);
        textEvent = findViewById(R.id.textEvent);
        saveEventButton = findViewById(R.id.saveEventButton);
        initializeMainCalendarSelectedDayChange();
        databaseReference = FirebaseDatabase.getInstance("https://final-project-test-3-eeba5-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .getReference();
        eventDatabaseReference = databaseReference.child("Calendar");


    }

    private void initializeMainCalendarSelectedDayChange(){
        mainCalendar.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            stringDateSelected = dayOfMonth + ":" + (month + 1) + ":" + year;
            calendarClicked();
        });
    }

    private void calendarClicked(){
        openSetEventFragment();
        eventDatabaseReference.child(stringDateSelected).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.getValue() != null) {
                    textEvent.setText(snapshot.getValue().toString());//НАДО ПОМЕНЯТЬ
                }
                else {
                    textEvent.setText("null");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        saveEventButton.setOnClickListener(v -> {
            String event = textEvent.getText().toString();
            eventDatabaseReference.child(stringDateSelected).setValue(event);
        });
    }
    private void openSetEventFragment() {
        SetEventFragment setEventFragment = new SetEventFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.conteinerOfFragment, setEventFragment);
        fragmentTransaction.commit();
    }
}