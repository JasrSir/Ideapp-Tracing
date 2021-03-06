package com.jasrsir.tracing.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.interfaces.IValidateAccount;
import com.jasrsir.tracing.pojo.Business;
import com.jasrsir.tracing.pojo.Error;
import com.jasrsir.tracing.pojo.Professional;
import com.jasrsir.tracing.pojo.UserPojo;
import com.jasrsir.tracing.preferences.AccountPreferences;
import com.jasrsir.tracing.presenter.SignUp_Presenter;

public class SignUp_Activity extends AppCompatActivity implements IValidateAccount.View {

    //region Variables
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



    private static final int PERCENTAGE_TO_ANIMATE_AVATAR = 20;
    private boolean mIsAvatarShown = true;

    private ImageView mProfileImage;
    private int mMaxScrollSize;
    //endregion

    //region Functions

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mPresenter = new SignUp_Presenter(this);
        getWidgets();
        if (AccountPreferences.accountPreference == null)
            AccountPreferences.accountPreference = AccountPreferences.getInstance(getApplicationContext());
        else
            loadUserData();

        putSpecialData();
    }

    /**
     * Load user data for changes
     */
    private void loadUserData() {

        mBtnSaveChanges = (FloatingActionButton) findViewById(R.id.fabSignUp);
        mEdtName.setText(AccountPreferences.accountPreference.getKeyUserName());
        mEdtSurname.setText(AccountPreferences.accountPreference.getKeyUserSurname());
        mEdtEmail.setText(AccountPreferences.accountPreference.getKeyUserEmail());
        mEdtPhone.setText(AccountPreferences.accountPreference.getKeyUserPhone());
        mEdtPass.setText(AccountPreferences.accountPreference.getKeyUserPass());
        if (AccountPreferences.accountPreference.getKeyUserType().equals("business")) {
            mEdtCif.setText(AccountPreferences.accountPreference.getKeyBusinessCif());
            mEdtAdress.setText(AccountPreferences.accountPreference.getKeyBusinessAdress());
            mEdtProfession.setText( AccountPreferences.accountPreference.getKeyUserProfession());
            //Falta zona
        } else if (AccountPreferences.accountPreference.getKeyUserType().equals("professional")) {
            mEdtProfession.setText( AccountPreferences.accountPreference.getKeyUserProfession());
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



        AppBarLayout appbarLayout = (AppBarLayout) findViewById(R.id.materialup_appbar);
        mProfileImage = (ImageView) findViewById(R.id.materialup_profile_image);

        Toolbar toolbar = (Toolbar) findViewById(R.id.materialup_toolbar);
        toolbar.setTitle(R.string.modifyProfile);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                onBackPressed();
            }
        });

        appbarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (mMaxScrollSize == 0)
                    mMaxScrollSize = appBarLayout.getTotalScrollRange();

                int percentage = (Math.abs(verticalOffset)) * 100 / mMaxScrollSize;

                if (percentage >= PERCENTAGE_TO_ANIMATE_AVATAR && mIsAvatarShown) {
                    mIsAvatarShown = false;
                    mProfileImage.animate().scaleY(0).scaleX(0).setDuration(200).start();
                }

                if (percentage <= PERCENTAGE_TO_ANIMATE_AVATAR && !mIsAvatarShown) {
                    mIsAvatarShown = true;

                    mProfileImage.animate()
                            .scaleY(1).scaleX(1)
                            .start();
                }
            }
        });
        mMaxScrollSize = appbarLayout.getTotalScrollRange();


    }

    public static void start(Context c) {
        c.startActivity(new Intent(c, SignUp_Activity.class));
    }
    /**
     * Method to show different data in different users
     */
    private void putSpecialData() {

        if (AccountPreferences.accountPreference.getKeyUserType().equals("business")) {
            mImgProfession.setVisibility(View.VISIBLE);
            mTilProfession.setVisibility(View.VISIBLE);
            mImgAdress.setVisibility(View.VISIBLE);
            mTilAdress.setVisibility(View.VISIBLE);
            mTilCif.setVisibility(View.VISIBLE);
            mImgCif.setVisibility(View.VISIBLE);
            //Falta area prof
        } else if (AccountPreferences.accountPreference.getKeyUserType().equals("professional")) {
            mImgProfession.setVisibility(View.VISIBLE);
            mTilProfession.setVisibility(View.VISIBLE);
            //fata area prof
        }// User all ok

    }

    /**
     * Save new user preferences and create correct user
     * @param view only has 1 button
     */
    public void onClickSignUp(View view) {
        restartTils();
        if (setAccountPreferences(AccountPreferences.accountPreference.getKeyUserType()) == Error.OK) {
            if (AccountPreferences.userPojo != null)
                mPresenter.modifyUser(AccountPreferences.accountPreference.getKeyUserType());

            finish();
        } else
            Snackbar.make(this.findViewById(R.id.tilSignUpName), "Datos erróneos", Snackbar.LENGTH_LONG).show();
    }

    /**
     * Function to restars the TextInputLayouts
     */
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
            AccountPreferences.setUser(usertype);
            AccountPreferences.accountPreference.setKeyUserType(usertype);
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
