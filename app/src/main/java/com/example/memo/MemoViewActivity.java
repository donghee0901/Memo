package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MemoViewActivity extends AppCompatActivity {
    MemoDatabase db;
    Button modify_button;

    EditText viewTitle;
    EditText viewContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_view);

        db  = Room.databaseBuilder(getApplicationContext(), MemoDatabase.class, "database-name").build();


        modify_button = findViewById(R.id.modify_button);
        viewTitle = findViewById(R.id.add_title);
        viewContent = findViewById(R.id.add_content);


        modify_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(() -> {
                    MemoEntity test = new MemoEntity();
                    test.id = db.memoDao().getCount();
                    test.title = viewTitle.getText().toString();
                    test.content = viewContent.getText().toString();
                    db.memoDao().insert(test);
                    Intent i = new Intent(getApplicationContext(), MainActivity.class); //새로운 액티비티로 넘어가기 위한 변수
                    startActivity(i); //새 액티비티 띄우기
                    finishAffinity();
                }).start();
            }
        });
    }
}