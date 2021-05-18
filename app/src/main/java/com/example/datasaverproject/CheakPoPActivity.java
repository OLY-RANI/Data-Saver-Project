package com.example.datasaverproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datasaverproject.model.Mymodel;

public class CheakPoPActivity extends AppCompatActivity {
TextView chkPop;
EditText chkPass;
//Mymodel mymodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheak_po_p);
        chkPop=findViewById(R.id.see);
        chkPass=findViewById(R.id.edit);
        //mymodel=new Mymodel();
        SharedPreferences sp=getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        String CheckPassword=sp.getString("PoPassword","");

        chkPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(CheakPoPActivity.this, "Password==   "+chkPass, Toast.LENGTH_SHORT).show();

                if(chkPass.getText().toString().equals(CheckPassword)){
                    startActivity(new Intent(CheakPoPActivity.this,UpdateActivity.class));
                }
                else {
                    Toast.makeText(CheakPoPActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}