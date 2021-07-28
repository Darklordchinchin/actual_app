
package com.bananaemperor.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {
    // defines the various variables that I'll need
    EditText QuestEntry;
    RecyclerView quest_list;
    RecyclerAdapter recyclerAdapter;
    Button menu_button;
    public static class show_gold {
        public static TextView gold_show;
    }

    public static class quest_number {   //Creates a variable for the number of quests that can be called anywhere
        public static int quest_num;
    }

    public static class gold {          //Creates a public static method so that the gold variable can be called from anywhere
        public static int gold_amount;
    }


    List<String> quest_array;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         QuestEntry =findViewById(R.id.QuestEntry); //Link the with their Id
        gold.gold_amount = 0; //set up the initial gold amount, which is zero

         show_gold.gold_show = findViewById(R.id.gold_value);
         show_gold.gold_show.setText(String.valueOf(gold.gold_amount)); //Show the initial gold value






        quest_array = new ArrayList<>();   //Creates a new array list for quests
        quest_list = findViewById(R.id.quest_list);

        recyclerAdapter = new RecyclerAdapter(quest_array);  //Creates aan adapter for the recycler view
        quest_list.setAdapter(recyclerAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        quest_list.addItemDecoration(dividerItemDecoration);

        menu_button = findViewById(R.id.Menu_Button);
        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {              //Take to the menu

                Intent intent = new Intent(MainActivity.this, menu.class);
                startActivity(intent);


            }
        });






        //Create button for adding quest
        Button add_quest = (Button)findViewById(R.id.add_quest);
        add_quest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quest_name = QuestEntry.getText().toString();
                if (quest_name.isEmpty()){                 //Check if the quest has been left empty
                    Snackbar.make(v, "Please enter a quest!", Snackbar.LENGTH_LONG)   //Remind the user to enter some text for the quest
                            .setAction("Action", null).show();

                }else {         //If there is actual text entered
                    quest_array.add(quest_name);   //Adds the quest to the array list
                    quest_number.quest_num = quest_array.size(); //sets the number of quests to the number of items in the array list
                    QuestEntry.getText().clear();   //Clears up the edit text


                }




            }
        });






    }
}