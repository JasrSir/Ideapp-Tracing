package com.jasrsir.tracing.pojo;

import java.util.UUID;

/**
 * this class create a new user
 */
public class User extends UserPojo {

    //region constructor
    /**
     * User Constructor
     *
     * @param name       User name
     * @param surname    User surname
     * @param email      User email
     * @param pass       User password
     * @param phone      User phone number
     */
    public User(String name, String surname, String email, String pass, String phone) {
        super(name, surname, email, pass, phone);

    }

    public User(){}
    //endregion


}
