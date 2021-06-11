package com.example.shobhitsagar.welcomeui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loginbtn1;
    Button registerbtn1;
    EditText ed_usrname1;
    EditText ed_password1;
    String USRNAME1;
    String PSWRD1;
    String Intent_String_USRNAME;
    String Intent_String_PSWRD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        loginbtn1 = (Button) findViewById(R.id.loginbutton1);
        registerbtn1 = (Button) findViewById(R.id.register1);
        ed_usrname1 = (EditText) findViewById(R.id.username1);
        ed_password1 = (EditText) findViewById(R.id.password1);

        Intent intent = getIntent();
        Intent_String_USRNAME = intent.getStringExtra("UN");
        Intent_String_PSWRD = intent.getStringExtra("PW");


        loginbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                USRNAME1 = ed_usrname1.getText().toString();
                PSWRD1 = ed_password1.getText().toString();

                if (USRNAME1.equals(Intent_String_USRNAME) && PSWRD1.equals(Intent_String_PSWRD)) {

                    final ProgressDialog dialog = ProgressDialog.show(MainActivity.this, "Please Wait", "Loading...", true);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(5000);
                                dialog.dismiss();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();

                    Intent i = new Intent(MainActivity.this, welcomeActivity.class);
                    startActivity(i);
                    Toast.makeText(getBaseContext(), "Logged In!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getBaseContext(), "Wrong Detail!!", Toast.LENGTH_SHORT).show();
                }
            }
        });



        registerbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, register.class);
                startActivity(intent);
            }
        });
    }
}
