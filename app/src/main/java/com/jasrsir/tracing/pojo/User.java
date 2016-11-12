package com.jasrsir.tracing.pojo;

/**
 * this class create a new user
 */
public class User extends UserPojo {

    //region constructor
    /**
     * User Constructor
     *
     * @param codeUnique Auto code unique for user id
     * @param name       User name
     * @param surname    User surname
     * @param email      User email
     * @param pass       User password
     * @param phone      User phone number
     */
    public User(String codeUnique, String name, String surname, String email, String pass, String phone) {
        super(codeUnique, name, surname, email, pass, phone);

    }
    //endregion


}
