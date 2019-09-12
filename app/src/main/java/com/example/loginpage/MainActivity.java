package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_name2,tv_forgot,tv_signUp;
    EditText et_email,et_password;
    Button bt_signIn;

    public static SharedPreferences preferences;
    SharedPreferences.Editor editor;
    int private_mode =0;

    private static final String pref = "Android";
    public static final String User = "email@gmail.com";
    public static final String Password = "password";
    public static final String IsLogin = "LoggedIn";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_name2 = findViewById(R.id.tv_name2);
        tv_forgot = findViewById(R.id.tv_forgot);
        tv_signUp = findViewById(R.id.tv_signUp);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        bt_signIn=findViewById(R.id.bt_signIn);


        preferences = getSharedPreferences(pref,private_mode);
        editor = preferences.edit();


        bt_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_email.getText().length()==0 && et_password.getText().length()==0)
                {
                    Toast.makeText(MainActivity.this,"Please enter the required information.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(et_email.getText().toString().equals("email@gmail.com")&& et_password.getText().toString().equals("password")) {
                        Toast.makeText(MainActivity.this, "Username and Password are correct.", Toast.LENGTH_LONG).show();
                        editor.putBoolean(IsLogin,true);
                        editor.putString(User, "email@gmail.com");
                        editor.putString(Password,"password");
                        editor.commit ();
                        Intent intent = new Intent(MainActivity.this , FragmentDrawerLayout.class);
                        startActivity(intent);
                        finish();
                    }
                    else if(!et_email.getText().toString().equals("email@gmail.com")&& !et_password.getText().toString().equals("password")) {
                        Toast.makeText(MainActivity.this, "Username and Password are incorrect.", Toast.LENGTH_SHORT).show();
                    }
                    else if (!et_email.getText().toString().equals("email@gmail.com")&& et_password.getText().toString().equals("password")) {
                        Toast.makeText(MainActivity.this, "Username is incorrect.", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(MainActivity.this, "Password is incorrect.", Toast.LENGTH_SHORT).show();
                }

            }
        });


        tv_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterFragments.class);
                startActivity(intent);
                //finish();
            }
        });



    }


}
