package com.example.datasaverproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datasaverproject.DisplayActivity;
import com.example.datasaverproject.InsertActivity;
import com.example.datasaverproject.R;
import com.example.datasaverproject.UpdateActivity;
import com.example.datasaverproject.model.MyWork;
import com.example.datasaverproject.model.Mymodel;

import java.util.List;

public class ServerAdapter extends RecyclerView.Adapter<ServerAdapter.ServerViewholder> {

    private List<MyWork> myWorkList;
    private Context context;

    public ServerAdapter(List<MyWork> myWorkList, Context context) {
        this.myWorkList = myWorkList;
        this.context = context;
    }

    @NonNull
    @Override
    public ServerViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.show_design,parent,false);
        ServerViewholder serverViewholder=new ServerViewholder(view);
        return serverViewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ServerViewholder holder, int position) {

        MyWork myWork=myWorkList.get(position);
        holder.demoServer.setText(myWork.getServer());

        int modelId=myWork.getWorkId();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DisplayActivity.class);
                intent.putExtra("MODEL",myWork);
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return myWorkList.size();
    }


    public  class ServerViewholder extends  RecyclerView.ViewHolder{

        TextView demoServer;

        public ServerViewholder(@NonNull View itemView) {
            super(itemView);

            demoServer=itemView.findViewById(R.id.demoServer);
        }
    }
}
