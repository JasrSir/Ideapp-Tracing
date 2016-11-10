package com.jasrsir.tracing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SignUp_Activity extends AppCompatActivity {

    private Intent mIntent;
    private Bundle mBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mIntent = this.getIntent();
        mBundle = mIntent.getExtras();

    }

    private void actualizar() {

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
