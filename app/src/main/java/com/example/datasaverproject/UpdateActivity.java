package com.example.datasaverproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.datasaverproject.model.AppDatabase;
import com.example.datasaverproject.model.MyWork;

public class UpdateActivity extends AppCompatActivity {
EditText upmailPhn,uppass,upserver;
Button update,delete;
MyWork myWork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        init();
        //setData();
        SharedPreferences sp=getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        String CheckPassword=sp.getString("PoPassword","");

        uppass.setText(CheckPassword);
        upmailPhn.setText(myWork.getEmailPhn());
        upserver.setText(myWork.getServer());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String upMoP= upmailPhn.getText().toString();
                String upPass= uppass.getText().toString();
                String upServer= upserver.getText().toString();


                MyWork work = new MyWork(upMoP,upPass,upServer);
                work.setWorkId(myWork.getWorkId());
                AppDatabase.getInstance(UpdateActivity.this).workDAO().UpdateWork(work);
                Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase.getInstance(UpdateActivity.this).workDAO().DeleteWork(myWork);
                Toast.makeText(UpdateActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UpdateActivity.this,HomeActivity.class));
            }
        });
    }

    /*private void setData() {

    }*/

    private void init() {
        upmailPhn=findViewById(R.id.upPhnEmail);
        uppass=findViewById(R.id.uppassword);
        upserver=findViewById(R.id.upServer);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);



        myWork= (MyWork) getIntent().getSerializableExtra("MODEL");
    }
}