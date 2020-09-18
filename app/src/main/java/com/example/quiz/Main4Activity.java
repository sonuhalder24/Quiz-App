package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
   TextView textView;
   RatingBar ratingBar;
   Button button,button4;
   boolean ok=false;
    @Override
    public void onBackPressed() {

        Toast.makeText(this, "Please press Close button", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        textView=findViewById(R.id.textView);
        ratingBar=findViewById(R.id.ratingBar);
        button=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        textView.setText("Your Score is "+getIntent().getIntExtra("sum",0));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main4Activity.this, "Your rating is "+String.valueOf(ratingBar.getRating()), Toast.LENGTH_SHORT).show();
                ok=true;
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ok==false){
                    Toast.makeText(Main4Activity.this, "Please Rate the Quiz", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    startActivity(intent);
                }
            }
        });
    }
}
