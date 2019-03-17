package com.soces_fni.mdoser;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

/**
 * controller for tabs.
 */
public class Main2Activity extends AppCompatActivity {

    private SectionsPageAdapter sectionsPageAdapter;
    private ViewPager nVewPager;

    /**
     * create the view.
     * @param savedInstanceState .
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        nVewPager = findViewById(R.id.container);
        setupViewPager(nVewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(nVewPager);
    }

    /**
     * method where the tabs are being added.
     * @param viewPager .
     */
    private void setupViewPager(ViewPager viewPager)
    {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new BrickTab(), "BRICKS");
        adapter.addFragment(new ElementTab(), "ELEMENTS");
        viewPager.setAdapter(adapter);
    }
}
