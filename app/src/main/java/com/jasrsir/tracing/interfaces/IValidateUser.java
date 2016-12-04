package com.jasrsir.tracing.interfaces;

/**
 * Created by Jasrsir on 04/12/2016.
 */

public interface IValidateUser {

    interface View{
        /**
         * Set a message error in TextInputLayout
         * @param messageError Message to set
         * @param idView View (TIL) to show the message
         */
        void setMessageError(String messageError, int idView);
    }

    interface Presenter {

        //region Functions
        /**
         * Method to validate the user email
         * @param email String to validate
         * @return 0 = OK, otherwise error
         */
        int validateCredentialsEmail(String email);

        /**
         * Method to validate the user phone
         *
         * @param password String to validate
         * @return 0 = OK, otherwise error
         */
        int validateCredentialsPassword(String password);

        /**
         * Method to validate the Sign In
         * @param email email to compare
         * @param password password to compare
         * @return 0 = OK, otherwise error
         */
        int validateSignIn(String email, String password);

        //endregion
    }

}
