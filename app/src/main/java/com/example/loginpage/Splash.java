package com.example.loginpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends Activity {

    Handler handler;

    TextView tv_name1;

    SharedPreferences preferences;
    private static final String pref = "Android";
    public static final String User = "email@gmail.com";
    public static final String Password = "password";
    public static final String IsLogin = "LoggedIn";
    int private_mode =0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        preferences = getSharedPreferences(pref,private_mode);
        tv_name1=findViewById(R.id.tv_name1);


        handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run() {
                if(!isLoggedIn()) {
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Intent intent = new Intent(Splash.this, FragmentDrawerLayout.class);
                    startActivity(intent);
                    finish();
                }
            }
        },3000);
    }


    public  boolean isLoggedIn()
    {
        return preferences.getBoolean(IsLogin, false);
    }
}
