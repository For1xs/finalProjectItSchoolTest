package com.example.testfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.testfinalproject.data.RankTableManAutoData;
import com.example.testfinalproject.data.RankTableWomanAutoData;

import java.util.Objects;

public class YourCategoryPage3 extends AppCompatActivity {
    private EditText distanceEditTextPage3;
    private EditText categoryRunEditTextPage3;
    private EditText resultEditTextPage3;
    private Button findResultButton;
    private TextView categoryTextView;
    private String valDistanceEditTextPage3;
    private String valCategoryRunEditTextPage3;
    private final RankTableManAutoData rankTableManAutoData = new RankTableManAutoData();
    private final RankTableWomanAutoData rankTableWomanAutoData = new RankTableWomanAutoData();
    private String valResultEditTextPage3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_category_page3);
        init();
        onClick();
    }
    private void init(){
        distanceEditTextPage3 = findViewById(R.id.distanceEditTextPage3);
        categoryRunEditTextPage3 = findViewById(R.id.categoryRunEditTextPage3);
        resultEditTextPage3 = findViewById(R.id.resultEditTextPage3);
        findResultButton = findViewById(R.id.findResultButton);
        categoryTextView = findViewById(R.id.categoryTextView);
    }
    public void onClick(){
        findResultButton.setOnClickListener(v -> {
            valDistanceEditTextPage3 = distanceEditTextPage3.getText().toString();
            valCategoryRunEditTextPage3 = categoryRunEditTextPage3.getText().toString();
            valResultEditTextPage3 = resultEditTextPage3.getText().toString();

            categoryTextView.setText(getCategory().toString());
        });
    }
    private int getFirstIndex(){
        int index1 = 0;
        if(Objects.equals(valDistanceEditTextPage3, "60")){
            index1 = 0;

        }
        else if(Objects.equals(valDistanceEditTextPage3, "100")){
            index1 = 1;
        }
        else if(Objects.equals(valDistanceEditTextPage3, "200")){
            index1 = 2;
        }
        else if(Objects.equals(valDistanceEditTextPage3, "200 200")){
            index1 = 3;
        }
        else if(Objects.equals(valDistanceEditTextPage3, "300")){
            index1 = 4;
        }
        else if(Objects.equals(valDistanceEditTextPage3, "400 400")){
            index1 = 5;
        }
        else if(Objects.equals(valDistanceEditTextPage3, "400 200")){
            index1 = 6;
        }
        else if(Objects.equals(valDistanceEditTextPage3, "600 400")){
            index1 = 7;
        }
        else if(Objects.equals(valDistanceEditTextPage3, "600 200")){
            index1 = 8;
        }
        else if(Objects.equals(valDistanceEditTextPage3, "800 400")){
            index1 = 9;
        }
        else if(Objects.equals(valDistanceEditTextPage3, "800 200")){
            index1 = 10;
        }
        else if(Objects.equals(valDistanceEditTextPage3, "1000 400")){
            index1 = 11;
        }
        else if(Objects.equals(valDistanceEditTextPage3, "1000 200")){
            index1 = 12;
        }
        else if(Objects.equals(valDistanceEditTextPage3, "1500 400")){
            index1 = 13;
        }
        else if(Objects.equals(valDistanceEditTextPage3, "1500 200")){
            index1 = 14;
        }
        else if(Objects.equals(valDistanceEditTextPage3, "1 мил")){
            index1 = 15;
        }
        else if(Objects.equals(valDistanceEditTextPage3, "3000 400")){
            index1 = 16;
        }
        else if(Objects.equals(valDistanceEditTextPage3, "3000 200")){
            index1 = 17;
        }
        else if(Objects.equals(valDistanceEditTextPage3, "5000")){
            index1 = 18;
        }
        else if(Objects.equals(valDistanceEditTextPage3, "10000")){
            index1 = 19;
        }
        if(index1 == 0 && !Objects.equals(valDistanceEditTextPage3, "60")){
            return 69;
        }
        else{
            return index1;
        }
    }
    private int getCategoryNum(){
        int i = 0;
        int j = getFirstIndex();

        if(Objects.equals(valCategoryRunEditTextPage3, "Man auto")){
            for(i = 0; i < rankTableManAutoData.getRankTableManAuto().length; ){
                if(Double.parseDouble(valResultEditTextPage3) > rankTableManAutoData.getRankTableManAuto()[j][i]){
                    i++;
                }
                else{
                    break;
                }
            }
        }
        else if(Objects.equals(valCategoryRunEditTextPage3, "Woman auto")){
            for(i = 0; i < rankTableWomanAutoData.getRankTableWomanAuto().length; ){
                if(Double.parseDouble(valResultEditTextPage3) > rankTableWomanAutoData.getRankTableWomanAuto()[j][i]){
                    i++;
                }
                else{
                    break;
                }
            }
        }else{
            i = 68;
        }
        return i+1;
    }
    private String getCategory(){
        String valCategory = null;
        if(getCategoryNum() == 1){
            valCategory ="MSMK";
        }
        else if(getCategoryNum() == 2){
            valCategory ="MS";
        }
        else if(getCategoryNum() == 3){
            valCategory ="KMS";
        }
        else if(getCategoryNum() == 4){
            valCategory ="I";
        }
        else if(getCategoryNum() == 5){
            valCategory ="II";
        }
        else if(getCategoryNum() == 6){
            valCategory ="III";
        }
        else if(getCategoryNum() == 7){
            valCategory ="I(y)";
        }
        else if(getCategoryNum() == 8){
            valCategory ="II(y)";
        }
        else if(getCategoryNum() == 9){
            valCategory ="III(y)";
        }else if(getCategoryNum() == 69){
            valCategory ="Неправильные данные";
        }
        return valCategory;
    }
}