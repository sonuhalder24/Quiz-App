package com.example.programminglangquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class StartActivity extends AppCompatActivity {
    LinearLayout javaLayout,pythonLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);
        javaLayout=findViewById(R.id.java_linearlayout);
        pythonLayout=findViewById(R.id.python_linearlayout);
        javaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StartActivity.this,JavaActivity.class);
                startActivity(intent);
            }
        });
        pythonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StartActivity.this,PythonActivity.class);
                startActivity(intent);
            }
        });
    }
}