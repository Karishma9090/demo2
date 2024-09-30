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

public class MainActivity6 extends AppCompatActivity {
    private EditText emailidtext, passwordtext;
    private Button joinbutton,backbtn;
    FirebaseDatabase firebasedatabase;
    DatabaseReference databaseReference;
    class4info class4info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main6);

        emailidtext=findViewById(R.id.Etext);
        passwordtext=findViewById(R.id.ptext);
        joinbutton=findViewById(R.id.bnum);
        backbtn=findViewById(R.id.bnum2);
        firebasedatabase=firebasedatabase.getInstance();
        databaseReference=firebasedatabase.getReference("datainfo");
        class4info=new class4info();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (emailidtext.getText().toString().equals("")) {
                emailidtext.setError("enter your emailid");
                } else if (passwordtext.getText().toString().equals("")) {
                    passwordtext.setError("enter your correct password");
                }
                else {
                    Toast.makeText(getApplicationContext(), "All text Filds are correcct", Toast.LENGTH_LONG).show();
                }
                String emailid=emailidtext.getText().toString();
                String password=passwordtext.getText().toString();
                addDatafirebase(emailid,password);

                startActivity(new Intent(MainActivity6.this, profile.class));

        });
    }
    }
    private void addDatafirebase(String name,String emailid) {
        class4info.setemail(emailid);
        class4info.setpassword();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.setValue(class4info);
                Toast.makeText(MainActivity6.this, "data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity6.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();

            }
        });
        startActivity(new Intent(profile.this, MainActivity6.class));
    }
}