package com.jasrsir.tracing.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.preferences.AccountPreferences;

public class SignIn_Activity extends AppCompatActivity {


    private EditText mEdtMail;
    private EditText mEdtPass;
    private CheckBox mCkbRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getWidgets();
        setAccountPreferences();

    }

    /**
     * inflate variables with views
     */
    private void getWidgets() {
        mEdtMail = (EditText) findViewById(R.id.edtEmail);
        mEdtPass = (EditText) findViewById(R.id.edtPassword);
        mCkbRemember = (CheckBox) findViewById(R.id.ckbRemember);
    }

    /**
     * set user preferences if sign up first
     */
    private void setAccountPreferences() {
        if (AccountPreferences.accountPreference != null) {
            mEdtMail.setText(AccountPreferences.accountPreference.getKeyUserEmail());
            mEdtPass.setText(AccountPreferences.accountPreference.getKeyUserPass());
            mCkbRemember.setChecked(AccountPreferences.accountPreference.getKeyUserRemember());
        }
    }


    /**
     * Method that Log in the user or launch (Lost Unique Code)
     *
     * @param view Widget clicked
     */
    public void onClickLogin_LostUC(View view) {
        Intent intent;
        if (view.getId() == R.id.btnLogin) {
            //Validar los datos
            if (AccountPreferences.accountPreference != null)
                AccountPreferences.accountPreference.setKeyUserRemember(mCkbRemember.isChecked());
            intent = new Intent(SignIn_Activity.this, Wall_Activity.class);

        } else //if (view.getId() == R.id.txvLostUC){
            intent = new Intent(SignIn_Activity.this, SignLost_Activity.class);

        startActivity(intent);
    }
}
