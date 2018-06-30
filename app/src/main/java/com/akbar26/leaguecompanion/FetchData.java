package com.akbar26.leaguecompanion;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by akbar on 29/05/2018.
 */

public class FetchData extends AsyncTask<Void, Void, List<String>> {
    static String json = "";
    String rowParsed = "";
    private String dataParsed = "";
    List<String> keys = new ArrayList<String>();
    ArrayList<String> keysList = new ArrayList<String>();
    @Override
    protected List<String> doInBackground(Void... params) {
        try {
            String apikey = "RGAPI-97022a3e-87cc-4650-b40b-d9fcf4b26188";
            URL url = new URL("https://euw1.api.riotgames.com/lol/static-data/v3/champions?locale=en_US&dataById=false&api_key=" + apikey);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String json = bufferedReader.readLine();
            JSONObject joOuter = new JSONObject(json);
            JSONObject jo = joOuter.getJSONObject("data");

            Iterator keysToCopyIterator = jo.keys();
            while(keysToCopyIterator.hasNext()) {
                String keyValue = (String) keysToCopyIterator.next();
                keysList.add(keyValue);
            }
//            String x = jo.getString(keysList.get(1));
//            String y = jo.getString(keysList.get(140));
//            String z = jo.getString(keysList.get(90));

//            JSONArray keyValues = jo.names();
            Collections.sort(keysList);
//            keyValues = keyValues.

//            for(int i=0; i < keyValues.length(); i++) {
//                JSONObject championInfo = jo.getJSONObject((String) keyValues.get(i));
//                println(String.valueOf(championInfo));
//            }

///////////////
//            JSONObject objJson=jo.getJSONObject("Jax");
/////////////
            InfoList keys = new InfoList();
            keys.setmKeyList(keysList);
            InfoList info = new InfoList();
            info.setmChampionInfo(jo);

        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return keysList;
}

//    @Override
//    protected void onPostExecute(List<String> aVoid) {
//        super.onPostExecute(aVoid);
//
//        MainActivity.champions.setText(keysList);
//    }
}
