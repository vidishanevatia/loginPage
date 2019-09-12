package com.example.loginpage;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.loginpage.R;

public class RegisterFragments extends AppCompatActivity {

    LinearLayout rtvw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdpage);
        rtvw=findViewById(R.id.rtvw);


        //rtvw.removeAllViews();

        addFragment1(new FragmentOne(),false,"one");
        addFragment2(new FragmentTwo(),false,"two");
    }



    public void addFragment1(Fragment fragment, boolean addToBackStack, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if (addToBackStack) {
            ft.addToBackStack(tag);
        }
        ft.replace(R.id.frame1, fragment, tag);
        ft.commit();
    }

    public void addFragment2(Fragment fragment, boolean addToBackStack, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if (addToBackStack) {
            ft.addToBackStack(tag);
        }
        ft.replace(R.id.frame2, fragment, tag);
        ft.commit();
    }
}
