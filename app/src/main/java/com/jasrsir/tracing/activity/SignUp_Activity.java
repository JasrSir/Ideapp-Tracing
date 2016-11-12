package com.jasrsir.tracing.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.jasrsir.tracing.R;

public class SignUp_Activity extends AppCompatActivity {

    //region variables
    private Intent mIntent;
    private Bundle mBundle;

    private EditText mEdtName;
    private EditText mEdtSurname;
    private EditText mEdtEmail;
    private EditText mEdtPhone;
    private EditText mEdtPass;

    private EditText mEdtCif;
    private EditText mEdtAdress;
    //private EditText mEdtZone;
    private EditText mEdtProfession;

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWidgets();
        putSpecialData();
    }

    //region functions

    /**
     * inflate variables with views
     */
    public void getWidgets() {
        mEdtName = (EditText) findViewById(R.id.edtUSignUpName);
    }
    /**
     * Method to show different data in different users
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


    //endregion

}
