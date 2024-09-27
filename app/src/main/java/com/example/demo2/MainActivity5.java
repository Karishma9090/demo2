package com.example.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity5 extends AppCompatActivity {
private EditText Uname,numpassword;
private Button logiin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);

        Uname=findViewById(R.id.name);
        numpassword=findViewById(R.id.Password);
        logiin=findViewById(R.id.login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
                logiin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (Uname.getText().toString().equals("")){
                            Uname.setError("enter your Username");
                        } else if (numpassword.getText().toString().equals("")) {
                            numpassword.setError("enter your password");

                        }else {
                            Toast.makeText(getApplicationContext(),"All text Filds are correcct",Toast.LENGTH_LONG).show();

                        }

                    }
                });
    }
}