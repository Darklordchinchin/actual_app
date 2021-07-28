package com.bananaemperor.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class help extends AppCompatActivity {
    Button menu_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        menu_button = findViewById(R.id.menu_button_help);
        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                 //Open menu
                Intent intent = new Intent(help.this, menu.class);
                startActivity(intent);
            }
        });
    }
}