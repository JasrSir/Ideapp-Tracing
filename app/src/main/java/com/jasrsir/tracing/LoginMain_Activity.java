package com.jasrsir.tracing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginMain_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
    }

    public void onClickRegister(View view) {
        Intent intent;
        if (view.getId() == R.id.cardAccountBusiness) {
            intent = new Intent(LoginMain_Activity.this, SelectorUser_Activity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.txvYesAccount){
            intent = new Intent(LoginMain_Activity.this, LoginAccount_Activity.class);
            startActivity(intent);
        }

    }
}
