package com.example.orderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void StockAdd(View v){
        TextView AddStock = (TextView) findViewById(R.id.add_stock);
        AddStock.setText("Please enter a value.");

        EditText EditStock = (EditText) findViewById(R.id.stock_value);
        if(!EditStock.getText().toString().isEmpty()){
            Double Stock = Double.valueOf(EditStock.getText().toString());
            AddStock.setText("The available stock is : " + Stock.toString());
        }

    }


}