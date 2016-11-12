package com.jasrsir.tracing.pojo;

import android.media.Image;

import java.util.Date;

/**
 * POJO CLASS USER (super)
 */
public class UserPojo {

    //region variables
    private String codeUnique;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private Image photoB;
    private Image photoP;
    //endregion

    //region getter & setter
    public String getCodeUnique() {
        return codeUnique;
    }

    public void setCodeUnique(String codeUnique) {
        this.codeUnique = codeUnique;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Image getPhotoB() {
        return photoB;
    }

    public void setPhotoB(Image photoB) {
        this.photoB = photoB;
    }

    public Image getPhotoP() {
        return photoP;
    }

    public void setPhotoP(Image photoP) {
        this.photoP = photoP;
    }

    //endregion

    //region constructor
    /**
     * Constructor super to create an user
     * @param codeUnique Auto code unique for user id
     * @param name User name
     * @param surname User surname
     * @param email User email
     * @param pass User password
     * @param phone User phone number
     */
    public UserPojo(String codeUnique, String name, String surname, String email, String pass, String phone) {
        this.codeUnique = codeUnique;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = pass;
        this.phone = phone;
        this.photoB = null;
        this.photoP = null;
    }
    //endregion
}
