package com.example.loginpage;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.loginpage.R;

public class FragmentFrame extends AppCompatActivity implements InterfaceToToast  {

    private FrameLayout frame3, frame4;
    private FragmentThree mUpperFrag;
    Button bt_signOut;
    AlertDialog.Builder builder;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private static final String pref = "Android";
    public static final String User = "email@gmail.com";
    public static final String Password = "password";
    public static final String IsLogin = "LoggedIn";
    int private_mode =0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourthpage);

        preferences = getSharedPreferences(pref,private_mode);
        editor = preferences.edit();
        frame3= findViewById(R.id.frame3);
        frame4= findViewById(R.id.frame4);
        bt_signOut= findViewById(R.id.bt_signOut);


        FragmentManager fragmentManager = getSupportFragmentManager();


        mUpperFrag = (FragmentThree) fragmentManager.findFragmentByTag("upper");
        if (mUpperFrag == null) {
            mUpperFrag = new FragmentThree();
            fragmentManager.beginTransaction().add(R.id.frame3, mUpperFrag, "upper").commit();
        }

        FragmentFour mLowerFrag =  (FragmentFour) fragmentManager.findFragmentByTag("lower");
        if (mLowerFrag == null) {
            mLowerFrag = new FragmentFour();
            fragmentManager.beginTransaction().add(R.id.frame4, mLowerFrag, "lower").commit();
        }


        builder = new AlertDialog.Builder(this);
        bt_signOut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                builder.setMessage("Do you want to close this application ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                editor.clear();
                                editor.commit();
                                Intent intent = new Intent(FragmentFrame.this,MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                // Add new Flag to start new Activity
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                                Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Alert!!");
                alert.show();


            }
        });
    }


    @Override
    public void getEt() {
        mUpperFrag.showToast();
    }
}
