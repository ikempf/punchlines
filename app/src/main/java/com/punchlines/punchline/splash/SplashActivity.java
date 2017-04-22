package com.punchlines.punchline.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.punchlines.R;
import com.punchlines.punchline.tabs.TabsActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, TabsActivity.class);
            startActivity(intent);
        }, 1000);
    }

}