package com.example.datasaverproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.datasaverproject.model.MyWork;

public class DisplayActivity extends AppCompatActivity {
EditText disMoP,disServer;
Button see;
MyWork myWork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        init();
        setData();

        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DisplayActivity.this,CheakPoPActivity.class));
            }
        });
    }

    private void setData() {
        disMoP.setText(myWork.getEmailPhn());
        disServer.setText(myWork.getServer());
    }

    private void init() {

        disMoP=findViewById(R.id.diPhnEmail);
        disServer=findViewById(R.id.DisServer);
        see=findViewById(R.id.seePop);
        myWork= (MyWork) getIntent().getSerializableExtra("MODEL");
    }
}