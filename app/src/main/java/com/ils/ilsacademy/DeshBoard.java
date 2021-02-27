package com.ils.ilsacademy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class DeshBoard extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton etNotice;
    private FloatingActionButton etMedia;
    private FloatingActionButton etLive;
    private ImageView etScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desh_board);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("");
        //   getSupportActionBar().setLogo(R.drawable.logo);

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        etNotice = findViewById(R.id.etNotice);

        etNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent not = new Intent(DeshBoard.this, NoticeActivity.class);
                startActivity(not);
            }
        });
        etMedia = findViewById(R.id.etMedia);

        etMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent med = new Intent(DeshBoard.this, MediaActivity.class);
                startActivity(med);
            }
        });


        etLive = findViewById(R.id.etLive);

        etLive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent liv = new Intent(DeshBoard.this, LiveActivity.class);
                startActivity(liv);
            }
        });

        etScreen = findViewById(R.id.etScreen);
        etScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scr = new Intent(DeshBoard.this, ProfileScreen.class);
                startActivity(scr);
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NoticeFragment(), "Notice");
        adapter.addFragment(new MediaFragment(), "Media");
        adapter.addFragment(new LiveFragment(), "live");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return mFragmentTitleList.get(position);
        }
    }
}