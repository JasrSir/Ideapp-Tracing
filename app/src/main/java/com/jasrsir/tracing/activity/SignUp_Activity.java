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
    public static AccountPreferences mAccountPreferences;
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
        if (mAccountPreferences == null)
            mAccountPreferences = AccountPreferences.getInstance(getApplicationContext());
        else
            loadUserData();
        putSpecialData();
    }

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

        switch (SelectorUser_Activity.bundleAccount.getString("ACCOUNT")) {
            case "business":
                mImgProfession.setVisibility(View.VISIBLE);
                mTilProfession.setVisibility(View.VISIBLE);
                mImgAdress.setVisibility(View.VISIBLE);
                mTilAdress.setVisibility(View.VISIBLE);
                mTilCif.setVisibility(View.VISIBLE);
                mImgCif.setVisibility(View.VISIBLE);
                //Falta area prof
                break;
            case "professional":
                mImgProfession.setVisibility(View.VISIBLE);
                mTilProfession.setVisibility(View.VISIBLE);
                //fata area prof
                break;
            case "user":
                //all OK
                break;
        }
    }

    /**
     * Save new user preferences and create correct user
     * @param view only has 1 button
     */
    public void onClickSignUp(View view){
        mAccountPreferences.setKeyUserName(mEdtName.getText().toString());
        mAccountPreferences.setKeyUserSurname(mEdtSurname.getText().toString());
        mAccountPreferences.setKeyUserEmail(mEdtEmail.getText().toString());
        mAccountPreferences.setKeyUserPhone(mEdtPhone.getText().toString());
        mAccountPreferences.setKeyUserPass(mEdtPass.getText().toString());
        mAccountPreferences.setKeyUserUniquecode("CODEPRUEBA");
        mAccountPreferences.setKeyUserRemember(true);

        switch (SelectorUser_Activity.bundleAccount.getString("ACCOUNT")) {

            case "business":
                mAccountPreferences.setKeyUserProfession(mEdtProfession.getText().toString());
                mAccountPreferences.setKeyBusinessAdress(mEdtAdress.getText().toString());
                mAccountPreferences.setKeyBusinessCif(mEdtCif.getText().toString());
                mAccountPreferences.setKeyUserZone("NULA");
                if (mUser == null)
                    mUser = new Business(mAccountPreferences.getKeyUserUniquecode(),
                            mAccountPreferences.getKeyUserName(),
                            mAccountPreferences.getKeyUserSurname(),
                            mAccountPreferences.getKeyUserEmail(),
                            mAccountPreferences.getKeyUserPass(),
                            mAccountPreferences.getKeyUserPhone(),
                            mAccountPreferences.getKeyUserName(),
                            mAccountPreferences.getKeyUserProfession(),
                            mAccountPreferences.getKeyBusinessAdress(),
                            mAccountPreferences.getKeyBusinessCif(),
                            mAccountPreferences.getKeyUserZone());
                else {
                    mUser.setName(mAccountPreferences.getKeyUserName());
                    mUser.setSurname(mAccountPreferences.getKeyUserSurname());
                    mUser.setEmail(mAccountPreferences.getKeyUserEmail());
                    mUser.setPassword(mAccountPreferences.getKeyUserPass());
                    mUser.setPhone(mAccountPreferences.getKeyUserPhone());
                    ((Business)mUser).setNameBusiness(mAccountPreferences.getKeyUserName());
                    ((Business)mUser).setProfession(mAccountPreferences.getKeyUserProfession());
                    ((Business)mUser).setAdress(mAccountPreferences.getKeyBusinessAdress());
                    ((Business)mUser).setCif(mAccountPreferences.getKeyBusinessCif());
                    ((Business)mUser).setZone(mAccountPreferences.getKeyUserZone());
                }
                break;

            case "professional":
                mAccountPreferences.setKeyUserProfession(mEdtProfession.getText().toString());
                mAccountPreferences.setKeyUserZone("NULA");
                if (mUser == null)
                    mUser = new Professional(mAccountPreferences.getKeyUserUniquecode(),
                            mAccountPreferences.getKeyUserName(),
                            mAccountPreferences.getKeyUserSurname(),
                            mAccountPreferences.getKeyUserEmail(),
                            mAccountPreferences.getKeyUserPass(),
                            mAccountPreferences.getKeyUserPhone(),
                            mAccountPreferences.getKeyUserProfession(),
                            mAccountPreferences.getKeyUserZone());
                else {
                    mUser.setName(mAccountPreferences.getKeyUserName());
                    mUser.setSurname(mAccountPreferences.getKeyUserSurname());
                    mUser.setEmail(mAccountPreferences.getKeyUserEmail());
                    mUser.setPassword(mAccountPreferences.getKeyUserPass());
                    mUser.setPhone(mAccountPreferences.getKeyUserPhone());
                    ((Professional)mUser).setProfession(mAccountPreferences.getKeyUserProfession());
                    ((Professional)mUser).setZone(mAccountPreferences.getKeyUserZone());
                }
                break;

            case "user":
                if (mUser == null)
                    mUser = new User(mAccountPreferences.getKeyUserUniquecode(),
                            mAccountPreferences.getKeyUserName(),
                            mAccountPreferences.getKeyUserSurname(),
                            mAccountPreferences.getKeyUserEmail(),
                            mAccountPreferences.getKeyUserPass(),
                            mAccountPreferences.getKeyUserPhone());
                else {
                    mUser.setName(mAccountPreferences.getKeyUserName());
                    mUser.setSurname(mAccountPreferences.getKeyUserSurname());
                    mUser.setEmail(mAccountPreferences.getKeyUserEmail());
                    mUser.setPassword(mAccountPreferences.getKeyUserPass());
                    mUser.setPhone(mAccountPreferences.getKeyUserPhone());
                }
                break;
        }

        finish();
    }
    //endregion

}
