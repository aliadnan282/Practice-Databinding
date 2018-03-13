package com.workout.sixpacksabs.helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.workout.sixpacksabs.data.entity.Category;


import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.workout.sixpacksabs.helper.AppConstant.CATEGORY_JSON_PATH;

/**
 * Created by AdnanAli on 1/29/2018.
 */

public class JsonManager {
    public static JsonManager ourInstance;
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    private JsonManager() {
    }

    public static JsonManager getInstance() {
        if (ourInstance == null)
            ourInstance = new JsonManager();

        return ourInstance;
    }

 /*   public static String m24329a(int i) {
        switch (i) {
            case 24:
                return "json/abs/all_levels.json";
            case 25:
                return "json/shoulder_back/all_levels.json";
            case 26:
                return "json/leg/all_levels.json";
            default:
                return "json/arm_chest/all_levels.json";
        }
    }*/


    public List<Category> getCategoriseModel() {
        String exerciseJson = JsonReadUtils.loadJSONFromAsset(CATEGORY_JSON_PATH);
        Type listType = new TypeToken<List<Category>>() {
        }.getType();

        List<Category> yourList = new ArrayList<>();
        try {
            yourList = new Gson().fromJson(new JSONObject(exerciseJson).getJSONArray("plan_categories").toString(), listType);
        } catch (JSONException e) {
            yourList = new ArrayList<>();
            e.printStackTrace();
        }
        return yourList;
    }
}