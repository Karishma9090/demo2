package com.example.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class signup extends AppCompatActivity {

    private EditText nametext,lname,Eid,phnumber,pw;
    private Button signup1,logn;
    classinfo classinfo;


    FirebaseDatabase firebaseDatabase;
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
        logn=findViewById(R.id.log);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("EmployeeInfo");
        classinfo = new classinfo();

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

                    String name = nametext.getText().toString();
                    String phone = phnumber.getText().toString();
                    String lname1 = lname.getText().toString();
                    String email1 = Eid.getText().toString();
                    String epswd1 = pw.getText().toString();


                    addDatatoFirebase(name, phone, lname1,email1,epswd1);

                }

            }
        });
        logn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signup.this, profile.class));
            }
        });



    }
    private  void addDatatoFirebase(String name, String phone,String lname1,String email1,String epswd1)
    {
        classinfo.setFname(name);
        classinfo.setLname(lname1);
        classinfo.setEemail(email1);
        classinfo.setEphone(phone);
        classinfo.setEpswd(epswd1);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.setValue(classinfo);
                Toast.makeText(signup.this, "data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(signup.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();

            }
        });

    }
}