package com.jasrsir.tracing.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.viewlistRecicler.ListView_Activity;
import com.jasrsir.tracing.viewlistRecicler.RecyclerView_Activity;

public class Wall_Activity extends Activity {

    static Bundle bundleEvent;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall);
        toolbar = (Toolbar) findViewById(R.id.toolBarWall);
        toolbar.setTitleTextColor(getResources().getColor(R.color.cardview_light_background));
        setActionBar(toolbar);

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

            /*case R.id.:
                intent = new Intent(Wall_Activity.this, About_Activity.class);
                break;
            case R.id.btnPruebaPrefModPerf:
                intent = new Intent(Wall_Activity.this, RecyclerView_Activity.class);
                break;*/
        }
        return super.onMenuItemSelected(featureId, item);
    }



    /**
     * Method that iniciate a new event
     * @param view

    public void OnClickWall(View view) {
        Intent intent;
        bundleEvent = new Bundle();
        switch (view.getId()){
            case R.id.fabWallDate:
                bundleEvent.putString("EVENT", "date");
                break;
            case R.id.fabWallAction:
                bundleEvent.putString("EVENT", "action");
                break;
            case R.id.fabWallLink:
                bundleEvent.putString("EVENT", "link");
                break;
            case R.id.fabWallPost:
                bundleEvent.putString("EVENT", "post");
                break;
        }
        intent = new Intent(Wall_Activity.this, NewEvent_Activity.class);
        intent.putExtras(bundleEvent);
        startActivity(intent);

    }     */
}
