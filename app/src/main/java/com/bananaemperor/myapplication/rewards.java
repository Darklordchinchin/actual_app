package com.bananaemperor.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class rewards extends AppCompatActivity {
    EditText rewardEntry;
    RecyclerView reward_list;
    recyclerAdapter_rewards recyclerAdapter_reward;
    Button menu_button, rewardBtn;

    public static class reward_gold { //Set up a public static method for the gold value so that it can be called anywhere
        public static TextView gold_value;
    }

    List<String> reward_array;

    public static class reward_amount {    //Make a public static method for the amount of rewards so the var can be called in the recycler adapter
        public static int reward_amount;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);
        rewardEntry = findViewById(R.id.reward_entry);

        menu_button = findViewById(R.id.Menubtn_reward);
        rewardBtn = findViewById(R.id.reward_button);

        reward_array = new ArrayList<>(); //Make an array list for the recycler view
        reward_list = findViewById(R.id.rewards_list);


        recyclerAdapter_reward = new recyclerAdapter_rewards(reward_array);  //setup the adapter for the recycler view
        reward_list.setAdapter(recyclerAdapter_reward);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);//make the recycler view look better
        reward_list.addItemDecoration(dividerItemDecoration);


        reward_gold.gold_value = findViewById(R.id.gold_value);
        reward_gold.gold_value.setText(String.valueOf(MainActivity.gold.gold_amount));  //Display the gold value from the main activity


        menu_button.setOnClickListener(new View.OnClickListener() { //Setup the menu button
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rewards.this, menu.class);
                startActivity(intent);
            }
        });



        rewardBtn.setOnClickListener(new View.OnClickListener() { //Button to add a reward
            @Override
            public void onClick(View v) {
                String reward_name = rewardEntry.getText().toString();
                if (reward_name.isEmpty()) {  //Check if the user has entered some text
                    Snackbar.make(v, "Please enter a reward", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }else {
                    reward_array.add(reward_name);   //Adds the reward to the array list
                    reward_amount.reward_amount = reward_array.size(); //sets the number of rewards to the number of items in the array list
                    rewardEntry.getText().clear();
                }
            }
        });


    }
}