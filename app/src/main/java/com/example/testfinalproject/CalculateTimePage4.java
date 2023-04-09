package com.example.testfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.testfinalproject.data.RankTableManAutoData;
import com.example.testfinalproject.data.RankTableWomanAutoData;

import java.util.Objects;

public class CalculateTimePage4 extends AppCompatActivity {
    private EditText distanceEditTextPage4;
    private EditText categoryEditTextPage4;
    private EditText categoryRunEditTextPage4;
    private EditText roundEditTextPage4;
    private Button calculateButtonPage4;
    private TextView timeToRoundTextViewPage4;
    private String valDistanceEditTextPage4;
    private String valCategoryEditTextPage4;
    private String valCategoryRunEditTextPage4;
    private String valRoundEditTextPage4;
    private final RankTableManAutoData rankTableManAutoData = new RankTableManAutoData();
    private final RankTableWomanAutoData rankTableWomanAutoData = new RankTableWomanAutoData();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_time_page4);
        init();
        onClick();
    }
    private void init(){
        distanceEditTextPage4 = findViewById(R.id.distanceEditTextPage4);
        categoryEditTextPage4 = findViewById(R.id.categoryEditTextPage4);
        categoryRunEditTextPage4 = findViewById(R.id.categoryRunEditTextPage4);
        roundEditTextPage4 = findViewById(R.id.roundEditTextPage4);
        calculateButtonPage4 = findViewById(R.id.calculateButtonPage4);
        timeToRoundTextViewPage4 = findViewById(R.id.timeToRoundTextViewPage4);
    }
    private void onClick(){
        calculateButtonPage4.setOnClickListener( v->{
            valDistanceEditTextPage4 = distanceEditTextPage4.getText().toString();
            valCategoryEditTextPage4 = categoryEditTextPage4.getText().toString();
            valCategoryRunEditTextPage4 = categoryRunEditTextPage4.getText().toString();
            valRoundEditTextPage4 = roundEditTextPage4.getText().toString();


            if(calculateTimeToRound() == 0){
                timeToRoundTextViewPage4.setText("Неправильные данные");
            }
            else{
                timeToRoundTextViewPage4.setText((int) calculateTimeToRound());
            }
        });
    }

    private double calculateTimeToRound(){
        double valCalculateTimeToRound = 0;
        String[] arrayOfStrings = valDistanceEditTextPage4.split(" ");
        double numberOfRounds = Double.parseDouble(arrayOfStrings[0])/Double.parseDouble(valRoundEditTextPage4);


        String[] arrayOfDouble = String.valueOf(getTime()).split("[.]");
        double seconds = Double.parseDouble(arrayOfDouble[0]);
        valCalculateTimeToRound = seconds / numberOfRounds;

        return valCalculateTimeToRound;
    }

    private double getTime(){
        double time = 0;
        if(getFirstIndex() == 100 || getSecondIndex() == 100 || !Objects.equals(valCategoryRunEditTextPage4, "Woman auto") || !valCategoryRunEditTextPage4.equals("Man auto")){
            return time;
        }
        else{
            if(Objects.equals(valCategoryRunEditTextPage4, "Woman auto")){
                time = rankTableWomanAutoData.getRankTableWomanAuto()[getFirstIndex()][getSecondIndex()];

            }
            else if(Objects.equals(valCategoryRunEditTextPage4, "Man auto")){
                time = rankTableManAutoData.getRankTableManAuto()[getFirstIndex()][getSecondIndex()];

            }
        }
        return time;
    }
    private int getFirstIndex(){
        int index1 = 0;

        if(Objects.equals(valDistanceEditTextPage4, "60")){
            index1 = 0;

        }
        else if(Objects.equals(valDistanceEditTextPage4, "100")){
            index1 = 1;
        }
        else if(Objects.equals(valDistanceEditTextPage4, "200")){
            index1 = 2;
        }
        else if(Objects.equals(valDistanceEditTextPage4, "200 200")){
            index1 = 3;
        }
        else if(Objects.equals(valDistanceEditTextPage4, "300")){
            index1 = 4;
        }
        else if(Objects.equals(valDistanceEditTextPage4, "400 400")){
            index1 = 5;
        }
        else if(Objects.equals(valDistanceEditTextPage4, "400 200")){
            index1 = 6;
        }
        else if(Objects.equals(valDistanceEditTextPage4, "600 400")){
            index1 = 7;
        }
        else if(Objects.equals(valDistanceEditTextPage4, "600 200")){
            index1 = 8;
        }
        else if(Objects.equals(valDistanceEditTextPage4, "800 400")){
            index1 = 9;
        }
        else if(Objects.equals(valDistanceEditTextPage4, "800 200")){
            index1 = 10;
        }
        else if(Objects.equals(valDistanceEditTextPage4, "1000 400")){
            index1 = 11;
        }
        else if(Objects.equals(valDistanceEditTextPage4, "1000 200")){
            index1 = 12;
        }
        else if(Objects.equals(valDistanceEditTextPage4, "1500 400")){
            index1 = 13;
        }
        else if(Objects.equals(valDistanceEditTextPage4, "1500 200")){
            index1 = 14;
        }
        else if(Objects.equals(valDistanceEditTextPage4, "1 мил")){
            index1 = 15;
        }
        else if(Objects.equals(valDistanceEditTextPage4, "3000 400")){
            index1 = 16;
        }
        else if(Objects.equals(valDistanceEditTextPage4, "3000 200")){
            index1 = 17;
        }
        else if(Objects.equals(valDistanceEditTextPage4, "5000")){
            index1 = 18;
        }
        else if(Objects.equals(valDistanceEditTextPage4, "10000")){
            index1 = 19;
        }
        if(index1 == 0 && !Objects.equals(valDistanceEditTextPage4, "60")){
            return 100;
        }
        else{
            return index1;
        }


    }
    private int getSecondIndex(){
        int index2 = 0;
        if(Objects.equals(valCategoryEditTextPage4, "MSMK")){
            index2 = 0;
        }
        else if(Objects.equals(valCategoryEditTextPage4, "MS")){
            index2 = 1;
        }
        else if(Objects.equals(valCategoryEditTextPage4, "KMS")){
            index2 = 2;
        }
        else if(Objects.equals(valCategoryEditTextPage4, "I")){
            index2 = 3;
        }
        else if(Objects.equals(valCategoryEditTextPage4, "II")){
            index2 = 4;
        }
        else if(Objects.equals(valCategoryEditTextPage4, "III")){
            index2 = 5;
        }
        else if(Objects.equals(valCategoryEditTextPage4, "I(y)")){
            index2 = 6;
        }
        else if(Objects.equals(valCategoryEditTextPage4, "II(y)")){
            index2 = 7;
        }
        else if(Objects.equals(valCategoryEditTextPage4, "III(y)")){
            index2 = 8;
        }
        if(index2 == 0 && !Objects.equals(valCategoryEditTextPage4, "MSMK")){
            return 100;
        }
        else{
            return index2;
        }
    }

}