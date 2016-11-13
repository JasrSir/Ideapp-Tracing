package com.jasrsir.tracing.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Account preferencer to save vital information for uer
 */
public class AccountPreferences {

    //region variables
    //Private mode to make the file. (Common preferences)
    private int MODEPRIVATE = Context.MODE_PRIVATE;
    public static AccountPreferences accountPreference;
    private SharedPreferences sharedPreferences;
    private Context context;
    private boolean remember;
    private static final String ACCOUNT_PREFERENCES_FILE = "com.jasrsir.tracing_preferences";

    //KEY-VALUE for Sign up USERPOJO
    private static final String KEY_USER_UNIQUECODE = "user_unique_code";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_USER_SURNAME = "user_surname";
    private static final String KEY_USER_EMAIL = "user_email";
    private static final String KEY_USER_PASS = "user_pass";
    private static final String KEY_USER_PHONE = "user_phone";
    private static final String KEY_USER_REMEMBER = "user_remember";

    //KEY-VALUE for Sign up Business
    private static final String KEY_BUSINESS_CIF = "user_cif";
    private static final String KEY_BUSINESS_ADRESS = "user_adress";

    //KEY-VALUE for Sign up Professional & Business
    private static final String KEY_USER_PROFESSION = "user_profession";
    private static final String KEY_USER_ZONE = "user_zone";
    //endregion

    //region constructor, get instance and get editor
    public AccountPreferences(Context context) {
        this.context = context;
        this.sharedPreferences = getContext().getSharedPreferences(ACCOUNT_PREFERENCES_FILE, MODEPRIVATE);
    }

    /**
     * Obtain the context to create Account Preferences
     *
     * @param context application context
     * @return an instance of account preferences
     */
    public static AccountPreferences getInstance(Context context) {
        if (accountPreference == null) {
            accountPreference = new AccountPreferences(context);
        }
        return accountPreference;
    }

    private SharedPreferences.Editor getEditor() {
        return sharedPreferences.edit();
    }
    //endregion

    //region getter & setter

    public Context getContext() {
        return context;
    }

    //KEY-VALUE for Sign up USERPOJO
    public void setKeyUserUniquecode(String userUniquecode) {
        getEditor().putString(KEY_USER_UNIQUECODE, userUniquecode).apply();
    }

    public String getKeyUserUniquecode() {
        return sharedPreferences.getString(KEY_USER_UNIQUECODE, "");
    }

    public void setKeyUserName(String userName) {
        getEditor().putString(KEY_USER_NAME, userName).apply();
    }

    public String getKeyUserName() {
        return sharedPreferences.getString(KEY_USER_NAME, "");
    }

    public void setKeyUserSurname(String userSurname) {
        getEditor().putString(KEY_USER_SURNAME, userSurname).apply();
    }

    public String getKeyUserSurname() {
        return sharedPreferences.getString(KEY_USER_SURNAME, "");
    }

    public void setKeyUserEmail(String userEmail) {
        getEditor().putString(KEY_USER_EMAIL, userEmail).apply();
    }

    public String getKeyUserEmail() {
        return sharedPreferences.getString(KEY_USER_EMAIL, "");
    }

    public void setKeyUserPass(String userPass) {
        getEditor().putString(KEY_USER_PASS, userPass).apply();
    }

    public String getKeyUserPass() {
        return sharedPreferences.getString(KEY_USER_PASS, "");
    }
    public void setKeyUserPhone(String userPhone) {
        getEditor().putString(KEY_USER_PHONE, userPhone).apply();
    }

    public String getKeyUserPhone() {
        return sharedPreferences.getString(KEY_USER_PHONE, "");
    }

    public void setKeyUserRemember(boolean userRemember) {
        this.remember = userRemember;
        getEditor().putBoolean(KEY_USER_REMEMBER, this.remember).apply();
    }

    public boolean getKeyUserRemember() {
        return sharedPreferences.getBoolean(KEY_USER_REMEMBER, remember);
    }

    //KEY-VALUE for Sign up business
    public void setKeyBusinessCif(String businessCif) {
        getEditor().putString(KEY_BUSINESS_CIF, businessCif).apply();
    }

    public String getKeyBusinessCif() {
        return sharedPreferences.getString(KEY_BUSINESS_CIF, "");
    }

    public void setKeyBusinessAdress(String businessAdress) {
        getEditor().putString(KEY_BUSINESS_ADRESS, businessAdress).apply();
    }

    public String getKeyBusinessAdress() {
        return sharedPreferences.getString(KEY_BUSINESS_ADRESS, "");
    }

    //KEY-VALUE for Sign up Professional & Business
    public void setKeyUserProfession(String userProfession) {
        getEditor().putString(KEY_USER_PROFESSION, userProfession).apply();
    }

    public String getKeyUserProfession() {
        return sharedPreferences.getString(KEY_USER_PROFESSION, "");
    }

    public void setKeyUserZone(String userZone) {
        getEditor().putString(KEY_USER_ZONE, userZone).apply();
    }

    public String getKeyUserZone() {
        return sharedPreferences.getString(KEY_USER_ZONE, "");
    }

    //endregion

}
