package com.example.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {
    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private Button buttonAdd,next;
    private TextView textViewResult;
    private Button joinbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        editTextNumber1 = findViewById(R.id.firstnumber);
        editTextNumber2 = findViewById(R.id.secondnumber);
        buttonAdd = findViewById(R.id.submitbtn);
        textViewResult=findViewById(R.id.resultstxtview);
        joinbutton=findViewById(R.id.joinbtn);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int no1=Integer.parseInt(editTextNumber1.getText().toString());
                int no2=Integer.parseInt(editTextNumber2.getText().toString());
                int result=no1+no2;
                textViewResult.setText("Result: " + result);
                textViewResult.getVisibility();
            }
        });
        joinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity4.this, signup.class));
            }
        });
    }
}