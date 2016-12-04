package com.jasrsir.tracing.interfaces;

/**
 * Interface to validate the Sign up
 */

public interface IValidateAccount {

    /**
     * View
     */
    interface View{
        void setMessageError(String messageError, int idView);

    }

    /**
     * Presenter
     */
    interface Presenter{
        int validateCredentialsName(String name);
        int validateCredentialsSurname(String surname);
        int validateCredentialsPhone(String phone);
        int validateCredentialsEmail(String email);
        int validateCredentialsPass(String password);
        int validateCredentialsProfession(String profession);
        int validateCredentialsCif(String cif);
        int validateCredentialsAdress(String adress);
        int validateCredentialsZone(String zone);

    }

}
