package com.jasrsir.tracing.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.interfaces.IValidateUser;
import com.jasrsir.tracing.pojo.Error;
import com.jasrsir.tracing.preferences.AccountPreferences;
import com.jasrsir.tracing.presenter.SignIn_Presenter;


public class SignIn_Activity extends AppCompatActivity implements IValidateUser.View {

    //region Variables
    private TextInputLayout mTilMail;
    private TextInputLayout mTilPass;
    private EditText mEdtMail;
    private EditText mEdtPass;
    private Switch mCkbRemember;
    private SignIn_Presenter mPresenter;
    private Button mBtnLogIn;
    private TextView mTxvLostUC;
    //endregion

    //region Functions
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mPresenter = new SignIn_Presenter(this);
        getWidgets();
        setAccountPreferences();

    }

    /**
     * inflate variables with views
     */
    private void getWidgets() {

        mTilMail = (TextInputLayout) findViewById(R.id.tilUser);
        mTilPass = (TextInputLayout) findViewById(R.id.tilPass);
        mEdtMail = (EditText) findViewById(R.id.edtEmail);
        mEdtPass = (EditText) findViewById(R.id.edtPassword);
        mCkbRemember = (Switch) findViewById(R.id.ckbRemember);
        mBtnLogIn = (Button) findViewById(R.id.btnLogin);
        mBtnLogIn.setOnClickListener(new View.OnClickListener() {
            /**
             * Method that Log in the user or launch (Lost Unique Code)
             *
             * @param v Widget clicked
             */
            @Override
            public void onClick(View v) {
                Intent intent;
                    //Validar los datos
                    if (AccountPreferences.accountPreference != null ) {
                        AccountPreferences.accountPreference.setKeyUserRemember(mCkbRemember.isChecked());

                        if (mPresenter.validateCredentialsEmail(mEdtMail.getText().toString()) == Error.OK &&
                                mPresenter.validateCredentialsPassword(mEdtPass.getText().toString()) == Error.OK) {

                            if (mPresenter.validateSignIn(mEdtMail.getText().toString(), mEdtPass.getText().toString()) == Error.OK) {
                                intent = new Intent(SignIn_Activity.this, Wall_Activity.class);

                                startActivity(intent);
                            } else
                                Snackbar.make(findViewById(R.id.tilPass), R.string.noEquals, Snackbar.LENGTH_LONG).show();
                        }
                    } else
                        Snackbar.make(findViewById(R.id.tilPass), R.string.makeAccountFirst, Snackbar.LENGTH_LONG).show();
            }

        });
        mTxvLostUC = (TextView) findViewById(R.id.txvLostUC);
        mTxvLostUC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn_Activity.this, SignLost_Activity.class));
            }
        });
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



    @Override
    public void setMessageError(String messageError, int idView) {
        String message = getResources().getString(getResources().getIdentifier(messageError, "string", getPackageName()));

        switch (idView) {
            case R.id.tilUser:
                mTilMail.setError(message);
                break;
            case R.id.tilPass:
                mTilPass.setError(message);
                break;
        }
    }
    //endregion
}
