package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView test = new TextView(this);
        ConstraintLayout mainLayout = findViewById(R.id.mainView);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            test.setText("abc");
            test.setTextSize(100);
            setContentView(test);
//            mainLayout.addView(test);
            test.setText("test");
        }
        catch (Exception e)
        {
            Log.e("error", e.toString());
        }
    }
}
