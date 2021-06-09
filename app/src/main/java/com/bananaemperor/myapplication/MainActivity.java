package com.bananaemperor.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView quest_list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText QuestEntry =(EditText)findViewById(R.id.QuestEntry);
        quest_list = (ListView)findViewById(R.id.Quest_List);

        ArrayList<String> arrayList=new ArrayList<>();
         arrayList.add("test");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);

        quest_list.setAdapter(arrayAdapter);
        





    }
}