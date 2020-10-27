package com.example.android.demoapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.android.demoapp.Presenter.PresenterLogicXuLyMenu;
import com.example.android.demoapp.R;
import com.example.android.demoapp.ViewModel.MainViewModel;
import com.example.android.demoapp.adapter.CategoryAdapter;
import com.example.android.demoapp.adapter.NavigationViewAdapter;
import com.example.android.demoapp.database.AppDatabase;
import com.example.android.demoapp.database.GioHangEntry;
import com.example.android.demoapp.database.YeuThichEntry;
import com.example.android.demoapp.model.ModelDangNhap;
import com.example.android.demoapp.widget.MyService;
import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GoogleSignInAccount account ;
    Toolbar toolbar;
    public static final int RC_SIGN_IN = 1;
    ImageView imageView;
    CategoryAdapter viewPageAdapter;
    TabLayout.Tab tabGioHang;
    TabLayout.Tab tabYeuThich;
    public static BadgeDrawable badgeDrawableYeuthich;
    public static BadgeDrawable badgeDrawableGioHang;

    private RecyclerView list;
    private NavigationViewAdapter recyclerAdapter;
    private DrawerLayout mDrawerLayout;



    private AppDatabase mDb;
    List<GioHangEntry> gioHangEntries;
    List<YeuThichEntry> yeuThichEntries;


    public  static boolean mainActivityOnCreat = false;
    AccessToken accessToken;
    PresenterLogicXuLyMenu logicXuLyMenu;
    ViewPager2 viewPager2;
    public static TabLayout tabLayout;
    Button buttonDangNhap;
    Button buttonDangXuat;
    GoogleSignInClient mGoogleSignInClient ;
    ModelDangNhap modelDangNhap = new ModelDangNhap();

    TextView textViewTenKhachHang;
    String tennguoidung = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD|
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|
                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

        Intent intent = new Intent(this, MyService.class);
        startService(intent);


        init();
        mainActivityOnCreat = true;
        ArrayList<String> caNhan = new ArrayList<String>();

        caNhan.add(getString(R.string.hinh_thuc_thanh_toan));

        caNhan.add(getString(R.string.giao_hang));
        caNhan.add(getString(R.string.chinh_sach_doi_tra));
        caNhan.add(getString(R.string.lien_he));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.END);

            }
        });


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        recyclerAdapter = new NavigationViewAdapter(MainActivity.this, caNhan);
        list.setAdapter(recyclerAdapter);

        //ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name, R.string.app_name);



    }



    @Override
    public void onBackPressed() {
       if(mDrawerLayout.isDrawerOpen(GravityCompat.END)){
           mDrawerLayout.closeDrawer(GravityCompat.END);
       }else{
        super.onBackPressed();}
    }


        private void init () {

            toolbar = findViewById(R.id.toolbar);
            mDrawerLayout = findViewById(R.id.drawer_layout);
            imageView = findViewById(R.id.anhcanhan);


            list = (RecyclerView) findViewById(R.id.recycleview);




            viewPager2 = (ViewPager2) findViewById(R.id.viewpager);
            viewPageAdapter = new CategoryAdapter(this);
            viewPager2.setAdapter(viewPageAdapter);

            tabLayout = (TabLayout) findViewById(R.id.tab_layout);
            TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
                @Override
                public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                    switch (position) {
                        case 0: {
                            tab.setIcon(R.drawable.iconhome);
                            break;
                        }
                        case 1: {
                            tab.setIcon(R.drawable.kinh_lup_icon);
                            break;
                        }
                        case 2: {
                            tab.setIcon(R.drawable.timdo_bar);
                            break;
                        }
                        case 3: {
                            tab.setIcon(R.drawable.xe_hang);
                            break;
                        }
                    }
                }
            });

            tabLayoutMediator.attach();

            tabYeuThich = tabLayout.getTabAt(2);
            tabGioHang = tabLayout.getTabAt(3);

            badgeDrawableGioHang = tabGioHang.getOrCreateBadge();
            badgeDrawableYeuthich = tabYeuThich.getOrCreateBadge();

            mDb = AppDatabase.getInstance(getApplicationContext());
            MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
            mainViewModel.getGioHang().observe(this, new Observer<List<GioHangEntry>>() {
                @Override
                public void onChanged(@Nullable List<GioHangEntry> gioHang) {
                    gioHangEntries = gioHang;
                    int sosanphammua = 0;

                    if (gioHangEntries.size() > 0) {
                        for (int i = 0; i < gioHangEntries.size(); i++) {
                            sosanphammua += gioHangEntries.get(i).getSoLuong();
                        }
                        badgeDrawableGioHang.setVisible(true);

                        badgeDrawableGioHang.setNumber(sosanphammua);
                    } else
                        badgeDrawableGioHang.setVisible(false);
                }
            });

            mainViewModel.getYeuThich().observe(this, new Observer<List<YeuThichEntry>>() {
                @Override
                public void onChanged(@Nullable List<YeuThichEntry> yeuThich) {
                    yeuThichEntries = yeuThich;
                    if (yeuThichEntries.size() > 0) {
                        badgeDrawableYeuthich.setVisible(true);
                        badgeDrawableYeuthich.setNumber(yeuThichEntries.size());

                    } else
                        badgeDrawableYeuthich.setVisible(false);

                }
            });


        }
        }

/*

  private DrawerLayout mDrawerLayout;
    private RecyclerView list;
    private adapter recyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view11);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        list = (RecyclerView) findViewById(R.id.list);
        //Data
        ArrayList<String> nav_item = new ArrayList<>();
        nav_item.add("Home");
        nav_item.add("App");
        nav_item.add("Blog");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        recyclerAdapter = new adapter(NavigationViewActivity11.this, nav_item);
        list.setAdapter(recyclerAdapter);

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name, R.string.app_name);

        mDrawerLayout.addDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

    }

    private class adapter extends RecyclerView.Adapter<adapter.myViewHolder> {
        Context context;
        List<String> mData;

        public adapter(Context context, List<String> data) {
            this.context = context;
            this.mData = data;
        }

        @Override
        public adapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.navigationrecyclerview_adapter11, parent, false);
            return new myViewHolder(view);
        }

        @Override
        public void onBindViewHolder(adapter.myViewHolder holder, int position) {
            holder.country.setText(mData.get(position));
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
        public class myViewHolder extends RecyclerView.ViewHolder {
            TextView nav;

            public myViewHolder(View itemView) {
                super(itemView);
                nav = (TextView) itemView.findViewById(R.id.nav);
            }
        }
    }

*/





