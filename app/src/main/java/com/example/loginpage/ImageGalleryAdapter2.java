package com.example.loginpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImageGalleryAdapter2 extends RecyclerView.Adapter<ExamViewHolder> {

    List<examData> list = Collections.emptyList();

    Context context;

    public ImageGalleryAdapter2(List<examData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ExamViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the layout

        View photoView = inflater.inflate(R.layout.card_layout,
                parent, false);

        ExamViewHolder viewHolder = new ExamViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ExamViewHolder viewHolder,
                                 final int position) {

        viewHolder.examName.setText(list.get(position).name);
        viewHolder.examDate.setText(list.get(position).date);
        viewHolder.examMessage.setText(list.get(position).message);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    // Insert a new item to the RecyclerView on a predefined position


    private List<examData> getData() {
        List<examData> list = new ArrayList<>();
        list.add(new examData("First Exam", "May 23, 2015", "Best Of Luck"));
        list.add(new examData("Second Exam", "June 09, 2015", "b of l"));
        list.add(new examData("My Test Exam", "April 27, 2017",
                "This is testing exam .."));

        return list;
    }
}
