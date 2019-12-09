package com.example.android.task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {



    Context context;
    ArrayList<User> users;
    public MyAdapter(Context c, ArrayList<User> u)
    {
        context = c;
        users = u;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(users.get(position).getName());
        holder.email.setText(users.get(position).getEmail());
        holder.branch.setText(users.get(position).getBranch());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        EditText name,email,branch;

        public MyViewHolder(View itemView){
            super(itemView);
            name = (EditText) itemView.findViewById(R.id.Name);
            email = (EditText) itemView.findViewById(R.id.Email);
            branch = (EditText) itemView.findViewById(R.id.Branch);
        }

    }

}
