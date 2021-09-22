package com.example.dbsession;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText Name,Email,Phone,Password;
    Button btnLogin;
    SQLIteHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new SQLIteHelper(this);

        Name= findViewById(R.id.edName);
        Email= findViewById(R.id.edEmail);
        Phone= findViewById(R.id.edPhone);
        Password = findViewById(R.id.edPassword);

        btnLogin= findViewById((R.id.btnlogin));

        createUser();


    }
    public void createUser(){
        btnLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = myDB.insertData(Name.getText().toString(),Email.getText().toString(),Phone.getText().toString(),Password.getText().toString());
                        if (isInserted)
                            Toast.makeText(MainActivity.this,"Registered succefully", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Marks is not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}
