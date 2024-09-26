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

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class signup extends AppCompatActivity {

    private EditText nametext,lname,Eid,phnumber,pw;
    private Button signup1;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuthException firebaseAuthException;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        nametext=findViewById(R.id.name);
        lname=findViewById(R.id.lastname);
        Eid=findViewById(R.id.email);
        phnumber=findViewById(R.id.phno);
        pw=findViewById(R.id.Password);

        signup1=findViewById(R.id.sup);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nametext.getText().toString().equals(""))
                {
                    nametext.setError("Enter Your Name");
                }
                else if(lname.getText().toString().equals(""))
                {
                   lname.setError("enter your lastname");
                } else if (phnumber.getText().toString().equals("")) {
                    phnumber.setError("enter your phnnumber");

                } else if (Eid.getText().toString().equals("")) {
                    Eid.setError("enter your emailid");

                } else if (pw.getText().toString().equals("")) {
                    pw.setError("enter your password");

                } else {
                    Toast.makeText(getApplicationContext(),"All text Filds are correcct",Toast.LENGTH_LONG).show();



                }

            }
        });




    }
    public  void datasend()
    {




    }
}