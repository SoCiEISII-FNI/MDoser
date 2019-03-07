package com.soces_fni.mdoser;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "Main";

    private SectionsPageAdapter sectionsPageAdapter;
    private ViewPager nVewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        nVewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(nVewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(nVewPager);
    }

    private void setupViewPager(ViewPager viewPager)
    {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new BrickTab(), "tab1");
        adapter.addFragment(new ElementTab(), "tab2");
        viewPager.setAdapter(adapter);
    }
}
