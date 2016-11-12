package com.jasrsir.tracing.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jasrsir.tracing.R;

public class SignUp_Activity extends AppCompatActivity {

    //region variables
    private Intent mIntent;
    private Bundle mBundle;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    /**
     * Method to show different data  in different users
     */
    private void putSpecialData() {

        mIntent = this.getIntent();
        mBundle = mIntent.getExtras();

        switch (mBundle.getString("ACCOUNT")) {
            case "business":
                break;
            case "professional":
                break;
            case "user":
                break;
        }
    }

}
