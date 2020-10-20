package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> data = new ArrayList<String>();
    Button addMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addMemo = findViewById(R.id.addMemo);
        data.add("abc");
        data.add("def");
        data.add("nam");
        data.add("abc");
        data.add("def");
        data.add("nam");
        data.add("abc");
        data.add("def");
        data.add("nam");
        data.add("abc");
        data.add("def");
        data.add("nam");
        data.add("abc");
        data.add("def");
        data.add("nam");
        data.add("abc");
        data.add("def");
        data.add("nam");


        RecyclerView memo = findViewById(R.id.MemoRecyclerView);
        MemoAdapter adapter = new MemoAdapter(data);
        memo.setAdapter(adapter);
        memo.setLayoutManager(new LinearLayoutManager(this));


        addMemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddMemoActivity.class);
                startActivity(i);
            }
        });
    }
}
