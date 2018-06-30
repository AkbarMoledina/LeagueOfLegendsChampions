package com.akbar26.leaguecompanion;

import org.json.JSONObject;

import java.util.ArrayList;

public class InfoList {

    private static ArrayList<String> mKeyList;
    private static JSONObject mChampionInfo;

    public static ArrayList<String> getmKeyList() {
        return mKeyList;
    }

    public void setmKeyList(ArrayList<String> mKeyList) {
        this.mKeyList = mKeyList;
    }

    public JSONObject getmChampionInfo() {
        return mChampionInfo;
    }

    public void setmChampionInfo(JSONObject mChampionInfo) {
        this.mChampionInfo = mChampionInfo;
    }
}
