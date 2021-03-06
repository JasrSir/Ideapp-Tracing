package com.jasrsir.tracing.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.fragments.AnotationFragment;
import com.jasrsir.tracing.fragments.DateFragment;
import com.jasrsir.tracing.fragments.LinkFragment;
import com.jasrsir.tracing.viewlistRecicler.ListView_Activity;
import com.jasrsir.tracing.viewlistRecicler.RecyclerView_Activity;

public class Wall_Activity extends Activity {

    static Bundle bundleEvent;
    private Toolbar toolbar;
    private FrameLayout parentWall;
    private BottomNavigationView mBNVmenu;
    private FloatingActionButton mFabAdd;
    private CoordinatorLayout mCoordLay;
    private MenuItem itemSelected;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    //fragments
    private DateFragment mDateFragment;
    private LinkFragment mLinkFragment;
    private AnotationFragment mAnotationFragment;
  //  private ActionFragment mActionFragment;
    private Fragment mFragmentBefore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_view);

        toolbar = (Toolbar) findViewById(R.id.toolBarWall);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout );
        setActionBar(toolbar);
        getActionBar().setHomeAsUpIndicator(R.mipmap.ic_barra_wall);//poner las 3 barras
        getActionBar().setDisplayHomeAsUpEnabled(true);
        setUpDrawerContent();
        actionBarDrawerToggle = setUpDrawerToogle();
        mDateFragment = DateFragment.newInstance(null, Wall_Activity.this);
        mAnotationFragment = AnotationFragment.newInstance(null, Wall_Activity.this);
        //mActionFragment = ActionFragment.newInstance(null, Wall_Activity.this);
        mLinkFragment = LinkFragment.newInstance(null, Wall_Activity.this);
        mFragmentBefore = mDateFragment;
        parentWall = (FrameLayout) findViewById(R.id.frameLayoutWall);
        mCoordLay = (CoordinatorLayout) findViewById(R.id.activity_wall);
        mFabAdd = (FloatingActionButton) findViewById(R.id.fabAddWall);
        mBNVmenu = (BottomNavigationView) findViewById(R.id.bnvMenuWall);

       mBNVmenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                itemSelected = item;
                toolbar.setTitle(itemSelected.getTitle());
                Fragment fragmentAfter = null;
                switch (item.getItemId()) {
                    case R.id.bnvWallAction:
                        //fragmentAfter = mActionFragment;
                        break;
                    case R.id.bnvWallAnotation:
                        fragmentAfter = mAnotationFragment;
                        //mAnotationFragment.showEvent();
                        break;
                    case R.id.bnvWallDate:
                        fragmentAfter = mDateFragment;
                        //mDateFragment.showEvent();
                        break;
                    case R.id.bnvWallLink:
                        fragmentAfter = mLinkFragment;
                        //mLinkFragment.showEvent();
                        break;
                    default:
                        break;
                }
                if (item.getItemId() != R.id.bnvWallAction) {
                    getFragmentManager().beginTransaction().replace(mFragmentBefore.getId(),fragmentAfter).commit();
                    mFragmentBefore = fragmentAfter;
                }

                return true;
            }
        });

        mFabAdd.setOnClickListener(new View.OnClickListener() {
            /**
             * Method that iniciate a new event
             * @param view
             */
            @Override
            public void onClick(View view) {
                bundleEvent = new Bundle();
                if (itemSelected != null) {
                    switch (itemSelected.getItemId()) {
                        case R.id.bnvWallAction:
                            bundleEvent.putString("EVENT", "action");
                            break;
                        case R.id.bnvWallAnotation:
                            bundleEvent.putString("EVENT", "post");
                            break;
                        case R.id.bnvWallDate:
                            bundleEvent.putString("EVENT", "date");
                            break;
                        case R.id.bnvWallLink:
                            bundleEvent.putString("EVENT", "link");
                            break;
                        default:
                            break;
                    }
                    //for resuLT
                    startActivity(new Intent(Wall_Activity.this, NewEvent_Activity.class).putExtras(bundleEvent));
                } else
                    Snackbar.make(mCoordLay,"No implementado aun", Snackbar.LENGTH_LONG);

            }
        });
        getFragmentManager().beginTransaction().replace(parentWall.getId(),mDateFragment).commit();
        mFragmentBefore = mDateFragment;


    }
    private ActionBarDrawerToggle setUpDrawerToogle() {
        return new ActionBarDrawerToggle(this, drawerLayout,R.string.drawer_open, R.string.drawer_close);
    }

    private void setUpDrawerContent() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                menuitem.setChecked(true);
                switch (menuitem.getItemId()) {
                    case R.id.ndAbout:
                        startActivity(new Intent(Wall_Activity.this, About_Activity.class));
                        break;
                    case R.id.ndProfile:
                        //startActivity(new Intent(Wall_Activity.this, SignUp_Activity.class));
                        break;
                    case R.id.ndSettings:
                        startActivity(new Intent(Wall_Activity.this, SettingsActivity.class));
                        break;
                    //case R.id.activity_list_product:
                    //  onListProductListener();
                    //y ya aki se le llaman a los listeners correspondientes.
                    //los listeners son los que cambian el content de la activity,
                    default:
                        menuitem.setChecked(true);
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                setTitle(menuitem.getTitle());
                return true;
            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.clear();
        getMenuInflater().inflate(R.menu.settings_navigation_drawer,menu);
        return true;
    }*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            //PONER ESTOI PARA CUANDO SE PULSA EL HOME
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;

            *//*case R.id.:
                intent = new Intent(Wall_Activity.this, About_Activity.class);
                break;
            case R.id.btnPruebaPrefModPerf:
                intent = new Intent(Wall_Activity.this, RecyclerView_Activity.class);
                break;*//*
        }

        return true;
    }*/

}
