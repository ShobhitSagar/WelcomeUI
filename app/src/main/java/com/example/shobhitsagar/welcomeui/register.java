package com.example.shobhitsagar.welcomeui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    Button lginbtn2;
    Button createacntbtn2;

    EditText usrname2;
    EditText pswrd2;
    EditText emailid2;

    String USRNAME2;
    String PSWRD2;
    String EMAIL2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        lginbtn2 = (Button) findViewById(R.id.back_to_login2);
        createacntbtn2 = (Button) findViewById(R.id.crtacnt2);
        usrname2 = (EditText) findViewById(R.id.username2);
        pswrd2 = (EditText) findViewById(R.id.password2);
        emailid2 = (EditText) findViewById(R.id.email2);

        createacntbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                USRNAME2 = usrname2.getText().toString();
                PSWRD2 = pswrd2.getText().toString();
                EMAIL2 = emailid2.getText().toString();

                Intent intent = new Intent(register.this, MainActivity.class);

                intent.putExtra("UN", USRNAME2);
                intent.putExtra("PW", PSWRD2);
                startActivity(intent);

                Toast.makeText(getBaseContext(), "Account Created!", Toast.LENGTH_SHORT).show();

            }
        });

        lginbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(register.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}