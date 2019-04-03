package com.soces_fni.mdoser;

import android.nfc.Tag;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * controller for tabs.
 */
public class Main2Activity extends AppCompatActivity {

    private SectionsPageAdapter sectionsPageAdapter;
    private ViewPager nVewPager;
    private TabHost tabHost;

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
        adapter.addFragment(new BrickTab(), "Ladrillos");
        adapter.addFragment(new ElementTab(), "Elementos");
        viewPager.setAdapter(adapter);
    }
}
