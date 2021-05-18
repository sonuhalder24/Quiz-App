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

import com.airbnb.lottie.LottieAnimationView;

public class PythonActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_python);

        relativeLayout=findViewById(R.id.relayLayout);
        btnQues=findViewById(R.id.btn_question);
        btnNext=findViewById(R.id.btn_next);
        score=findViewById(R.id.score);
        sad_lottie=findViewById(R.id.sad_lottie);
        happy_lottie=findViewById(R.id.happy_lottie);
        sad_lottie.setVisibility(View.GONE);
        happy_lottie.setVisibility(View.GONE);

        song1= MediaPlayer.create(PythonActivity.this,R.raw.python1_voice);
        song2= MediaPlayer.create(PythonActivity.this,R.raw.python2_voice);
        song3= MediaPlayer.create(PythonActivity.this,R.raw.python3_voice);
        song4= MediaPlayer.create(PythonActivity.this,R.raw.python4_voice);
        song5= MediaPlayer.create(PythonActivity.this,R.raw.python5_voice);
        song6= MediaPlayer.create(PythonActivity.this,R.raw.python6_voice);
        song7= MediaPlayer.create(PythonActivity.this,R.raw.python7_voice);
        song8= MediaPlayer.create(PythonActivity.this,R.raw.python8_voice);
        song9= MediaPlayer.create(PythonActivity.this,R.raw.python9_voice);
        song10= MediaPlayer.create(PythonActivity.this,R.raw.python10_voice);

        btnQues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mbuilder=new AlertDialog.Builder(PythonActivity.this);
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
                    btnQues.setText("QUESTION " + String.valueOf(next + 1));
                    relativeLayout.setBackground(getResources().getDrawable(R.drawable.javaactivity_back));

                    happy_lottie.setVisibility(View.GONE);
                    sad_lottie.setVisibility(View.GONE);
                }
                else if(next==9){
                    Intent intent=new Intent(PythonActivity.this,ScoreActivity.class);
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
            s="Python was created by -";
        }
        else if(next==1){
            s="Python source code is also available under which license?";
        }
        else if(next==2){
            s="Which of the one is an invalid python environment variable?";
        }
        else if(next==3){
            s="What is PYTHONHOME?";
        }
        else if(next==4){
            s="What is PYTHONSTARTUP?";
        }
        else if(next==5){
            s="What is the use of -d command line option?";
        }
        else if(next==6){
            s="What is the extension of Python files?";
        }
        else if(next==7){
            s="What is the maximum possible length of an identifier?";
        }
        else if(next==8){
            s="All keywords in Python are in -";
        }
        else if(next==9){
            s="Python keywords can be used as -";
        }

        return s;
    }
    private String[] alertOption(int next){
        String[]list=new String[4];
        if(next==0){
            list[0]="Rasmus Lerdorf";
            list[1]="Guido van Rossum";
            list[2]="Larry Wall";
            list[3]="Brendan Eich";
        }
        else if(next==1){
            list[0]="GPL";
            list[1]="EPL";
            list[2]="Apache";
            list[3]="MIT";
        }
        else if(next==2){
            list[0]="PYTHONPATH";
            list[1]="PYTHONSTARTUP";
            list[2]="PYTHONCASEOK";
            list[3]="PYTHONLIBRARY";
        }
        else if(next==3){
            list[0]="It is an alternative module search path";
            list[1]="It contains the path of an initialization file containing Python source code";
            list[2]="It is used in Windows to instruct Python to find the first case-insensitive match in an import statement";
            list[3]="None of the above";
        }
        else if(next==4){
            list[0]="It is executed every time you start the compiler";
            list[1]="It is executed every time you start the interpreter";
            list[2]="It is needed while booting of a particular process";
            list[3]="None of the above";
        }
        else if(next==5){
            list[0]="It provides debug input";
            list[1]="It provides debug output";
            list[2]="It generates optimized bytecode";
            list[3]="None of the above";
        }
        else if(next==6){
            list[0]=".pt";
            list[1]=".py";
            list[2]=".pm";
            list[3]=".class";
        }
        else if(next==7){
            list[0]="20 characters";
            list[1]="30 characters";
            list[2]="50 characters";
            list[3]="None of the above";
        }
        else if(next==8){
            list[0]="Lowercase";
            list[1]="Uppercase";
            list[2]="Alphanumeric";
            list[3]="None of the above";
        }
        else if(next==9){
            list[0]="Constant";
            list[1]="Variable";
            list[2]="Identifier";
            list[3]="None of the above";
        }
        return  list;
    }
    private int alertAnswer(int next){
        int val=-1;
        if(next==0){
            val=1;
        }
        else if(next==1){
            val=0;
        }
        else if(next==2){
            val=3;
        }
        else if(next==3){
            val=0;
        }
        else if(next==4){
            val=1;
        }
        else if(next==5){
            val=1;
        }
        else if(next==6){
            val=1;
        }
        else if(next==7){
            val=3;
        }
        else if(next==8){
            val=0;
        }
        else if(next==9){
            val=3;
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