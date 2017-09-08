package com.logicturtle.hackathon.Utils;


import android.content.Context;
import android.content.SharedPreferences;

import com.logicturtle.hackathon.Activity.MentorApp;

public class SharedPrefs {


    private SharedPrefs() {
    }

    private static SharedPreferences getPrefrences() {
        Context context = MentorApp.getAppContext();
        return context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }


}
