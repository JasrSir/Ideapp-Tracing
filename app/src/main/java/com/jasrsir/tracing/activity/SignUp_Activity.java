package com.jasrsir.tracing.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.interfaces.IValidateAccount;
import com.jasrsir.tracing.interfaces.IValidateUser;
import com.jasrsir.tracing.pojo.Business;
import com.jasrsir.tracing.pojo.Error;
import com.jasrsir.tracing.pojo.Professional;
import com.jasrsir.tracing.pojo.User;
import com.jasrsir.tracing.pojo.UserPojo;
import com.jasrsir.tracing.preferences.AccountPreferences;
import com.jasrsir.tracing.presenter.SignUp_Presenter;

public class SignUp_Activity extends AppCompatActivity implements IValidateAccount.View {

    //region variables
    public static UserPojo mUser;
    private SignUp_Presenter mPresenter;

    //Common variables
    private TextInputLayout mTilName;
    private EditText mEdtName;
    private TextInputLayout mTilSurname;
    private EditText mEdtSurname;
    private TextInputLayout mTilEmail;
    private EditText mEdtEmail;
    private TextInputLayout mTilPhone;
    private EditText mEdtPhone;
    private TextInputLayout mTilPass;
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

    private FloatingActionButton mBtnSaveChanges;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mPresenter = new SignUp_Presenter(this);
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

