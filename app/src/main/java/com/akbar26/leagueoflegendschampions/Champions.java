package com.akbar26.leagueoflegendschampions;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Gets the position of the list item that was clicked.
 * Gets name and title for that position, and displays the information in the layout template.
 */

public class Champions extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.champions);

        int position = InfoList.getmPosition();
        ArrayList<String> nameAndTitle = InfoList.getmNameAndTitle();

        Object champion;
        champion = nameAndTitle.get(position);
        String championName = ((Word)champion).getmChampionName();
        String championTitle = ((Word)champion).getmChampionTitle();

        TextView championTextView = findViewById(R.id.championName);
        championTextView.setText(championName);
        TextView titleTextView = findViewById(R.id.championTitle);
        titleTextView.setText(championTitle);


    }
}