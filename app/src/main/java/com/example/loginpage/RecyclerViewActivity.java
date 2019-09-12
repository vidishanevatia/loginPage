package com.example.loginpage;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    ImageGalleryAdapter2 adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        List<examData> list = new ArrayList<>();
        list = getData();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        adapter = new ImageGalleryAdapter2(list, getApplication());
        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }

    // sample data for RecyclerView
    private List<examData> getData()
    {
        List<examData> list = new ArrayList<>();
        list.add(new examData("First Exam", "May 23, 2015", "Best Of Luck"));
        list.add(new examData("Second Exam", "June 09, 2015", "b of l"));
        list.add(new examData("My Test Exam", "April 27, 2017", "This is testing exam .."));
        return list;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}