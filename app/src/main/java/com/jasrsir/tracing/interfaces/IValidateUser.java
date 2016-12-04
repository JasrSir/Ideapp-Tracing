package com.jasrsir.tracing.interfaces;

/**
 * Created by Jasrsir on 04/12/2016.
 */

public interface IValidateUser {

    interface View{
        void setMessageError(String messageError, int idView);
    }

    interface Presenter {
        int validateCredentialsEmail(String email);

        int validateCredentialsPassword(String password);
    }

}
