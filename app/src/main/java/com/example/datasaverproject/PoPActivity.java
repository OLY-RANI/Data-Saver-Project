package com.example.datasaverproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datasaverproject.model.Mymodel;

public class PoPActivity extends AppCompatActivity {
TextView passSave;
EditText passEdit;
SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_po_p);
        init();


        sp=getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);


        passSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*String PassSave=passSave.getText().toString();*/
                String PassEdit=passEdit.getText().toString();

                SharedPreferences.Editor editor = sp.edit();
                editor.putString("PoPassword",PassEdit);

                editor.commit();

                Toast.makeText(PoPActivity.this, "Successfully saved", Toast.LENGTH_SHORT).show();
                //Mymodel.pass=EditText;
                Intent intent=new Intent(PoPActivity.this,HomeActivity.class);
                startActivity(intent);


                /*if (TextUtils.isEmpty(EditText)){
                    editText.setError("required");
                }

                else {
                    Mymodel.pass=EditText;
                    Intent intent=new Intent(PoPActivity.this,HomeActivity.class);
                    startActivity(intent);

                }*/

//                if(TextUtils.isEmpty(PassSave)){
//                    Toast.makeText(PoPActivity.this, "Required", Toast.LENGTH_SHORT).show();
//                }else{
//                    if(PassSave.equals(12345)){
//                        SharedPreferences sharedPreferences=getSharedPreferences("PREf",MODE_PRIVATE);
//                        SharedPreferences.Editor editor=sharedPreferences.edit();
//                        editor.putBoolean("isValidate",true);
//                        editor.apply();
//                    }

//                }
                /*Intent intent=new Intent(PoPActivity.this,HomeActivity.class);
                startActivity(intent);*/
            }
        });
    }

    private void init() {
        passSave=findViewById(R.id.passSave);
        passEdit=findViewById(R.id.editText);
    }
}