        mBtnSaveChanges = (FloatingActionButton) findViewById(R.id.fabSignUp);
        mEdtName.setText(mUser.getName());
        mEdtSurname.setText(mUser.getSurname());
        mEdtEmail.setText(mUser.getEmail());
        mEdtPhone.setText(mUser.getPhone());
        mEdtPass.setText(mUser.getPassword());
        if (SelectorUser_Activity.bundleAccount.getString("ACCOUNT").equals("business")) {
            mEdtCif.setText(((Business) mUser).getCif());
            mEdtAdress.setText(((Business) mUser).getAdress());
            mEdtProfession.setText(((Business) mUser).getProfession());
            //Falta zona
        } else if (SelectorUser_Activity.bundleAccount.getString("ACCOUNT").equals("professional")) {
            mEdtProfession.setText(((Professional) mUser).getProfession());
            //Falta zona
        }
    }

    /**
     * inflate variables with views
     */
    public void getWidgets() {
        mTilName = (TextInputLayout) findViewById(R.id.tilSignUpName);
        mTilSurname = (TextInputLayout) findViewById(R.id.tilSignUpSurname);
        mTilPhone = (TextInputLayout) findViewById(R.id.tilSignUpPhone);
        mTilEmail = (TextInputLayout) findViewById(R.id.tilSignUpMail);
        mTilPass = (TextInputLayout) findViewById(R.id.tilSignUpPass);
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

        if (SelectorUser_Activity.bundleAccount.getString("ACCOUNT") == "business") {
            mImgProfession.setVisibility(View.VISIBLE);
            mTilProfession.setVisibility(View.VISIBLE);
            mImgAdress.setVisibility(View.VISIBLE);
            mTilAdress.setVisibility(View.VISIBLE);
            mTilCif.setVisibility(View.VISIBLE);
            mImgCif.setVisibility(View.VISIBLE);
            //Falta area prof
        } else if (SelectorUser_Activity.bundleAccount.getString("ACCOUNT") == "professional") {
            mImgProfession.setVisibility(View.VISIBLE);
            mTilProfession.setVisibility(View.VISIBLE);
            //fata area prof
        }// User all ok

    }

    /**
     * Save new user preferences and create correct user
     *
     * @param view only has 1 button
     */
    public void onClickSignUp(View view) {
        restartTils();
        if (setAccountPreferences(SelectorUser_Activity.bundleAccount.getString("ACCOUNT")) == Error.OK) {
            if (mUser == null)
                mPresenter.createUser(SelectorUser_Activity.bundleAccount.getString("ACCOUNT"));
            else
                mPresenter.modifyUser(SelectorUser_Activity.bundleAccount.getString("ACCOUNT"));

            finish();
        } else
            Snackbar.make(this.findViewById(R.id.tilSignUpName), "Datos erróneos", Snackbar.LENGTH_LONG).show();
    }

    private void restartTils() {
        mTilName.setError(null);
        mTilSurname.setError(null);
        mTilEmail.setError(null);
        mTilPhone.setError(null);
        mTilPass.setError(null);
        mTilCif.setError(null);
        mTilAdress.setError(null);
        mTilProfession.setError(null);
    }

    /**
     * Set account preferences in file
     *
     * @param usertype User, Professional or Business
     */
    private int setAccountPreferences(String usertype) {

        //Validamos todos los datos
        if (mPresenter.validateCredentialsName(mEdtName.getText().toString()) == Error.OK &&
                mPresenter.validateCredentialsSurname(mEdtSurname.getText().toString()) == Error.OK &&
                mPresenter.validateCredentialsEmail(mEdtEmail.getText().toString()) == Error.OK &&
                mPresenter.validateCredentialsPhone(mEdtPhone.getText().toString()) == Error.OK &&
                mPresenter.validateCredentialsPass(mEdtPass.getText().toString()) == Error.OK) {

            AccountPreferences.accountPreference.setKeyUserName(mEdtName.getText().toString());
            AccountPreferences.accountPreference.setKeyUserSurname(mEdtSurname.getText().toString());
            AccountPreferences.accountPreference.setKeyUserEmail(mEdtEmail.getText().toString());
            AccountPreferences.accountPreference.setKeyUserPhone(mEdtPhone.getText().toString());
            AccountPreferences.accountPreference.setKeyUserPass(mEdtPass.getText().toString());
            AccountPreferences.accountPreference.setKeyUserUniquecode("CODEPRUEBA");
            AccountPreferences.accountPreference.setKeyUserRemember(false);

            switch (usertype) {

                case "business":
                    if (mPresenter.validateCredentialsProfession(mEdtProfession.getText().toString()) == Error.OK &&
                            mPresenter.validateCredentialsAdress(mEdtAdress.getText().toString()) == Error.OK &&
                            mPresenter.validateCredentialsCif(mEdtCif.getText().toString()) == Error.OK) {

                        AccountPreferences.accountPreference.setKeyUserProfession(mEdtProfession.getText().toString());
                        AccountPreferences.accountPreference.setKeyBusinessAdress(mEdtAdress.getText().toString());
                        AccountPreferences.accountPreference.setKeyBusinessCif(mEdtCif.getText().toString());
                        AccountPreferences.accountPreference.setKeyUserZone("NULA");
                    } else
                        return -1;
                    break;

                case "professional":
                    if (mPresenter.validateCredentialsProfession(mEdtProfession.getText().toString()) == Error.OK) {
                        AccountPreferences.accountPreference.setKeyUserProfession(mEdtProfession.getText().toString());
                        AccountPreferences.accountPreference.setKeyUserZone("NULA");
                    } else
                        return -1;

                    break;
            }
            return Error.OK;
        } else
            return -1;


    }

    @Override
    public void setMessageError(String messageError, int idView) {
        String message = getResources().getString(getResources().getIdentifier(messageError, "string", getPackageName()));

        switch (idView) {
            case R.id.tilSignUpName:
                mTilName.setError(message);
                break;
            case R.id.tilSignUpSurname:
                mTilSurname.setError(message);
                break;
            case R.id.tilSignUpPhone:
                mTilPhone.setError(message);
                break;
            case R.id.tilSignUpPass:
                mTilPass.setError(message);
                break;
            case R.id.tilSignUpMail:
                mTilEmail.setError(message);
                break;
            case R.id.tilSignUpAdress:
                mTilAdress.setError(message);
                break;
            case R.id.tilSignUpCif:
                mTilCif.setError(message);
                break;
            case R.id.tilSignUpWork:
                mTilProfession.setError(message);
                break;
        }
    }

    //endregion

}
