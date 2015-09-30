package com.beautylapsdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

/**
 * Created by Aditri_Kinnu on 9/19/2015.
 */
public class LoginScreen extends Activity {

    ImageView img_fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login_screen);

        img_fb = (ImageView) findViewById(R.id.img_facebook);

        img_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginScreen.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}

