package com.example.loginpage;

import android.app.AlertDialog;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class FragmentDrawerLayout extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {



    TabLayout tabLayout;
    ViewPager viewPager;
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
        setContentView(R.layout.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




//      FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Thank you for liking my app!", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);
        preferences = getSharedPreferences(pref,private_mode);
        editor = preferences.edit();

        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Map"));
        tabLayout.addTab(tabLayout.newTab().setText("Movie"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final MyAdapter adapter = new MyAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

public static void sendmessage()
{
    //Toast.makeText( App.this ,"connected", Toast.LENGTH_SHORT).show();
    Log.d("Connected","connected");
}


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_seekbar) {
            Intent intent = new Intent(FragmentDrawerLayout.this , SeekBarActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_progress) {
            Intent intent = new Intent(FragmentDrawerLayout.this , ProgressBar.class);
            startActivity(intent);

        } else if (id == R.id.nav_rating) {
            Intent intent = new Intent(FragmentDrawerLayout.this , FragmentFrame.class);
            startActivity(intent);


        } else if (id == R.id.nav_signout) {

            builder = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to close this application ?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            editor.clear();
                            editor.commit();
                            Intent intent = new Intent(FragmentDrawerLayout.this,MainActivity.class);
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
        else if (id == R.id.nav_rating2) {
            Intent intent = new Intent(FragmentDrawerLayout.this , RatingStars.class);
            startActivity(intent);


        } else if (id == R.id.nav_at) {
            Intent intent = new Intent(FragmentDrawerLayout.this , AsyncTaskActivity.class);
            startActivity(intent);

        }

        else if(id == R.id.nav_toggle){
            Intent intent = new Intent(FragmentDrawerLayout.this , ToggleButtonActivity.class);
            startActivity(intent);
        }

        else if(id == R.id.nav_radiobutton){
            Intent intent = new Intent(FragmentDrawerLayout.this , RadioButtonActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.nav_checkbox){
            Intent intent = new Intent(FragmentDrawerLayout.this , CheckBoxActivity.class);
            startActivity(intent);
        }

        else if(id == R.id.nav_spinner){
            Intent intent = new Intent(FragmentDrawerLayout.this , SpinnerAcitivity.class);
            startActivity(intent);
        }
        else if(id == R.id.nav_camera){
            Intent intent = new Intent(FragmentDrawerLayout.this , CameraActivity.class);
            startActivity(intent);
        }

        else if(id == R.id.nav_listview){
            Intent intent = new Intent(FragmentDrawerLayout.this , ListViewActivity.class);
            startActivity(intent);
        }

        else if(id == R.id.nav_elv){
            Intent intent = new Intent(FragmentDrawerLayout.this ,ExpandableListViewActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.nav_gridview){
            Intent intent = new Intent(FragmentDrawerLayout.this , GridViewActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.nav_scrollview){
            Intent intent = new Intent(FragmentDrawerLayout.this , ScrollView.class);
            startActivity(intent);
        }
        else if(id == R.id.nav_numberpicker){
            Intent intent = new Intent(FragmentDrawerLayout.this , NumberPickerActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.nav_dtpicker){
            Intent intent = new Intent(FragmentDrawerLayout.this , DateTimePickerActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.nav_recyclerview){
            Intent intent = new Intent(FragmentDrawerLayout.this , RecyclerViewActivity.class);
            startActivity(intent);
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }



}

