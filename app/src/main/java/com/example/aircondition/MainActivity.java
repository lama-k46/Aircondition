package com.example.aircondition;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewStatus, textViewTemperature;
    private Button buttonToggle, buttonIncrease, buttonDecrease;

    private boolean isACOn = false;
    private int temperature = 24; // Default temperature

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewStatus = findViewById(R.id.textViewStatus);
        textViewTemperature = findViewById(R.id.textViewTemperature);
        buttonToggle = findViewById(R.id.buttonToggle);
        buttonIncrease = findViewById(R.id.buttonIncrease);
        buttonDecrease = findViewById(R.id.buttonDecrease);

        buttonToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleAC();
            }
        });

        buttonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseTemperature();
            }
        });

        buttonDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseTemperature();
            }
        });
    }

    private void toggleAC() {
        isACOn = !isACOn;
        textViewStatus.setText("AC Status: " + (isACOn ? "ON" : "OFF"));
        buttonToggle.setText(isACOn ? "Turn OFF" : "Turn ON");
    }

    private void increaseTemperature() {
        if (isACOn && temperature < 30) {
            temperature++;
            textViewTemperature.setText("Temperature: " + temperature + "°C");
        }
    }

    private void decreaseTemperature() {
        if (isACOn && temperature > 16) {
            temperature--;
            textViewTemperature.setText("Temperature: " + temperature + "°C");
        }
    }
}
