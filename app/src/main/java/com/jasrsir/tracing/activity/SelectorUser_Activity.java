package com.jasrsir.tracing.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.preferences.AccountPreferences;

public class SelectorUser_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector_user);
    }

    /**
     * Method onClick in CardView for start:
     *  - Sign Up Activity (user type)
     *  - Lost Password
     * @param view CardView clicked
     */
    public void onClickSelectAccount (View view) {

        if (view.getId() == R.id.cardAccountBusiness)
            AccountPreferences.accountPreference.setKeyUserType("business");
        else if (view.getId() == R.id.cardAccountProfessional)
            AccountPreferences.accountPreference.setKeyUserType("professional");
        else //if (view.getId() == R.id.cardAccountUser)
            AccountPreferences.accountPreference.setKeyUserType("user");

        startActivity(new Intent(SelectorUser_Activity.this, SignUp_Activity.class));
        finish();
    }
}
