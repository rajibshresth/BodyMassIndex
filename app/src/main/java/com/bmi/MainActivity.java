package com.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etheight, etweight, etbmi;
    Button calculate;
    Double height, weight, bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate = findViewById(R.id.btnBMI);
        etbmi = findViewById(R.id.etBMI);
        etheight = findViewById(R.id.etheight);
        etweight = findViewById(R.id.etweight);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height = Double.parseDouble(etheight.getText().toString())/100;
                weight = Double.parseDouble(etweight.getText().toString());

                bmi = weight / (height * height) ;
                etbmi.setText(bmi.toString());

                if(bmi < 18.5) {

                    Toast.makeText(MainActivity.this,
                            "You are under weight : " + bmi.toString(),
                            Toast.LENGTH_LONG).show();
                }
                if(bmi > 18.5 && bmi < 24.9) {

                    Toast.makeText(MainActivity.this,
                            "You are weight is average : " + bmi.toString(),
                            Toast.LENGTH_LONG).show();
                }
                if(bmi > 25 && bmi < 29.9 ) {

                    Toast.makeText(MainActivity.this,
                            "You are over weight : " + bmi.toString(),
                            Toast.LENGTH_LONG).show();
                }
                if(bmi > 30) {

                    Toast.makeText(MainActivity.this,
                            "You are obsesive : " + bmi.toString(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}