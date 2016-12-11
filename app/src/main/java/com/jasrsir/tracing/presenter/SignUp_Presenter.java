package com.jasrsir.tracing.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.interfaces.IValidateAccount;
import com.jasrsir.tracing.pojo.Business;
import com.jasrsir.tracing.pojo.Error;
import com.jasrsir.tracing.pojo.Professional;
import com.jasrsir.tracing.pojo.User;
import com.jasrsir.tracing.preferences.AccountPreferences;
import com.jasrsir.tracing.utils.ErrorMapUtils;


/**
 * Class Sign Up Presenter to validate a new user, create or modify an existing user in AccountPreferences
 */
public class SignUp_Presenter implements IValidateAccount.Presenter {

    //region Variables
    private IValidateAccount.View view;
    private Context context;
    //endregion

    //region Functions
    /**
     * Constructor to presenter
     *
     * @param view IValidateAccount.View to validate
     */
    public SignUp_Presenter(IValidateAccount.View view) {
        this.view = view;
        this.context = (Context) view;
    }


    /**
     * Modify a user
     *
     * @param usertype User, Professional or Business
     */
    public void modifyUser(String usertype) {
        switch (usertype) {
            case "user":
                AccountPreferences.userPojo.setName(AccountPreferences.accountPreference.getKeyUserName());
                AccountPreferences.userPojo.setSurname(AccountPreferences.accountPreference.getKeyUserSurname());
                AccountPreferences.userPojo.setEmail(AccountPreferences.accountPreference.getKeyUserEmail());
                AccountPreferences.userPojo.setPassword(AccountPreferences.accountPreference.getKeyUserPass());
                AccountPreferences.userPojo.setPhone(AccountPreferences.accountPreference.getKeyUserPhone());
                break;
            case "professional":
                AccountPreferences.userPojo.setName(AccountPreferences.accountPreference.getKeyUserName());
                AccountPreferences.userPojo.setSurname(AccountPreferences.accountPreference.getKeyUserSurname());
                AccountPreferences.userPojo.setEmail(AccountPreferences.accountPreference.getKeyUserEmail());
                AccountPreferences.userPojo.setPassword(AccountPreferences.accountPreference.getKeyUserPass());
                AccountPreferences.userPojo.setPhone(AccountPreferences.accountPreference.getKeyUserPhone());
                ((Professional) AccountPreferences.userPojo).setProfession(AccountPreferences.accountPreference.getKeyUserProfession());
                ((Professional) AccountPreferences.userPojo).setZone(AccountPreferences.accountPreference.getKeyUserZone());
                break;
            case "business":
                AccountPreferences.userPojo.setName(AccountPreferences.accountPreference.getKeyUserName());
                AccountPreferences.userPojo.setSurname(AccountPreferences.accountPreference.getKeyUserSurname());
                AccountPreferences.userPojo.setEmail(AccountPreferences.accountPreference.getKeyUserEmail());
                AccountPreferences.userPojo.setPassword(AccountPreferences.accountPreference.getKeyUserPass());
                AccountPreferences.userPojo.setPhone(AccountPreferences.accountPreference.getKeyUserPhone());
                ((Business) AccountPreferences.userPojo).setNameBusiness(AccountPreferences.accountPreference.getKeyUserName());
                ((Business) AccountPreferences.userPojo).setProfession(AccountPreferences.accountPreference.getKeyUserProfession());
                ((Business) AccountPreferences.userPojo).setAdress(AccountPreferences.accountPreference.getKeyBusinessAdress());
                ((Business) AccountPreferences.userPojo).setCif(AccountPreferences.accountPreference.getKeyBusinessCif());
                ((Business) AccountPreferences.userPojo).setZone(AccountPreferences.accountPreference.getKeyUserZone());
                break;
        }
    }

    @Override
    public int validateCredentialsName(String name) {
        int idError = Error.OK;
        if (TextUtils.isEmpty(name)) {
            idError = Error.DATA_EMPTY;
        }
        if (idError != Error.OK) {
            String nameResource = ErrorMapUtils.getErrorMapResource(context).get(String.valueOf(idError));
            view.setMessageError(nameResource, R.id.tilSignUpName);
        }
        return idError;
    }

    @Override
    public int validateCredentialsSurname(String surname) {
        int idError = Error.OK;
        if (TextUtils.isEmpty(surname)) {
            idError = Error.DATA_EMPTY;
        }
        if (idError != Error.OK) {
            String nameResource = ErrorMapUtils.getErrorMapResource(context).get(String.valueOf(idError));
            view.setMessageError(nameResource, R.id.tilSignUpSurname);
        }
        return idError;
    }

    @Override
    public int validateCredentialsPhone(String phone) {
        int idError = Error.OK;
        if (!TextUtils.isEmpty(phone)) {
            if (!Patterns.PHONE.matcher(phone).matches())
                idError = Error.PHONE_INVALID;
        } else
            idError = Error.DATA_EMPTY;

        if (idError != Error.OK) {
            String nameResource = ErrorMapUtils.getErrorMapResource(context).get(String.valueOf(idError));
            view.setMessageError(nameResource, R.id.tilSignUpPhone);
        }
        return idError;

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
            view.setMessageError(nameResource, R.id.tilSignUpMail);
        }
        return idError;
    }

    @Override
    public int validateCredentialsPass(String password) {
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
    public int validateCredentialsProfession(String profession) {
        int idError = Error.OK;
        if (TextUtils.isEmpty(profession)) {
            idError = Error.DATA_EMPTY;
        }
        if (idError != Error.OK) {
            String nameResource = ErrorMapUtils.getErrorMapResource(context).get(String.valueOf(idError));
            view.setMessageError(nameResource, R.id.tilSignUpWork);
        }
        return idError;
    }

    @Override
    public int validateCredentialsCif(String cif) {
        int idError = Error.OK;
        if (TextUtils.isEmpty(cif)) {
            idError = Error.CIF_INVALID;
        }
        if (idError != Error.OK) {
            String nameResource = ErrorMapUtils.getErrorMapResource(context).get(String.valueOf(idError));
            view.setMessageError(nameResource, R.id.tilSignUpCif);
        }
        return idError;
    }

    @Override
    public int validateCredentialsAdress(String adress) {
        int idError = Error.OK;
        if (TextUtils.isEmpty(adress)) {
            idError = Error.DATA_EMPTY;
        }
        if (idError != Error.OK) {
            String nameResource = ErrorMapUtils.getErrorMapResource(context).get(String.valueOf(idError));
            view.setMessageError(nameResource, R.id.tilSignUpCif);
        }
        return idError;
    }

    @Override
    public int validateCredentialsZone(String zone) {
        int idError = Error.OK;
        if (TextUtils.isEmpty(zone)) {
            idError = Error.DATA_EMPTY;
        }
        /*if (idError != Error.OK){
            String nameResource= ErrorMapUtils.getErrorMapResource(context).get(String.valueOf(idError));
            view.setMessageError(nameResource,R.id.tilSignUpPass);
        }*/
        return idError;
    }
    //endregion
}
