package com.example.loginpage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RadioButtonActivity  extends AppCompatActivity {
    Button button;
    RadioButton genderradioButton, radioButton1, radioButton2;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_button);
        radioGroup = findViewById(R.id.radioGroup);
        button = findViewById(R.id.button);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                genderradioButton = (RadioButton) findViewById(selectedId);
                if(selectedId==-1){
                    Toast.makeText(RadioButtonActivity.this,"Nothing selected for group 2", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RadioButtonActivity.this,genderradioButton.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
