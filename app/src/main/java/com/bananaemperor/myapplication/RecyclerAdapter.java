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

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<String> quest_array;
    //Context mContext;


    public RecyclerAdapter(List<String> quest_array) {
        this.quest_array = quest_array;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.quest_title.setText(quest_array.get(position)); //Sets the quest text into the recycler view
    }

    @Override //Decides the number of rows in the recycler view
    public int getItemCount() {
        return MainActivity.quest_number.quest_num;

    }



    public void remove_quest(int position){}

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {  //Create a view holder for the recycler view


        TextView quest_title;
        Button quest_end;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            quest_title = itemView.findViewById(reward_row);  //Links  the row item xml to the adapter
            quest_end = itemView.findViewById(finish_quest);
            itemView.setOnClickListener(this);

            quest_end.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    MainActivity.gold.gold_amount += 10;   //Add gold for finishing quests
                    MainActivity.show_gold.gold_show.setText(String.valueOf(MainActivity.gold.gold_amount));  //Update the gold value on the main activity
                    Snackbar.make(v, "Quest completed!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();


                }
            });


        }

        @Override
        public void onClick(View v) {

        }
    }
}
