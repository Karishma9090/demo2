package com.example.demo2;

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
EditText fno;
EditText sno;
Button v1;
TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        fno=findViewById(R.id.firstno);
        sno=findViewById(R.id.secondno);
        v1=findViewById(R.id.buttonsum);
        t1=findViewById(R.id.result);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int no1=Integer.parseInt(fno.getText().toString());
                int no2=Integer.parseInt(sno.getText().toString());
                int result=no1+no2;
                t1.setText(result);
                t1.setVisibility(View.VISIBLE);
            }
        });
    }
}