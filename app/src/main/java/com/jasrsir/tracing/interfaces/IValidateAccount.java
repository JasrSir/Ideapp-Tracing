package com.jasrsir.tracing.interfaces;

/**
 * Interface to validate the Sign up
 */

public interface IValidateAccount {

    /**
     * View
     */
    interface View{
        /**
         * Set a message error in TextInputLayout
         * @param messageError Message to set
         * @param idView View (TIL) to show the message
         */
        void setMessageError(String messageError, int idView);

    }

    /**
     * Presenter
     */
    interface Presenter{

        //region Functions
        /**
         * Method to validate the user name
         *
         * @param name String to validate
         * @return 0 = OK, otherwise error
         */
        int validateCredentialsName(String name);

        /**
         * Method to validate the user surname
         *
         * @param surname String to validate
         * @return 0 = OK, otherwise error
         */
        int validateCredentialsSurname(String surname);

        /**
         * Method to validate the user phone
         *
         * @param phone String to validate
         * @return 0 = OK, otherwise error
         */
        int validateCredentialsPhone(String phone);

        /**
         * Method to validate the user email
         *
         * @param email String to validate
         * @return 0 = OK, otherwise error
         */
        int validateCredentialsEmail(String email);

        /**
         * Method to validate the user password
         *
         * @param password String to validate
         * @return 0 = OK, otherwise error
         */
        int validateCredentialsPass(String password);

        /**
         * Method to validate the uprofessional or business work / profession
         *
         * @param profession String to validate
         * @return 0 = OK, otherwise error
         */
        int validateCredentialsProfession(String profession);

        /**
         * Method to validate the business cif
         *
         * @param cif String to validate
         * @return 0 = OK, otherwise error
         */
        int validateCredentialsCif(String cif);

        /**
         * Method to validate the business adress
         *
         * @param adress String to validate
         * @return 0 = OK, otherwise error
         */
        int validateCredentialsAdress(String adress);

        /**
         * Method to validate the uprofessionl or business
         *
         * @param zone String to validate
         * @return 0 = OK, otherwise error
         */
        int validateCredentialsZone(String zone);


    }

}
