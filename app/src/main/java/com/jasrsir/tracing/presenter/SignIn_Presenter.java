package com.jasrsir.tracing.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.interfaces.IValidateUser;
import com.jasrsir.tracing.pojo.Error;
import com.jasrsir.tracing.utils.ErrorMapUtils;

import static com.jasrsir.tracing.activity.SignUp_Activity.mUser;

/**
 * Class Sign In Presenter to validate the Log In
 */
public class SignIn_Presenter implements IValidateUser.Presenter {

    //region Variables
    private IValidateUser.View view;
    private Context context;
    //endregion

    //region Functions
    /**
     * Constructor to presenter
     * @param view IValidateAccount.View to validate
     */
    public SignIn_Presenter(IValidateUser.View view) {
        this.view = view;
        this.context = (Context) view;
    }

    @Override
    public int validateCredentialsEmail(String email) {
        int idError = Error.OK;
        if (TextUtils.isEmpty(email)) {
            idError = Error.DATA_EMPTY;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            idError = Error.EMAIL_INVALID;

        if (idError != Error.OK) {
            String nameResource = ErrorMapUtils.getErrorMapResource(context).get(String.valueOf(idError));
            view.setMessageError(nameResource, R.id.tilUser);
        }
        return idError;
    }

    @Override
    public int validateCredentialsPassword(String password) {
        int idError;

        if (TextUtils.isEmpty(password)) {
            idError = Error.DATA_EMPTY;
        } else if (!password.matches("^.{0,}([0-9])+.{0,}$")) {
            idError = Error.PASSWORD_DIGIT;
        } else if (!password.matches("^.+[a-zA-Z]+.+$")) {
            idError = Error.PASSWORD_CASE;
        } else if (password.length() < 8) {
            idError = Error.PASSWORD_LENGTH;
        } else {
            idError = Error.OK;
        }

        if (idError != Error.OK) {
            String nameResource = ErrorMapUtils.getErrorMapResource(context).get(String.valueOf(idError));
            view.setMessageError(nameResource, R.id.tilSignUpPass);
        }

        return idError;
    }

    @Override
    public int validateSignIn(String email, String password) {
        int idError;

        if (email.equals( mUser.getEmail()) && password.equals(mUser.getPassword()))
            idError = Error.OK;
        else
            idError = Error.SIGNIN;

        return idError;
    }
    //endregion
}
