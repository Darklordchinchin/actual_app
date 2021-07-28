package com.bananaemperor.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {
    Button questPage_btn, rewardPage_btn, kamar_btn, help_btn; //Create variables for the buttons

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
        questPage_btn = findViewById(R.id.questPage_btn); //Link the variables to the object ids
        rewardPage_btn = findViewById(R.id.rewardPage_btn);
        kamar_btn = findViewById(R.id.kamar_btn);
        help_btn = findViewById(R.id.helpPage_btn);


        //Button for the Quest page
        questPage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this,MainActivity.class);
                startActivity(intent);
            }
        });

        //Button for the kamar page
        kamar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this,kamar_webview.class);
                startActivity(intent);
            }
        });

        //Button for the reward page
       rewardPage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this,rewards.class);
                startActivity(intent);
            }
        });

       //Button for te help page
        help_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this,help.class);
                startActivity(intent);
            }
        });


    }
}