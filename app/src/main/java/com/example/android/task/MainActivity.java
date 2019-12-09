package com.example.android.task;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private DatabaseReference mDatabase;
    private RecyclerView recyclerView;
//    private RecyclerView.LayoutManager layoutManager;
//    private FirebaseRecyclerAdapter<User , > ;
    private ArrayList<User> list;
    private MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = (RecyclerView) findViewById(R.id.myRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<User>();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.rl_container);


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    User u = dataSnapshot1.getValue(User.class);
                    list.add(u);
                }

                adapter = new MyAdapter(MainActivity.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "opss.. Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }





//        public void logout(View view) {
//            FirebaseAuth.getInstance().signOut();
//            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
//            finish();
//    }
}
