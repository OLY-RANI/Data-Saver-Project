package com.example.datasaverproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.datasaverproject.adapter.ServerAdapter;
import com.example.datasaverproject.model.AppDatabase;
import com.example.datasaverproject.model.MyWork;
import com.example.datasaverproject.model.Mymodel;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ImageView add;
    RecyclerView rv;
    ServerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
        GridLayoutManager manager=new GridLayoutManager(this,2);
        rv.setLayoutManager(manager);
        rv.setHasFixedSize(true);

        getWorkList();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "gfdshgcshcj", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(HomeActivity.this,InsertActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getWorkList() {
        List<MyWork> list= AppDatabase.getInstance(this).workDAO().getAllMyWork();
        adapter = new ServerAdapter(list,this);
        rv.setAdapter(adapter);//setting adapter
        adapter.notifyDataSetChanged();
    }

    private void init() {
        add=findViewById(R.id.add);
        rv=findViewById(R.id.RV);
    }
    @Override//android lifecycle
    protected void onStart() {
        super.onStart();
        getWorkList();
    }
}