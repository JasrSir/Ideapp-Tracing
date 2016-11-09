package com.jasrsir.tracing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectorUser_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector_user);
    }

    /**
     * Method that Log in the user or launch (Lost Unique Code)
     * @param view Widget clicked
     */
    public void onClickSelectAccount (View view) {
        Intent intent;
        if (view.getId() == R.id.btnLogin) {
            intent = new Intent(SelectorUser_Activity.this, SelectorUser_Activity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.txvLostUC){
            intent = new Intent(SelectorUser_Activity.this, LoginAccount_Activity.class);
            startActivity(intent);
        }
    }
}
