package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button addMemo;
    MemoDatabase db;
    List<MemoEntity> MemoData;
    MemoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db  = Room.databaseBuilder(getApplicationContext(), MemoDatabase.class, "database-name").build();


//        new Thread(() ->{
//            db.memoDao().deleteAll();
//        }).start();

        new Thread(() -> {
            MemoData = db.memoDao().getMemoAll();
            RecyclerView memo = findViewById(R.id.MemoRecyclerView);
            adapter = new MemoAdapter(MemoData); //어댑터 만들면서 데이터 리스트 넘기기
            memo.setAdapter(adapter); //리사이클러뷰에 어댑터 연결
            memo.setLayoutManager(new LinearLayoutManager(this)); //데이터 정렬방식 (LinearLayoutManager : 세로정렬)
        }).start();


        addMemo = findViewById(R.id.addMemo);
        addMemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.notifyDataSetChanged(); // adapter 새로고침
                Intent i = new Intent(getApplicationContext(), AddMemoActivity.class); //새로운 액티비티로 넘어가기 위한 변수
                startActivity(i); //새 액티비티 띄우기
            }
        });


//        Toast.makeText(this, "ssdfsdfds", Toast.LENGTH_SHORT).show();
//        new Thread(() -> {
//            Toast.makeText(this, "ssdfsdfds", Toast.LENGTH_SHORT).show();
//            MemoData = db.memoDao().getMemoAll();
//            adapter.notifyDataSetChanged(); // adapter 새로고침
//        }).start();

    }
}
