package com.jasrsir.tracing.activity;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.pojo.Business;
import com.jasrsir.tracing.pojo.Professional;
import com.jasrsir.tracing.pojo.User;
import com.jasrsir.tracing.pojo.UserPojo;
import com.jasrsir.tracing.preferences.AccountPreferences;

public class SignUp_Activity extends AppCompatActivity {

    //region variables
    public static UserPojo mUser;

    private EditText mEdtName;
    private EditText mEdtSurname;
    private EditText mEdtEmail;
    private EditText mEdtPhone;
    private EditText mEdtPass;

    private TextInputLayout mTilCif;
    private EditText mEdtCif;
    private ImageView mImgCif;
    private TextInputLayout mTilAdress;
    private EditText mEdtAdress;
    private ImageView mImgAdress;

    //private EditText mEdtZone;
    //private ImageView mImgZone;
    private TextInputLayout mTilProfession;
    private EditText mEdtProfession;
    private ImageView mImgProfession;

    private Button mBtnSaveChanges;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWidgets();
        if (AccountPreferences.accountPreference == null)
            AccountPreferences.accountPreference = AccountPreferences.getInstance(getApplicationContext());
        else if (mUser != null)
            loadUserData();

        putSpecialData();
    }

    //region functions
    /**
     * Load user data for changes
     */
    private void loadUserData() {

        mBtnSaveChanges = (Button) findViewById(R.id.btnSignUpRegister);
        mBtnSaveChanges.setText(R.string.textSaveChanges);
        mEdtName.setText(mUser.getName());
        mEdtSurname.setText(mUser.getSurname());
        mEdtEmail.setText(mUser.getEmail());
        mEdtPhone.setText(mUser.getPhone());
        mEdtPass.setText(mUser.getPassword());
        if (SelectorUser_Activity.bundleAccount.getString("ACCOUNT").equals("business")){
            mEdtCif.setText(((Business)mUser).getCif());
            mEdtAdress.setText(((Business)mUser).getAdress());
            mEdtProfession.setText(((Business)mUser).getProfession());
            //Falta zona
        } else if (SelectorUser_Activity.bundleAccount.getString("ACCOUNT").equals("professional")){
            mEdtProfession.setText(((Professional)mUser).getProfession());
            //Falta zona
        }
    }

    /**
     * inflate variables with views
     */
    public void getWidgets() {
        mEdtName = (EditText) findViewById(R.id.edtUSignUpName);
        mEdtSurname = (EditText) findViewById(R.id.edtSignUpSurname);
        mEdtPass = (EditText) findViewById(R.id.edtSignUpPass);
        mEdtEmail = (EditText) findViewById(R.id.edtSignUpMail);
        mEdtPhone = (EditText) findViewById(R.id.edtSignUpPhone);
        mTilAdress = (TextInputLayout) findViewById(R.id.tilSignUpAdress);
        mEdtAdress = (EditText) findViewById(R.id.edtSignUpAdress);
        mImgAdress = (ImageView) findViewById(R.id.imgSignUpAdress);
        mTilProfession = (TextInputLayout) findViewById(R.id.tilSignUpWork);
        mEdtProfession = (EditText) findViewById(R.id.edtSignUpWork);
        mImgProfession = (ImageView) findViewById(R.id.imgSignUpWork);
        mTilCif = (TextInputLayout) findViewById(R.id.tilSignUpCif);
        mEdtCif = (EditText) findViewById(R.id.edtSignUpCif);
        mImgCif = (ImageView) findViewById(R.id.imgSignUpCif);


    }
    /**
     * Method to show different data in different users
     */
    private void putSpecialData() {

        if ( SelectorUser_Activity.bundleAccount.getString("ACCOUNT") == "business") {
            mImgProfession.setVisibility(View.VISIBLE);
            mTilProfession.setVisibility(View.VISIBLE);
            mImgAdress.setVisibility(View.VISIBLE);
            mTilAdress.setVisibility(View.VISIBLE);
            mTilCif.setVisibility(View.VISIBLE);
            mImgCif.setVisibility(View.VISIBLE);
            //Falta area prof
        } else if ( SelectorUser_Activity.bundleAccount.getString("ACCOUNT") == "professional") {
            mImgProfession.setVisibility(View.VISIBLE);
            mTilProfession.setVisibility(View.VISIBLE);
            //fata area prof
        }// User all ok

    }

    /**
     * Save new user preferences and create correct user
     * @param view only has 1 button
     */
    public void onClickSignUp(View view){
        setAccountPreferences(SelectorUser_Activity.bundleAccount.getString("ACCOUNT"));

        if (mUser == null)
            createUser(SelectorUser_Activity.bundleAccount.getString("ACCOUNT"));
        else
            modifyUser(SelectorUser_Activity.bundleAccount.getString("ACCOUNT"));

        finish();
    }

    /**
     * Create a new type user
     * @param usertype User, Professional or Business
     */
    private void createUser(String usertype) {
        switch (usertype) {
            case "user":
                mUser = new User(AccountPreferences.accountPreference.getKeyUserUniquecode(),
                        AccountPreferences.accountPreference.getKeyUserName(),
                        AccountPreferences.accountPreference.getKeyUserSurname(),
                        AccountPreferences.accountPreference.getKeyUserEmail(),
                        AccountPreferences.accountPreference.getKeyUserPass(),
                        AccountPreferences.accountPreference.getKeyUserPhone());
                break;
            case "professional":
                mUser = new Professional(AccountPreferences.accountPreference.getKeyUserUniquecode(),
                        AccountPreferences.accountPreference.getKeyUserName(),
                        AccountPreferences.accountPreference.getKeyUserSurname(),
                        AccountPreferences.accountPreference.getKeyUserEmail(),
                        AccountPreferences.accountPreference.getKeyUserPass(),
                        AccountPreferences.accountPreference.getKeyUserPhone(),
                        AccountPreferences.accountPreference.getKeyUserProfession(),
                        AccountPreferences.accountPreference.getKeyUserZone());
                break;
            case "business":
                mUser = new Business(AccountPreferences.accountPreference.getKeyUserUniquecode(),
                        AccountPreferences.accountPreference.getKeyUserName(),
                        AccountPreferences.accountPreference.getKeyUserSurname(),
                        AccountPreferences.accountPreference.getKeyUserEmail(),
                        AccountPreferences.accountPreference.getKeyUserPass(),
                        AccountPreferences.accountPreference.getKeyUserPhone(),
                        AccountPreferences.accountPreference.getKeyUserName(),
                        AccountPreferences.accountPreference.getKeyUserProfession(),
                        AccountPreferences.accountPreference.getKeyBusinessAdress(),
                        AccountPreferences.accountPreference.getKeyBusinessCif(),
                        AccountPreferences.accountPreference.getKeyUserZone());
                break;
        }
    }

    /**
     * Modify a user
     * @param usertype User, Professional or Business
     */
    private void modifyUser(String usertype) {
        switch (usertype) {
            case "user":
                mUser.setName(AccountPreferences.accountPreference.getKeyUserName());
                mUser.setSurname(AccountPreferences.accountPreference.getKeyUserSurname());
                mUser.setEmail(AccountPreferences.accountPreference.getKeyUserEmail());
                mUser.setPassword(AccountPreferences.accountPreference.getKeyUserPass());
                mUser.setPhone(AccountPreferences.accountPreference.getKeyUserPhone());
                break;
            case "professional":
                mUser.setName(AccountPreferences.accountPreference.getKeyUserName());
                mUser.setSurname(AccountPreferences.accountPreference.getKeyUserSurname());
                mUser.setEmail(AccountPreferences.accountPreference.getKeyUserEmail());
                mUser.setPassword(AccountPreferences.accountPreference.getKeyUserPass());
                mUser.setPhone(AccountPreferences.accountPreference.getKeyUserPhone());
                ((Professional)mUser).setProfession(AccountPreferences.accountPreference.getKeyUserProfession());
                ((Professional)mUser).setZone(AccountPreferences.accountPreference.getKeyUserZone());
                break;
            case "business":
                mUser.setName(AccountPreferences.accountPreference.getKeyUserName());
                mUser.setSurname(AccountPreferences.accountPreference.getKeyUserSurname());
                mUser.setEmail(AccountPreferences.accountPreference.getKeyUserEmail());
                mUser.setPassword(AccountPreferences.accountPreference.getKeyUserPass());
                mUser.setPhone(AccountPreferences.accountPreference.getKeyUserPhone());
                ((Business)mUser).setNameBusiness(AccountPreferences.accountPreference.getKeyUserName());
                ((Business)mUser).setProfession(AccountPreferences.accountPreference.getKeyUserProfession());
                ((Business)mUser).setAdress(AccountPreferences.accountPreference.getKeyBusinessAdress());
                ((Business)mUser).setCif(AccountPreferences.accountPreference.getKeyBusinessCif());
                ((Business)mUser).setZone(AccountPreferences.accountPreference.getKeyUserZone());
                break;
        }
    }

    /**
     * Set account preferences in file
     * @param usertype User, Professional or Business
     */
    private void setAccountPreferences(String usertype) {
        AccountPreferences.accountPreference.setKeyUserName(mEdtName.getText().toString());
        AccountPreferences.accountPreference.setKeyUserSurname(mEdtSurname.getText().toString());
        AccountPreferences.accountPreference.setKeyUserEmail(mEdtEmail.getText().toString());
        AccountPreferences.accountPreference.setKeyUserPhone(mEdtPhone.getText().toString());
        AccountPreferences.accountPreference.setKeyUserPass(mEdtPass.getText().toString());
        AccountPreferences.accountPreference.setKeyUserUniquecode("CODEPRUEBA");
        AccountPreferences.accountPreference.setKeyUserRemember(false);

        switch (usertype) {

            case "business":
                AccountPreferences.accountPreference.setKeyUserProfession(mEdtProfession.getText().toString());
                AccountPreferences.accountPreference.setKeyBusinessAdress(mEdtAdress.getText().toString());
                AccountPreferences.accountPreference.setKeyBusinessCif(mEdtCif.getText().toString());
                AccountPreferences.accountPreference.setKeyUserZone("NULA");
                break;

            case "professional":
                AccountPreferences.accountPreference.setKeyUserProfession(mEdtProfession.getText().toString());
                AccountPreferences.accountPreference.setKeyUserZone("NULA");
                break;
        }
    }
    //endregion

}
