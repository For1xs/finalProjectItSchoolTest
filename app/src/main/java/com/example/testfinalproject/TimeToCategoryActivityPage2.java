package com.example.testfinalproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testfinalproject.data.RankTableManAutoData;
import com.example.testfinalproject.data.RankTableWomanAutoData;

import java.util.Objects;

public class TimeToCategoryActivityPage2 extends AppCompatActivity {

    EditText distanceEditText;
    EditText categoryRunEditText;
    EditText categoryEditText;
    Button findTimeButton;
    TextView yourCategory;
    RankTableManAutoData rankTableManAutoData = new RankTableManAutoData();
    RankTableWomanAutoData rankTableWomanAutoData = new RankTableWomanAutoData();
    String valCategoryRunEditText;
    String valCategoryEditText;

    String valDistanceEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_to_category_page2);
        init();
        onClick();
    }
    private void init(){
        distanceEditText = findViewById(R.id.distanceEditText);
        categoryRunEditText = findViewById(R.id.categoryRunEditText);
        categoryEditText = findViewById(R.id.categoryEditText);
        findTimeButton = findViewById(R.id.findTimeButton);
        yourCategory = findViewById(R.id.yourCategory);
    }
    private void onClick(){


        findTimeButton.setOnClickListener( v-> {
            valDistanceEditText = distanceEditText.getText().toString();
            valCategoryRunEditText = categoryRunEditText.getText().toString();
            valCategoryEditText = categoryEditText.getText().toString();
            if(getFirstIndex() == 69 || getSecondIndex() == 69 || !Objects.equals(valCategoryRunEditText, "Woman auto") || !valCategoryRunEditText.equals("Man auto")){
                yourCategory.setText("Неправильные данные");
            }
            else{
                if(Objects.equals(valCategoryRunEditText, "Woman auto")){
                    String time = String.valueOf(rankTableWomanAutoData.getRankTableWomanAuto()[getFirstIndex()][getSecondIndex()]);
                    yourCategory.setText(time);
                }
                else if(Objects.equals(valCategoryRunEditText, "Man auto")){
                    String time = String.valueOf(rankTableManAutoData.getRankTableManAuto()[getFirstIndex()][getSecondIndex()]);
                    yourCategory.setText(time);
                }
            }




        });








    }
    private int getFirstIndex(){
        int index1 = 0;

        if(Objects.equals(valDistanceEditText, "60")){
            index1 = 0;

        }
        else if(Objects.equals(valDistanceEditText, "100")){
            index1 = 1;
        }
        else if(Objects.equals(valDistanceEditText, "200")){
            index1 = 2;
        }
        else if(Objects.equals(valDistanceEditText, "200 200")){
            index1 = 3;
        }
        else if(Objects.equals(valDistanceEditText, "300")){
            index1 = 4;
        }
        else if(Objects.equals(valDistanceEditText, "400 400")){
            index1 = 5;
        }
        else if(Objects.equals(valDistanceEditText, "400 200")){
            index1 = 6;
        }
        else if(Objects.equals(valDistanceEditText, "600 400")){
            index1 = 7;
        }
        else if(Objects.equals(valDistanceEditText, "600 200")){
            index1 = 8;
        }
        else if(Objects.equals(valDistanceEditText, "800 400")){
            index1 = 9;
        }
        else if(Objects.equals(valDistanceEditText, "800 200")){
            index1 = 10;
        }
        else if(Objects.equals(valDistanceEditText, "1000 400")){
            index1 = 11;
        }
        else if(Objects.equals(valDistanceEditText, "1000 200")){
            index1 = 12;
        }
        else if(Objects.equals(valDistanceEditText, "1500 400")){
            index1 = 13;
        }
        else if(Objects.equals(valDistanceEditText, "1500 200")){
            index1 = 14;
        }
        else if(Objects.equals(valDistanceEditText, "1 мил")){
            index1 = 15;
        }
        else if(Objects.equals(valDistanceEditText, "3000 400")){
            index1 = 16;
        }
        else if(Objects.equals(valDistanceEditText, "3000 200")){
            index1 = 17;
        }
        else if(Objects.equals(valDistanceEditText, "5000")){
            index1 = 18;
        }
        else if(Objects.equals(valDistanceEditText, "10000")){
            index1 = 19;
        }
        if(index1 == 0 && !Objects.equals(valDistanceEditText, "60")){
            return 69;
        }
        else{
            return index1;
        }


    }
    private int getSecondIndex(){
        int index2 = 0;
        if(Objects.equals(valCategoryEditText, "MSMK")){
            index2 = 0;
        }
        else if(Objects.equals(valCategoryEditText, "MS")){
            index2 = 1;
        }
        else if(Objects.equals(valCategoryEditText, "KMS")){
            index2 = 2;
        }
        else if(Objects.equals(valCategoryEditText, "I")){
            index2 = 3;
        }
        else if(Objects.equals(valCategoryEditText, "II")){
            index2 = 4;
        }
        else if(Objects.equals(valCategoryEditText, "III")){
            index2 = 5;
        }
        else if(Objects.equals(valCategoryEditText, "I(y)")){
            index2 = 6;
        }
        else if(Objects.equals(valCategoryEditText, "II(y)")){
            index2 = 7;
        }
        else if(Objects.equals(valCategoryEditText, "III(y)")){
            index2 = 8;
        }
        if(index2 == 0 && !Objects.equals(valCategoryEditText, "MSMK")){
            return 69;
        }
        else{
            return index2;
        }
    }
}