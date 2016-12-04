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

import static com.jasrsir.tracing.activity.SignUp_Activity.mUser;

/**
 * Class Sign Up Presenter to validate a new user, create or modify an existing user in AccountPreferences
 */
public class SignUp_Presenter implements IValidateAccount.Presenter {

    //Variables
    private IValidateAccount.View view;
    private Context context;

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
     * Create a new type user
     *
     * @param usertype User, Professional or Business
     */
    public void createUser(String usertype) {
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
     *
     * @param usertype User, Professional or Business
     */
    public void modifyUser(String usertype) {
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
                ((Professional) mUser).setProfession(AccountPreferences.accountPreference.getKeyUserProfession());
                ((Professional) mUser).setZone(AccountPreferences.accountPreference.getKeyUserZone());
                break;
            case "business":
                mUser.setName(AccountPreferences.accountPreference.getKeyUserName());
                mUser.setSurname(AccountPreferences.accountPreference.getKeyUserSurname());
                mUser.setEmail(AccountPreferences.accountPreference.getKeyUserEmail());
                mUser.setPassword(AccountPreferences.accountPreference.getKeyUserPass());
                mUser.setPhone(AccountPreferences.accountPreference.getKeyUserPhone());
                ((Business) mUser).setNameBusiness(AccountPreferences.accountPreference.getKeyUserName());
                ((Business) mUser).setProfession(AccountPreferences.accountPreference.getKeyUserProfession());
                ((Business) mUser).setAdress(AccountPreferences.accountPreference.getKeyBusinessAdress());
                ((Business) mUser).setCif(AccountPreferences.accountPreference.getKeyBusinessCif());
                ((Business) mUser).setZone(AccountPreferences.accountPreference.getKeyUserZone());
                break;
        }
    }

    /**
     * Method to validate the user name
     *
     * @param name String to validate
     * @return 0 = OK, otherwise error
     */
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

    /**
     * Method to validate the user surname
     *
     * @param surname String to validate
     * @return 0 = OK, otherwise error
     */
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

    /**
     * Method to validate the user phone
     *
     * @param phone String to validate
     * @return 0 = OK, otherwise error
     */
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

    /**
     * Method to validate the user email
     *
     * @param email String to validate
     * @return 0 = OK, otherwise error
     */
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

    /**
     * Method to validate the user password
     *
     * @param password String to validate
     * @return 0 = OK, otherwise error
     */
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

    /**
     * Method to validate the uprofessional or business work / profession
     *
     * @param profession String to validate
     * @return 0 = OK, otherwise error
     */
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

    /**
     * Method to validate the business cif
     *
     * @param cif String to validate
     * @return 0 = OK, otherwise error
     */
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

    /**
     * Method to validate the business adress
     *
     * @param adress String to validate
     * @return 0 = OK, otherwise error
     */
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

    /**
     * Method to validate the uprofessionl or business
     *
     * @param zone String to validate
     * @return 0 = OK, otherwise error
     */
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
}
