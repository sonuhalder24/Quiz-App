package com.example.programminglangquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class JavaActivity extends AppCompatActivity {
    MediaPlayer song1,song2,song3,song4,song5,song6,song7,song8,song9,song10;
    Button btnQues,btnNext;
    int next=0;
    int sum=0;
    int position;
    TextView score;
    LottieAnimationView sad_lottie,happy_lottie;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_java);

        relativeLayout=findViewById(R.id.relayLayout);
        btnQues=findViewById(R.id.btn_question);
        btnNext=findViewById(R.id.btn_next);
        score=findViewById(R.id.score);
        sad_lottie=findViewById(R.id.sad_lottie);
        happy_lottie=findViewById(R.id.happy_lottie);
        sad_lottie.setVisibility(View.GONE);
        happy_lottie.setVisibility(View.GONE);

        song1= MediaPlayer.create(JavaActivity.this,R.raw.java1_voice);
        song2= MediaPlayer.create(JavaActivity.this,R.raw.java2_voice);
        song3= MediaPlayer.create(JavaActivity.this,R.raw.java3_voice);
        song4= MediaPlayer.create(JavaActivity.this,R.raw.java4_voice);
        song5= MediaPlayer.create(JavaActivity.this,R.raw.java5_voice);
        song6= MediaPlayer.create(JavaActivity.this,R.raw.java6_voice);
        song7= MediaPlayer.create(JavaActivity.this,R.raw.java7_voice);
        song8= MediaPlayer.create(JavaActivity.this,R.raw.java8_voice);
        song9= MediaPlayer.create(JavaActivity.this,R.raw.java9_voice);
        song10= MediaPlayer.create(JavaActivity.this,R.raw.java10_voice);

        btnQues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mbuilder=new AlertDialog.Builder(JavaActivity.this);
                String[]list=alertOption(next);
                mbuilder.setTitle(alertTitle(next));
                mbuilder.setSingleChoiceItems(list, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        position=which;

                    }
                })
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(position==alertAnswer(next)){
                                    sum++;
                                    score.setText("Your score : "+String.valueOf(sum));
                                    relativeLayout.setBackgroundColor(Color.GREEN);
                                    happy_lottie.setVisibility(View.VISIBLE);
                                }
                                else{
                                    relativeLayout.setBackgroundColor(Color.RED);
                                    sad_lottie.setVisibility(View.VISIBLE);
                                    voice_correction(next);
                                }
                                btnQues.setEnabled(false);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog mDialog=mbuilder.create();
                mDialog.show();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(song1.isPlaying()){
                    song1.pause();
                }
                if(song2.isPlaying()){
                    song2.pause();
                }
                if(song3.isPlaying()){
                    song3.pause();
                }
                if(song4.isPlaying()){
                    song4.pause();
                }
                if(song5.isPlaying()){
                    song5.pause();
                }
                if(song6.isPlaying()){
                    song6.pause();
                }
                if(song7.isPlaying()){
                    song7.pause();
                }
                if(song8.isPlaying()){
                    song8.pause();
                }
                if(song9.isPlaying()){
                    song9.pause();
                }
                if(song10.isPlaying()){
                    song10.pause();
                }


                if(next<9) {
                    btnQues.setEnabled(true);
                    next++;
                    btnQues.setText("QUESTION " +(next + 1));
                    relativeLayout.setBackground(getResources().getDrawable(R.drawable.javaactivity_back));

                    happy_lottie.setVisibility(View.GONE);
                    sad_lottie.setVisibility(View.GONE);
                }
                else if(next==9){
                    Intent intent=new Intent(JavaActivity.this,ScoreActivity.class);
                    intent.putExtra("sum",sum);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }



    private String alertTitle(int next) {
        String s="";
        if(next==0){
          s="Which of the following is legal identifier in java?";
        }
        else if(next==1){
            s="Which is the legal range of values for a short ?";
        }
        else if(next==2){
            s="Which operator will always evaluate all the Operands?";
        }
        else if(next==3){
            s="super keyword in Java is used for?";
        }
        else if(next==4){
            s="Which operator is used to check object-type at runtime?";
        }
        else if(next==5){
            s="Argument passed to a program at the run time is stored in _";
        }
        else if(next==6){
            s="Multiple inheritance is not supported in Java because?";
        }
        else if(next==7){
            s="What is an immutable object?";
        }
        else if(next==8){
            s="Which of the following is not a valid way to create String object?";
        }
        else if(next==9){
            s="String objects are stored in a special memory area known as?";
        }

        return s;
    }
    private String[] alertOption(int next){
        String[]list=new String[4];
        if(next==0){
            list[0]="2variable";
            list[1]="#myvar";
            list[2]="+@$var";
            list[3]="$_myvar";
        }
        else if(next==1){
            list[0]="-128 to 127";
            list[1]="-256 to 255";
            list[2]="-32768 to 32767";
            list[3]="0 to 65535";
        }
        else if(next==2){
            list[0]="||";
            list[1]="&&";
            list[2]="?:";
            list[3]="%";
        }
        else if(next==3){
            list[0]="to refer to immediate child class of a class.";
            list[1]="to refer to immediate parent class of a class.";
            list[2]=" to refer to current class object.";
            list[3]="to refer to static member of parent class.";
        }
        else if(next==4){
            list[0]="ternary operator";
            list[1]="instanceof operator";
            list[2]="type operator";
            list[3]="length operator";
        }
        else if(next==5){
            list[0]="String array passed to the parameter of main() method.";
            list[1]="Integer array passed to the parameter of main() method.";
            list[2]="Object array passed to the parameter of main() method.";
            list[3]="String array passed to the parameter of public class constructor.";
        }
        else if(next==6){
            list[0]="To remove ambiguity and provide more maintainable and clear design.";
            list[1]="Java is a Object oriented language.";
            list[2]="Multiple inheritance is not an important feature.";
            list[3]="All of above";
        }
        else if(next==7){
            list[0]="an object whose state can be changed after it is created.";
            list[1]="an object whose state cannot be changed after it is created.";
            list[2]="an object which cannot be casted to another type.";
            list[3]="an object which cannot be cloned.";
        }
        else if(next==8){
            list[0]="String str2 = new String(new char[]{'a','b','c'});";
            list[1]="String str = new String(\"abc\");";
            list[2]="String str1 = \"abc\";";
            list[3]="String str3 = 'a'+'b'+'c';";
        }
        else if(next==9){
            list[0]="Heap";
            list[1]="Stack";
            list[2]="String Constant Pool";
            list[3]="Method Area";
        }
        return  list;
    }
    private int alertAnswer(int next){
        int val=-1;
        if(next==0){
            val=3;
        }
        else if(next==1){
            val=2;
        }
        else if(next==2){
            val=3;
        }
        else if(next==3){
            val=1;
        }
        else if(next==4){
            val=1;
        }
        else if(next==5){
            val=0;
        }
        else if(next==6){
            val=0;
        }
        else if(next==7){
            val=1;
        }
        else if(next==8){
            val=3;
        }
        else if(next==9){
            val=2;
        }
        return val;
    }
    private void voice_correction(int next) {
        if(next==0){
            song1.start();
        }
        else if(next==1){
            song2.start();
        }
        else if(next==2){
            song3.start();
        }
        else if(next==3){
            song4.start();
        }
        else if(next==4){
            song5.start();
        }
        else if(next==5){
            song6.start();
        }
        else if(next==6){
            song7.start();
        }
        else if(next==7){
            song8.start();
        }
        else if(next==8){
            song9.start();
        }
        else if(next==9){
            song10.start();
        }

    }

}