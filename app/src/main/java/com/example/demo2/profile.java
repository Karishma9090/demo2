package com.example.demo2;

import android.content.Intent;
import android.os.Bundle;
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

public class profile extends AppCompatActivity {
    private EditText fullnametext,email;
    private Button updatebutton,backbutton;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    class2info class2info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        fullnametext=findViewById(R.id.nametext);
        email=findViewById(R.id.emailid);
        updatebutton=findViewById(R.id.update);
        backbutton=findViewById(R.id.Bbtn);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("clientInfo");
        class2info= new class2info();



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profile.this, signup.class));
            }
        });

        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (fullnametext.getText().toString().equals("")){
                    fullnametext.setError("enter your full name");
                } else if (email.getText().toString().equals("")) {
                    email.setError("enter your emailid");


                }
                else {
                    Toast.makeText(getApplicationContext(),"All text Filds are correcct",Toast.LENGTH_LONG).show();

                    String name=fullnametext.getText().toString();
                    String emailid=email.getText().toString();
                    addDatafirebase(name,emailid);




                }
            }
        });
    }

    private void addDatafirebase(String name,String emailid){
        class2info.setEname(name);
        class2info.setEemail(emailid);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.setValue(class2info);
                Toast.makeText(profile.this, "data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(profile.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();

            }
        });
        startActivity(new Intent(profile.this, MainActivity6.class));
//        backbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(profile.this, MainActivity6.class));
            //}
       // });
    }
}