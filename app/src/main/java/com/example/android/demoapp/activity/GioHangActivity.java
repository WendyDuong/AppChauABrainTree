package com.example.android.demoapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.android.demoapp.R;
import com.example.android.demoapp.ViewModel.GioHangViewModel;
import com.example.android.demoapp.database.YeuThichEntry;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class GioHangActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private    TabLayout tabLayout;
    private  TabLayout.Tab tabYeuThich;
    public static  BadgeDrawable badgeDrawableYeuthich;
    List<YeuThichEntry> yeuThichEntries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gio_hang_activity);



        toolbar = findViewById(R.id.toolbar_gio_hang_activity);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout_gio_hang_activity);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             onBackPressed();

            }
        });
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.kinh_lup_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.timdo_bar));
        tabYeuThich = tabLayout.getTabAt(1);
        badgeDrawableYeuthich = tabYeuThich.getOrCreateBadge();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        Intent intent0 = new Intent(GioHangActivity.this, TimKiemActivity.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(GioHangActivity.this, YeuthichActivity.class);
                       startActivity(intent1);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        Intent intent0 = new Intent(GioHangActivity.this, TimKiemActivity.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(GioHangActivity.this, YeuthichActivity.class);
                        startActivity(intent1);
                        break;
                    default:
                        break;
                }
            }

        });
        GioHangViewModel viewModel = ViewModelProviders.of(this).get(GioHangViewModel.class);
        viewModel.getYeuThich().observe(this, new Observer<List<YeuThichEntry>>() {
            @Override
            public void onChanged(@Nullable List<YeuThichEntry> yeuThich) {
                yeuThichEntries = yeuThich;
                if (yeuThichEntries.size()>0){
                    badgeDrawableYeuthich.setVisible(true);
                    badgeDrawableYeuthich.setNumber(yeuThichEntries.size());

                }
                else
                    badgeDrawableYeuthich.setVisible(false);

            }
        });
    }



/*
    private void setupbadgeDrawableYeuThich() {
        Cursor cursorSoSanPhamYeuThich = getContentResolver().query(SanPhamContract.SanPhamEntry.CONTENT_URI_2, null, null, null, null);
        if (cursorSoSanPhamYeuThich.getCount() > 0) {
            badgeDrawableYeuthich.setVisible(true);

            badgeDrawableYeuthich.setNumber(cursorSoSanPhamYeuThich.getCount());
        } else
            badgeDrawableYeuthich.setVisible(false);

        cursorSoSanPhamYeuThich.close();
    }


    @Override
    protected void onRestart() {

        setupbadgeDrawableYeuThich();
        super.onRestart();
    }
*/


}
































