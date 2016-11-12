package com.jasrsir.tracing.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jasrsir.tracing.R;

public class LoginMain_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
    }

    /**
     * Method onClick in TextView for start:
     *  - Sign In Activity
     *  - Selector UserPojo Activity
     * @param view Textview clicked
     */
    public void onClickRegister(View view) {
        Intent intent;

        if (view.getId() == R.id.txvYesAccount)
            intent = new Intent(LoginMain_Activity.this, SignIn_Activity.class);
        else //if (view.getId() == R.id.txvNoAccount)
            intent = new Intent(LoginMain_Activity.this, SelectorUser_Activity.class);


        startActivity(intent);
    }
}
