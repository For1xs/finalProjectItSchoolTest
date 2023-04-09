package com.example.testfinalproject;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CalendarView mainCalendar;

    private DatabaseReference databaseReference;
    private String stringDateSelected;
    private DatabaseReference eventDatabaseReference;

    private Button saveEventButton;
    private EditText editTextNameOfTheCompetition;
    private EditText editTextDistance;
    private EditText editTextСategory;
    private EditText editTextResult;
    private ArrayList<Event> membersOfEvent = new ArrayList<>();
    private TextView textView;
    private ArrayAdapter<String> arrayAdapter;
    private List<String> listData;
    private Button goToSecondActivity;
    private Button goToThirdActivity;
    private Button goToFourthActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goToSecondActivity = findViewById(R.id.goToSecondActivity);
        goToThirdActivity = findViewById(R.id.goToThirdActivity);
        goToFourthActivity = findViewById(R.id.goToFourthActivity);


        mainCalendar = findViewById(R.id.mainCalendar);


        goToSecondActivity.setOnClickListener(v -> {
            Intent intent = new Intent(this, TimeToCategoryActivityPage2.class);
            startActivity(intent);
        });
        goToThirdActivity.setOnClickListener(v ->{
            Intent intent = new Intent(this, YourCategoryPage3.class);
            startActivity(intent);
        });
        goToFourthActivity.setOnClickListener(v ->{
            Intent intent = new Intent(this, CalculateTimePage4.class);
            startActivity(intent);
        });





        initializeMainCalendarSelectedDayChange();
        listData = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this,R.layout.dialog_set_event, listData);
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
        setEventDialog();

        eventDatabaseReference.child(stringDateSelected).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.getValue() != null) {


//                    snapshot.getValue(SetEventFragment.class);

                    Event event = snapshot.getValue(Event.class);

                    editTextNameOfTheCompetition.setText(event.getValNameOfTheCompetition());
                }
                else {
                    //textEvent.setText("null");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


            });


        }


    private void setEventDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        ConstraintLayout constraintLayout = (ConstraintLayout) getLayoutInflater()
                .inflate(R.layout.dialog_set_event, null);
        saveEventButton = constraintLayout.findViewById(R.id.saveEventButton);
        saveEventButton.setOnClickListener( v-> {
            editTextNameOfTheCompetition = constraintLayout.findViewById(R.id.editTextNameOfTheCompetition);
            editTextDistance = constraintLayout.findViewById(R.id.editTextDistance);
            editTextСategory = constraintLayout.findViewById(R.id.editTextСategory);
            editTextResult = constraintLayout.findViewById(R.id.editTextResult);
            String mainValNameOfTheCompetition = editTextNameOfTheCompetition.getText().toString();
            String mainValDistance = editTextDistance.getText().toString();
            String mainValСategory = editTextСategory.getText().toString();
            String mainValResult = editTextResult.getText().toString();
            membersOfEvent.add(new Event
                    (mainValNameOfTheCompetition,
                    mainValDistance,
                    mainValСategory,
                    mainValResult));




            eventDatabaseReference.child(stringDateSelected).setValue(membersOfEvent);
            membersOfEvent.clear();


        });

        builder.setView(constraintLayout);
        builder.show();



    }


}