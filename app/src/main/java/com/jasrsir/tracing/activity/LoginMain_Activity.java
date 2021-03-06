package com.jasrsir.tracing.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.preferences.AccountPreferences;

public class LoginMain_Activity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        AccountPreferences.accountPreference = AccountPreferences.getInstance(getApplicationContext());
        //mAccountPreferences = AccountPreferences.getInstance(getApplicationContext());
        //if (mAccountPreferences != null && mAccountPreferences.getKeyUserRemember()) {
            //intent = new Intent(LoginMain_Activity.this, Wall_Activity.class);
            //startActivity(intent);
            //finish();
        //}else{

            //setContentView(R.layout.activity_login_main);
       // }
    }

    /**
     * Method onClick in TextView for start:
     *  - Sign In Activity
     *  - Selector UserPojo Activity
     * @param view Textview clicked
     */
    public void onClickRegister(View view) {


        if (view.getId() == R.id.txvYesAccount)
            intent = new Intent(LoginMain_Activity.this, SignIn_Activity.class);
        else {//if (view.getId() == R.id.txvNoAccount)
            intent = new Intent(LoginMain_Activity.this, SelectorUser_Activity.class);

        }
        startActivity(intent);
    }
}
