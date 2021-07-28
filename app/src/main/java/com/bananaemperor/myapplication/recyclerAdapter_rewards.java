package com.bananaemperor.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import static com.bananaemperor.myapplication.R.id.finish_quest;
import static com.bananaemperor.myapplication.R.id.reward_row;

public class recyclerAdapter_rewards extends RecyclerView.Adapter<recyclerAdapter_rewards.ViewHolder> {

    List<String> reward_array;


    public recyclerAdapter_rewards(List<String> reward_array) {
        this.reward_array = reward_array;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Set up ViewHolder
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item_reward, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.reward_title.setText(reward_array.get(position)); //Sets the quest text into the recycler view
    }

    @Override //Decides the number of rows in the recycler view
    public int getItemCount() {
        return rewards.reward_amount.reward_amount;

    }

    //public void remove_quest(int position){}

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {  //Create a view holder for the recycler view


        TextView reward_title;
        Button reward_buy;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            reward_title = itemView.findViewById(reward_row);  //Links  the row item xml to the adapter
            reward_buy = itemView.findViewById(R.id.buy_rewards);
            itemView.setOnClickListener(this);

            reward_buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (MainActivity.gold.gold_amount >= 10) {
                        MainActivity.gold.gold_amount -= 10;   //Add gold for finishing quests
                        rewards.reward_gold.gold_value.setText(String.valueOf(MainActivity.gold.gold_amount)); //Update the gold value
                        MainActivity.show_gold.gold_show.setText(String.valueOf(MainActivity.gold.gold_amount));  //Update the gold value on the main activity
                        Snackbar.make(v, "Reward gained!", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }else {
                        Snackbar.make(v, "You don't have the gold required for this reward!", Snackbar.LENGTH_LONG)  //Tell the user that they don't have the required gold
                                .setAction("Action", null).show();
                    }


                }
            });


        }

        @Override
        public void onClick(View v) {

        }
    }
}
