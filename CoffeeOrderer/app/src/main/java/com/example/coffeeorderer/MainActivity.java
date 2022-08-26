package com.example.coffeeorderer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public TextView coffee_value, price_value, output_text;
    public Button plus,minus,order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        order = findViewById(R.id.order);
        coffee_value = findViewById(R.id.coffee_value);
        price_value = findViewById(R.id.price_value);
        output_text = findViewById(R.id.output_text);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current_order = Integer.parseInt(coffee_value.getText().toString());
                current_order++;
                coffee_value.setText(Integer.toString(current_order));
                price_value.setText(Integer.toString(current_order*5));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current_order = Integer.parseInt(coffee_value.getText().toString());
                if (current_order>1){
                    current_order--;
                    coffee_value.setText(Integer.toString(current_order));
                    price_value.setText(Integer.toString(current_order*5));
                }
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Show_msg();
            }
        });
    }

    public void Show_msg(){
        String message = "You have ordered : " + coffee_value.getText().toString() + " Coffees.\nand the total price is : " + price_value.getText().toString() + " dollars.";
        output_text.setText(message);
        Toast.makeText(MainActivity.this, "Thanks to Order Coffee", Toast.LENGTH_SHORT).show();
    }
}