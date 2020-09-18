package com.example.quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
   MediaPlayer song1,song2;
    Button button,button2;
    int sum;
    int position;
    @Override
    public void onBackPressed() {

        Toast.makeText(this, "Please press Next button", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        song1=MediaPlayer.create(Main2Activity.this,R.raw.right);
        song2=MediaPlayer.create(Main2Activity.this,R.raw.wrong);
        sum=getIntent().getIntExtra("sum",0);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder mbuilder=new AlertDialog.Builder(Main2Activity.this);
                String[]list={"Yashavant Ritchie","Yashavant Kanetkar","Yashavant Thareja","Yashavant Kashurkar"};
                mbuilder.setTitle("Writer of Let Us C -");
                mbuilder.setSingleChoiceItems(list, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        position=which;

                    }
                })
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(position==1){

                                     song1.start();
                                    sum++;
                                }
                                else{

                                    song2.start();
                                }
                                button.setEnabled(false);

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
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song1.pause();
                song2.pause();
                Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                intent.putExtra("sum",sum);
                startActivity(intent);
            }
        });
    }
}
