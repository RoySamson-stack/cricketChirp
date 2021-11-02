package com.example.cricketchirp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etChirps;
    Button btnCalc;
    TextView tvResult;
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etChirps = findViewById(R.id.etChirps);
        btnCalc = findViewById(R.id.btnCalc);
        tvResult = findViewById(R.id.tvResult);

        tvResult.setVisibility(View.GONE);
        formatter = new DecimalFormat("#0.0");

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if (etChirps.getText().toString().isEmpty()){
                  Toast.makeText(MainActivity.this,  "Please fill al fields", Toast.LENGTH_SHORT).show();
              }else{
                  int chirps = Integer.parseInt(etChirps.getText().toString().trim());

                  double temp =( chirps /3.0) + 4;

                  String results = "The approximate temperature outside is " + formatter.format(temp) + "degrees celsius.";

                  tvResult.setText(results);

                  tvResult.setVisibility(View.VISIBLE);
              }
            }
        });
    }
}