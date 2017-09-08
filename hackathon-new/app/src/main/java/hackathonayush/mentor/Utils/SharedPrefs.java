package hackathonayush.mentor.Utils;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import hackathonayush.mentor.Activity.MentorApp;

public class SharedPrefs {


    private SharedPrefs() {
    }

    public static SharedPreferences getPrefrences() {
        Context context = MentorApp.getAppContext();
        return context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }

    public static void storeID(int id, Activity activity) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("id", id);
        editor.commit();
    }

    public static int getID(Activity activity) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        return sharedPref.getInt("id", 0);
    }
}
