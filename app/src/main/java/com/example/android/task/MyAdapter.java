package com.example.android.task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {



    private Context context;
    private ArrayList<User> users;
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
        holder.enrollment.setText(users.get(position).getEnrollment());
        holder.branch.setText(users.get(position).getBranch());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,enrollment,branch;

        public MyViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.Name);
            enrollment =  itemView.findViewById(R.id.Enrollment_no);
            branch =  itemView.findViewById(R.id.Branch);
        }

    }

}
