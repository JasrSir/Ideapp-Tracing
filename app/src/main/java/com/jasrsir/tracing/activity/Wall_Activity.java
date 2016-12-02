package com.jasrsir.tracing.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.viewlistRecicler.ListView_Activity;
import com.jasrsir.tracing.viewlistRecicler.RecyclerView_Activity;

public class Wall_Activity extends AppCompatActivity {

    static Bundle bundleEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall);
    }

    //Metodo de prueba a eliminar posteriormente
    public void onClickPrueba(View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.btnPruebaListView:
                intent = new Intent(Wall_Activity.this, ListView_Activity.class);
                break;
            case R.id.btnPruebaRecyclerView:
                intent = new Intent(Wall_Activity.this, RecyclerView_Activity.class);
                break;
            case R.id.btnPruebaSettings:
                Snackbar.make(view,"Caraterística NO disponible",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.btnPruebaAbout:
                intent = new Intent(Wall_Activity.this, About_Activity.class);
                break;
            case R.id.btnPruebaPrefModPerf:
                intent = new Intent(Wall_Activity.this, SignUp_Activity.class);
                break;
        }
        startActivity(intent);
    }

    /**
     * Method that iniciate a new event
     * @param view
     */
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

    }
}
