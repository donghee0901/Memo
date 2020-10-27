package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MemoViewActivity extends AppCompatActivity {
    MemoDatabase db;

    Button back;
    Button modify_button;
    Button delete_button;

    EditText viewTitle;
    EditText viewContent;

    String title;
    String content;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_view);

        db  = MemoDatabase.getInstance(getApplicationContext());

        Intent i = getIntent();

        back = findViewById(R.id.back);
        modify_button = findViewById(R.id.modify_button);
        delete_button = findViewById(R.id.delete_button);
        viewTitle = findViewById(R.id.view_title);
        viewContent = findViewById(R.id.view_content);

        title = i.getExtras().getString("title");
        content = i.getExtras().getString("content");
        id = Integer.parseInt(i.getExtras().getString("id"));
        if(title != null && content != null)
        {
            viewTitle.setText(title);
            viewContent.setText(content);
        }


        modify_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(() -> {
                    MemoEntity test = new MemoEntity();
                    test.id = id;
                    test.title = viewTitle.getText().toString();
                    test.content = viewContent.getText().toString();
                    db.memoDao().update(test);
                    Intent i = new Intent(getApplicationContext(), MainActivity.class); //새로운 액티비티로 넘어가기 위한 변수
                    startActivity(i); //새 액티비티 띄우기
                    finishAffinity();
                }).start();
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(() -> {
                    MemoEntity test = new MemoEntity();
                    test.id = id;
                    test.title = title;
                    test.content = content;
                    db.memoDao().delete(test);
                    Intent i = new Intent(getApplicationContext(), MainActivity.class); //새로운 액티비티로 넘어가기 위한 변수
                    startActivity(i); //새 액티비티 띄우기
                    finishAffinity();
                }).start();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class); //새로운 액티비티로 넘어가기 위한 변수
                startActivity(i); //새 액티비티 띄우기
                finishAffinity();
            }
        });
    }
}