
package com.bananaemperor.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {
    // defines the various variables that I'll need
    ListView quest_list;
    EditText QuestEntry;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         QuestEntry =(EditText)findViewById(R.id.QuestEntry); //Link the with their Id
        quest_list = (ListView)findViewById(R.id.Quest_List);

        ArrayList<String> arrayList=new ArrayList<>(); //Create an array list for the list view

        //Create the adapter for the list view
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);

        //Create button for adding quest

        Button add_quest = (Button)findViewById(R.id.add_quest);
        add_quest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quest = QuestEntry.getText().toString();
                arrayList.add(quest);                       //pull the text entered into the edit text
                quest_list.setAdapter(arrayAdapter);
                QuestEntry.getText().clear();
                DatabaseHelper MyDB = new DatabaseHelper(MainActivity.this);  //Links this to the database
                MyDB.add_quest(QuestEntry.getText().toString().trim());     //Sends the quest from the edit text to the database

            }
        });






    }
}