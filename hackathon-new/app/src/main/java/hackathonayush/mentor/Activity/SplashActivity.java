package hackathonayush.mentor.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import hackathonayush.mentor.R;
import hackathonayush.mentor.Utils.SharedPrefs;

/**
 * Created by kunwar on 20/10/17.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (SharedPrefs.getID(this)!=0) {
            Intent intent = HomeActivity.getNewInstance(this);
            startActivity(intent);
            finish();
        }
        else
        {

            Intent intent = LoginActivity.getNewInstance(this);
            startActivity(intent);
            finish();
        }
    }
}
