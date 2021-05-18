package com.example.programminglangquiz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Animation topAnimation;
    View first ,second,third,fourth,fifth,sixth,seventh;
    TextView java,python,textView;
    ImageView brain;
    CharSequence charSequence;
    int index;
    long delay=200;
    Handler handler=new Handler();
    ObjectAnimator objectAnimator;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topAnimation=AnimationUtils.loadAnimation(this,R.anim.top);

        java=findViewById(R.id.java);
        python=findViewById(R.id.python);
        brain=findViewById(R.id.brain);
        textView=findViewById(R.id.text_view);
        first=findViewById(R.id.first_line);
        second=findViewById(R.id.second_line);
        third=findViewById(R.id.third_line);
        fourth=findViewById(R.id.fourth_line);
        fifth=findViewById(R.id.fifth_line);
        sixth=findViewById(R.id.sixth_line);
        seventh=findViewById(R.id.seventh_line);

        first.setAnimation(topAnimation);
        second.setAnimation(topAnimation);
        third.setAnimation(topAnimation);
        fourth.setAnimation(topAnimation);
        fifth.setAnimation(topAnimation);
        sixth.setAnimation(topAnimation);
        seventh.setAnimation(topAnimation);
        objectAnimator=ObjectAnimator.ofPropertyValuesHolder(
                brain,
                PropertyValuesHolder.ofFloat("scaleX",1.2f),
                PropertyValuesHolder.ofFloat("scaleY",1.2f)
        );
        //Set Animation
        objectAnimator.setDuration(1000);
        //set Repeat
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        //set Repeat mode
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        //Start animation
        objectAnimator.start();
        animateText("Quizeee");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,StartActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);

    }
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            textView.setText(charSequence.subSequence(0,index++));
            if(index<=charSequence.length()){
                //when index is equal to text length
                //Run handler
                handler.postDelayed(runnable,delay);
            }
        }
    };
    public void animateText(CharSequence cs){
        charSequence=cs;
        index=0;
        textView.setText("");
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable,delay);
    }
}