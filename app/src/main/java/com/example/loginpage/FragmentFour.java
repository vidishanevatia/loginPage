package com.example.loginpage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FragmentFour extends Fragment  {

    Button bt_one;

    InterfaceToToast t ;




    public FragmentFour() {


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof  InterfaceToToast)
            t=(InterfaceToToast)context;
    }




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_4,container,false);
        bt_one = view.findViewById(R.id.bt_one);

        bt_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t != null)
                    t.getEt();
            }
        });
        return view;
    }

}
