package com.jasrsir.tracing.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.viewlistRecicler.ListView_Activity;
import com.jasrsir.tracing.viewlistRecicler.RecyclerView_Activity;

public class Wall_Activity extends Activity {

    static Bundle bundleEvent;
    private Toolbar toolbar;
    private FrameLayout parentWall;
    private BottomNavigationView mBNVmenu;
    private FloatingActionButton mFabAdd;
    private CoordinatorLayout mCoordLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall);

        toolbar = (Toolbar) findViewById(R.id.toolBarWall);
        setActionBar(toolbar);
        parentWall = (FrameLayout) findViewById(R.id.frameLayoutWall);
        mCoordLay = (CoordinatorLayout) findViewById(R.id.activity_wall);
        mFabAdd = (FloatingActionButton) findViewById(R.id.fabAddWall);
        mBNVmenu = (BottomNavigationView) findViewById(R.id.bnvMenuWall);

       mBNVmenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bnvWallAction:
                        break;
                    case R.id.bnvWallAnotation:
                        break;
                    case R.id.bnvWallDate:
                        break;
                    case R.id.bnvWallLink:
                        break;
                    default:
                        break;
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
                switch (mBNVmenu.findFocus().getId()) {
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

                startActivity(new Intent(Wall_Activity.this, NewEvent_Activity.class).putExtras(bundleEvent));

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_navigation_drawer,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {

        switch (item.getItemId()) {
            case R.id.ndAbout:
                startActivity(new Intent(Wall_Activity.this, About_Activity.class));
                break;
            case R.id.ndProfile:
                startActivity(new Intent(Wall_Activity.this, SignUp_Activity.class));
                break;
            case R.id.ndSettings:
                startActivity(new Intent(Wall_Activity.this, SettingsActivity.class));
                break;
            default:
                break;

            /*case R.id.:
                intent = new Intent(Wall_Activity.this, About_Activity.class);
                break;
            case R.id.btnPruebaPrefModPerf:
                intent = new Intent(Wall_Activity.this, RecyclerView_Activity.class);
                break;*/
        }

        return super.onMenuItemSelected(featureId, item);
    }

}
