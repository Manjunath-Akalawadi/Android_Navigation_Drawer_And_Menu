package com.demo.manju.nav_drawer;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){

            case R.id.action_settings:
                Toast.makeText(this," Settings ",Toast.LENGTH_LONG).show();
                break;

            case R.id.action_help:
                Toast.makeText(this," Help ",Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void selectScreen(int i){

        Fragment fragment = null;

        switch (i){

            case R.id.nav_camera:
                fragment = new Camera();
                break;

            case R.id.nav_gallery:
                fragment = new Gallery();
                break;

            case R.id.nav_slideshow:
                fragment = new SlideShow();
                break;

            case R.id.nav_manage:
                fragment = new Manage();
                break;

            case R.id.nav_share:
                Toast.makeText(this," Share ",Toast.LENGTH_LONG).show();
                break;

            case R.id.nav_send:
                Toast.makeText(this," Send ",Toast.LENGTH_LONG).show();
                break;



        }

        if (fragment != null){

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, fragment);
            fragmentTransaction.commit();
        }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        selectScreen(id);

        return true;
    }
}
