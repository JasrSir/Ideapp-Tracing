package com.jasrsir.tracing.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.preferences.AccountPreferences;

public class SignLost_Activity extends AppCompatActivity {

    private AccountPreferences mAccountPreferences;
    private EditText mEdtSignLostPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_lost);
        getWidgets();
        setAccountPreferences();
    }

    //region functions
    /**
     * inflate variables with views
     */
    private void getWidgets() {
        mEdtSignLostPass = (EditText) findViewById(R.id.edtSignLostPassword);
    }

    /**
     * set user preferences if sign up first
     */
    private void setAccountPreferences() {
        mAccountPreferences = AccountPreferences.getInstance(getApplicationContext());
        if (mAccountPreferences.getKeyUserEmail() != null) {
            mEdtSignLostPass.setText(mAccountPreferences.getKeyUserEmail());
        }
    }

    public void onClickSignLostPassword(View view) {

    }
    //endregion
}
