package com.example.android.demoapp.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.android.demoapp.R;
import com.example.android.demoapp.ViewModel.SanPhamViewModel;
import com.example.android.demoapp.ViewModel.SanPhamViewModelFactory;
import com.example.android.demoapp.adapter.CatalogAdapter;
import com.example.android.demoapp.database.AppDatabase;
import com.example.android.demoapp.database.GioHangEntry;
import com.example.android.demoapp.database.SanPhamEntry;
import com.example.android.demoapp.database.YeuThichEntry;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class CatalogActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CatalogAdapter catalogAdapter;
    private AppDatabase mDb;
    private int mIdHang;
    SanPhamViewModelFactory factory1;
    private static final String TAG = CatalogActivity.class.getSimpleName();
    public static final String EXTRA_HANG_ID = "extraHangId";
    private static final int DEFAULT_HANG_ID = -1;
    ImageView imageViewNhaCungCap;
    TabLayout tabLayout;
    TabLayout.Tab tabGioHang;
    TabLayout.Tab tabYeuThich;
    List<GioHangEntry> gioHangEntries;
    List<YeuThichEntry> yeuThichEntries;
    public static BadgeDrawable badgeDrawableYeuthich;
    public static BadgeDrawable badgeDrawableGioHang;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalog_activity);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD|
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|
                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout2);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.iconhome));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.kinh_lup_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.timdo_bar));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.xe_hang));
        imageViewNhaCungCap = findViewById(R.id.image_view_nha_cung_cap);

        tabYeuThich = tabLayout.getTabAt(2);
        tabGioHang = tabLayout.getTabAt(3);


        assert tabGioHang != null;
        badgeDrawableGioHang = tabGioHang.getOrCreateBadge();
        assert tabYeuThich != null;
        badgeDrawableYeuthich = tabYeuThich.getOrCreateBadge();
        badgeDrawableGioHang.setMaxCharacterCount(3);
        badgeDrawableYeuthich.setMaxCharacterCount(3);
        catalogAdapter = new CatalogAdapter(CatalogActivity.this);
        mDb = AppDatabase.getInstance(getApplicationContext());


        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(EXTRA_HANG_ID)) {

            mIdHang = intent.getIntExtra(EXTRA_HANG_ID, DEFAULT_HANG_ID);
            factory1 = new SanPhamViewModelFactory(mDb, mIdHang);

            final SanPhamViewModel viewModel1
                    = ViewModelProviders.of(this, factory1).get(SanPhamViewModel.class);

            viewModel1.getSanPhams().observe(this, new Observer<List<SanPhamEntry>>() {
                @Override
                public void onChanged(@Nullable List<SanPhamEntry> sanPhams) {
                    Log.d(TAG, "Updating list of tasks from LiveData in ViewModel");
                    catalogAdapter.setSanPhams(sanPhams);

                }


            });


            viewModel1.getGioHang().observe(this, new Observer<List<GioHangEntry>>() {
                @Override
                public void onChanged(@Nullable List<GioHangEntry> gioHang) {
                    gioHangEntries = gioHang;
                    int sosanphammua = 0;
                    assert gioHangEntries != null;
                    if (gioHangEntries.size() > 0){
                        for (int i = 0; i < gioHangEntries.size(); i++) {
                            sosanphammua += gioHangEntries.get(i).getSoLuong();
                        }
                        badgeDrawableGioHang.setVisible(true);
                        badgeDrawableGioHang.setNumber(sosanphammua);
                    }
                    else
                        badgeDrawableGioHang.setVisible(false);
                }
            });

            viewModel1.getYeuThich().observe(this, new Observer<List<YeuThichEntry>>() {
                @Override
                public void onChanged(@Nullable List<YeuThichEntry> yeuThich) {
                    yeuThichEntries = yeuThich;
                    catalogAdapter.setYeuThichs(yeuThich);
                    assert yeuThichEntries != null;
                    if (yeuThichEntries.size()>0){
                        badgeDrawableYeuthich.setVisible(true);
                        badgeDrawableYeuthich.setNumber(yeuThichEntries.size());

                    }
                    else
                        badgeDrawableYeuthich.setVisible(false);
                }
            });
        }


        switch (mIdHang){
            case 0:
                imageViewNhaCungCap.setImageResource(R.drawable.logo_wmf);
                break;
            case 1:
                imageViewNhaCungCap.setImageResource(R.drawable.logo_silit);
                break;
            case 2:
                imageViewNhaCungCap.setImageResource(R.drawable.muller);
                break;
            case 3:
                imageViewNhaCungCap.setImageResource(R.drawable.logo_dm);
                break;
            case 4:
                imageViewNhaCungCap.setImageResource(R.drawable.logo_saturn);
                break;
            case 5:
                imageViewNhaCungCap.setImageResource(R.drawable.apotheke_logo);
                break;
            case 6:
                imageViewNhaCungCap.setImageResource(R.drawable.rossmann_logo);
                break;
            case 7:
                imageViewNhaCungCap.setImageResource(R.drawable.worldofsweet);
                break;
            case 8:
                imageViewNhaCungCap.setImageResource(R.drawable.mediamarkt_logo);
                break;
        }

        recyclerView = findViewById(R.id.recycler_view_catalog);
        recyclerView.setHasFixedSize(true);

        Configuration config = getResources().getConfiguration();
        if (config.smallestScreenWidthDp >= 720)
        {
            recyclerView.setLayoutManager(new GridLayoutManager(CatalogActivity.this, 3));
        }
        else
        {
            recyclerView.setLayoutManager(new GridLayoutManager(CatalogActivity.this, 2));
        }
        recyclerView.setAdapter(catalogAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        Intent intent0 = new Intent(CatalogActivity.this, MainActivity.class);
                        CatalogActivity.this.startActivity(intent0);
                        break;

                    case 1 :
                        Intent intent1 = new Intent(CatalogActivity.this, TimKiemActivity.class);
                        CatalogActivity.this.startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(CatalogActivity.this, YeuthichActivity.class);
                        CatalogActivity.this.startActivity(intent2);
                        break;

                    case 3:
                        Intent intent3 = new Intent(CatalogActivity.this, GioHangActivity.class);
                        CatalogActivity.this.startActivity(intent3);
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
                        Intent intent0 = new Intent(CatalogActivity.this, MainActivity.class);
                        CatalogActivity.this.startActivity(intent0);
                        break;
                    case 1 :
                        Intent intent1 = new Intent(CatalogActivity.this, TimKiemActivity.class);
                        CatalogActivity.this.startActivity(intent1);
                        break;

                    case 2:
                        Intent intent2 = new Intent(CatalogActivity.this, YeuthichActivity.class);
                        CatalogActivity.this.startActivity(intent2);
                        break;

                    case 3:
                        Intent intent3 = new Intent(CatalogActivity.this, GioHangActivity.class);
                        CatalogActivity.this.startActivity(intent3);
                        break;

                    default:
                        break;
                }

            }
        });


    }

        @Override
        protected void onNewIntent(Intent intent) {
            super.onNewIntent(intent);
            setIntent(intent);

            intent = getIntent();
            if (intent != null && intent.hasExtra(EXTRA_HANG_ID)) {
                mIdHang = intent.getIntExtra(EXTRA_HANG_ID, DEFAULT_HANG_ID);
                switch (mIdHang){
                    case 0:
                        imageViewNhaCungCap.setImageResource(R.drawable.logo_wmf);
                        break;
                    case 1:
                        imageViewNhaCungCap.setImageResource(R.drawable.logo_silit);
                        break;
                    case 2:
                        imageViewNhaCungCap.setImageResource(R.drawable.muller);
                        break;
                    case 3:
                        imageViewNhaCungCap.setImageResource(R.drawable.logo_dm);
                        break;
                    case 4:
                        imageViewNhaCungCap.setImageResource(R.drawable.logo_saturn);
                        break;
                    case 5:
                        imageViewNhaCungCap.setImageResource(R.drawable.apotheke_logo);
                        break;
                    case 6:
                        imageViewNhaCungCap.setImageResource(R.drawable.rossmann_logo);
                        break;
                    case 7:
                        imageViewNhaCungCap.setImageResource(R.drawable.worldofsweet);
                        break;
                    case 8:
                        imageViewNhaCungCap.setImageResource(R.drawable.mediamarkt_logo);
                        break;
                }

                factory1 = new SanPhamViewModelFactory(mDb, mIdHang);
                final SanPhamViewModel viewModel1
                        = ViewModelProviders.of(this, factory1).get(SanPhamViewModel.class);
                viewModel1.getSanPhams().observe(this, new Observer<List<SanPhamEntry>>() {
                    @Override
                    public void onChanged(@Nullable List<SanPhamEntry> sanPhams) {
                        catalogAdapter.setSanPhams(sanPhams);
                    }
                });

                viewModel1.getYeuThich().observe(this, new Observer<List<YeuThichEntry>>() {
                    @Override
                    public void onChanged(List<YeuThichEntry> yeuThichEntries) {
                        catalogAdapter.setYeuThichs(yeuThichEntries);
                    }
                });
            }


        }

   /* @Override
    protected void onRestart() {
        catalogAdapter.notifyDataSetChanged();
        super.onRestart();
    }*/

    @Override
    protected void onStop() {
        super.onStop();
        getViewModelStore().clear();
    }
}