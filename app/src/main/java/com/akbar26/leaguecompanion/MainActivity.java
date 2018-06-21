package com.akbar26.leaguecompanion;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static TextView champions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        champions = (TextView) findViewById(R.id.champions);

        FetchData process = new FetchData();
        process.execute();

        ArrayList x = new ArrayList<Word>();
        x.add(new Word("Kassadin", "The Void Walker"));
        x.add(new Word("Karthus", "The Deathsinger"));
        x.add(new Word("Lee Sin", "The Blind Monk"));
        x.add(new Word("Vladimir", "The Crimson Reaper"));
        x.add(new Word("Sejuani", "The Winter's Wrath"));
        x.add(new Word("Ekko", "The Boy Who Shattered Time"));
        x.add(new Word("Karma", "The Enlightened One"));
        x.add(new Word("Sivir", "The Battle Mistress"));
        x.add(new Word("Kha'Zix", "The Voidreaver"));

        ListAdapter adapter = new ListAdapter(this, x);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        int y = 1;

        listView.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String championName = String.valueOf(parent.getItemAtPosition(position));
                    Toast.makeText(MainActivity.this, championName, Toast.LENGTH_LONG).show();
                    Intent championsIntent = new Intent(MainActivity.this, Champions.class);
                    startActivity(championsIntent);
                }
            }
        );
    }
}
