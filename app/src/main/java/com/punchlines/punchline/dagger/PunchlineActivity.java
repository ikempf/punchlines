package com.punchlines.punchline.dagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class PunchlineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(DaggerPunchlineComponent.create());
    }

    protected abstract void inject(PunchlineComponent component);

}