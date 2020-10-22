package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMemoActivity extends AppCompatActivity {

    Button back;
    Button submit;

    MemoDatabase db;

    EditText addTitle;
    EditText addContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_memo);

        back = findViewById(R.id.back);
        submit = findViewById(R.id.add_button);
        addTitle = findViewById(R.id.add_title);
        addContent = findViewById(R.id.add_content);

        db  = Room.databaseBuilder(getApplicationContext(), MemoDatabase.class, "database-name").build();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class); //새로운 액티비티로 넘어가기 위한 변수
                startActivity(i); //새 액티비티 띄우기
                finishAffinity();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(addTitle.getText() == null || addContent.getText() == null || addTitle.getText().toString().equals("") || addContent.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"빈 값을 저장할 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    new Thread(() -> {
                        MemoEntity test = new MemoEntity();
                        test.id = db.memoDao().getCount();
                        test.title = addTitle.getText().toString();
                        test.content = addContent.getText().toString();
                        db.memoDao().insert(test);
                    }).start();

                    Intent i = new Intent(getApplicationContext(), MainActivity.class); //새로운 액티비티로 넘어가기 위한 변수
                    startActivity(i); //새 액티비티 띄우기
                    finishAffinity();
                }
            }
        });
    }
}