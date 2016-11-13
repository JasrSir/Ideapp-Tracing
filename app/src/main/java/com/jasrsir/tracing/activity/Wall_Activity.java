package com.jasrsir.tracing.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jasrsir.tracing.R;

public class Wall_Activity extends AppCompatActivity {

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
                intent = new Intent(Wall_Activity.this, About_Activity.class);
                break;
            case R.id.btnPruebaRecyclerView:
                intent = new Intent(Wall_Activity.this, About_Activity.class);
                break;
            case R.id.btnPruebaSettings:
                intent = new Intent(Wall_Activity.this, About_Activity.class);
                break;
            case R.id.btnPruebaAbout:
                intent = new Intent(Wall_Activity.this, About_Activity.class);
                break;
        }
        startActivity(intent);
    }
}
