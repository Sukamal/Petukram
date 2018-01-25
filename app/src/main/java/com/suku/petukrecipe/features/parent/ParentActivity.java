package com.suku.petukrecipe.features.parent;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.suku.petukrecipe.R;
import com.suku.petukrecipe.features.home.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SukamalD on 24-01-2018.
 */

public class ParentActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ParentViewInterface{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view) NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    private AdView googleAdd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initToolbar();
        initDrawer();
        initListners();
        displayLauncer(R.id.nav_home);
        initializeGoogleAdd();
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            displayView(new HomeFragment(),false);
            Toast.makeText(ParentActivity.this,"Home",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_indian) {

        } else if (id == R.id.nav_breakfast) {

        } else if (id == R.id.nav_lunch) {

        } else if (id == R.id.nav_sancks) {

        } else if (id == R.id.nav_dinner) {

        }else if (id == R.id.nav_oven) {

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void displayMessage(String msg) {

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initDrawer(){
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void initListners(){
        navigationView.setNavigationItemSelectedListener(this);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    private void displayLauncer(int menuId){
        onNavigationItemSelected(navigationView.getMenu().findItem(menuId));
    }

    private void displayView(final Fragment fragment, final boolean addtoBac){
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.popBackStackImmediate(fragment.getClass().getName(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fl_MainContainer,fragment,fragment.getClass().getName());
                if(addtoBac){
                    fragmentTransaction.addToBackStack(fragment.getClass().getName());
                }
                fragmentTransaction.commit();
            }
        });

    }

    private void initializeGoogleAdd(){
        googleAdd = findViewById(R.id.av_google_add);
//        googleAdd.setAdSize(AdSize.BANNER);
//        googleAdd.setAdUnitId(getString(R.string.banner_footer));

//        AdRequest adRequest = new AdRequest.Builder().build();
//        googleAdd.loadAd(adRequest);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("D463C1CED27146A7809AA8C59A1E5E8B")
                .build();

        googleAdd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
            }

            @Override
            public void onAdClosed() {
                Toast.makeText(getApplicationContext(), "Ad is closed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Toast.makeText(getApplicationContext(), "Ad failed to load! error code: " + errorCode, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLeftApplication() {
                Toast.makeText(getApplicationContext(), "Ad left application!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }
        });

        googleAdd.loadAd(adRequest);
    }
}
