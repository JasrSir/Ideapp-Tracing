package com.jasrsir.tracing.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jasrsir.tracing.R;

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
        Intent intent;
        Bundle bundle = new Bundle();

        if (view.getId() == R.id.cardAccountBusiness)
            bundle.putString("ACCOUNT", "business");
        else if (view.getId() == R.id.cardAccountProfessional)
            bundle.putString("ACCOUNT", "professional");
        else //if (view.getId() == R.id.cardAccountUser)
            bundle.putString("ACCOUNT", "user");

        intent = new Intent(SelectorUser_Activity.this, SignUp_Activity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
