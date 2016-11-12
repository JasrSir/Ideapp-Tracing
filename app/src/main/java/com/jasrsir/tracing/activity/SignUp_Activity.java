package com.jasrsir.tracing.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.pojo.User;
import com.jasrsir.tracing.preferences.AccountPreferences;

public class SignUp_Activity extends AppCompatActivity {

    //region variables
    private AccountPreferences mAccountPreferences;

    private Intent mIntent;
    private Bundle mBundle;
    public User mUser;

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
        mAccountPreferences = AccountPreferences.getInstance(getApplicationContext());
        getWidgets();
        putSpecialData();
    }

    //region functions

    /**
     * inflate variables with views
     */
    public void getWidgets() {
        mEdtName = (EditText) findViewById(R.id.edtUSignUpName);
        mEdtSurname = (EditText) findViewById(R.id.edtSignUpSurname);
        mEdtPass = (EditText) findViewById(R.id.edtSignUpPass);
        mEdtEmail = (EditText) findViewById(R.id.edtSignUpMail);
        mEdtPhone = (EditText) findViewById(R.id.edtSignUpPhone);
        mEdtAdress = (EditText) findViewById(R.id.edtSignUpAdress);
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

    public void onClickSignUp(View view){
        mAccountPreferences.setKeyUserName(mEdtName.getText().toString());
        mAccountPreferences.setKeyUserSurname(mEdtSurname.getText().toString());
        mAccountPreferences.setKeyUserEmail(mEdtEmail.getText().toString());
        mAccountPreferences.setKeyUserPhone(mEdtPhone.getText().toString());
        mAccountPreferences.setKeyUserPass(mEdtPass.getText().toString());
        mAccountPreferences.setKeyUserUniquecode("CODEPRUEBA");
        mUser = new User(mAccountPreferences.getKeyUserUniquecode(),
                mAccountPreferences.getKeyUserName(),
                mAccountPreferences.getKeyUserSurname(),
                mAccountPreferences.getKeyUserEmail(),
                mAccountPreferences.getKeyUserPass(),
                mAccountPreferences.getKeyUserPhone());

        finish();
    }
    //endregion

}
