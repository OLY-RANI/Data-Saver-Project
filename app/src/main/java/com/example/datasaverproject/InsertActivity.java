package com.example.datasaverproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.datasaverproject.model.AppDatabase;
import com.example.datasaverproject.model.MyWork;

public class InsertActivity extends AppCompatActivity {
EditText phnEmail,password,server;
Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        init();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String PoE= phnEmail.getText().toString();
                String Password= password.getText().toString();
                String Server= server.getText().toString();


                if (TextUtils.isEmpty(PoE)){
                    phnEmail.setError("required");
                }

                else if (TextUtils.isEmpty(Password)){
                    password.setError("required");
                }
                else if (TextUtils.isEmpty(Server)){
                    server.setError("required");
                }
                else{
                    MyWork myWork = new MyWork(PoE,Password,Server);
                    AppDatabase.getInstance(InsertActivity.this).workDAO().InsertWork(myWork);
                    Toast.makeText(InsertActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                }




            }
        });
    }

    private void init() {
        phnEmail=findViewById(R.id.diPhnEmail);
        password=findViewById(R.id.uppassword);
        server=findViewById(R.id.DisServer);
        save=findViewById(R.id.seePop);
    }
}