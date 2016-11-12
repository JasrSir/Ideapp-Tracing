package com.jasrsir.tracing.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jasrsir.tracing.R;

public class SignIn_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

    }

    /**
     * Method that Log in the user or launch (Lost Unique Code)
     * @param view Widget clicked
     */
    /**  public void onClickLogin_LostUC (View view) {
       Intent intent;
        if (view.getId() == R.id.btnLogin)
            intent = new Intent(SignIn_Activity.this, SelectorUser_Activity.class);
        else //if (view.getId() == R.id.txvLostUC){
            intent = new Intent(SignIn_Activity.this, SignIn_Activity.class);

        startActivity(intent);
    }**/
}
