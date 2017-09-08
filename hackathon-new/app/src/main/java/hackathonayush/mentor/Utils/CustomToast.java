package hackathonayush.mentor.Utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.Toast;


import hackathonayush.mentor.Activity.MentorApp;

/**
 * Created by kunwar on 01-07-2017.
 */

public class CustomToast extends Toast {

    public CustomToast(Context context) {
        super(context);
    }

    public static void show(String message) {
        Context context = MentorApp.getAppContext();
        if (context == null)
            return;
        makeText(context, message, LENGTH_SHORT).show();
    }

    public static void show(int string) {
        Context context = MentorApp.getAppContext();
        if (context == null)
            return;
        makeText(context, context.getString(string), LENGTH_SHORT).show();
    }

    public static void show(Fragment fragment, int string) {
        if (!fragment.isAdded())
            return;
        show(string);
    }

    public static void show(Fragment fragment, String string) {
        if (!fragment.isAdded())
            return;
        show(string);
    }

}
