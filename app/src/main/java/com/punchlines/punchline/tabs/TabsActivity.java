package com.punchlines.punchline.tabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.punchlines.R;

public class TabsActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tabs_activity);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new TabsPager(getSupportFragmentManager(), getApplicationContext()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(pager);
    }

}