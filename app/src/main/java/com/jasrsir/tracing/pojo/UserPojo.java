package com.jasrsir.tracing.pojo;

import android.media.Image;

import com.jasrsir.tracing.preferences.AccountPreferences;

import java.util.Date;
import java.util.UUID;

/**
 * POJO CLASS USER (super)
 */
public class UserPojo {

    //region variables
    private UUID codeUnique;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private Image photoB;
    private Image photoP;
    //endregion

    //region getter & setter
    public UUID getCodeUnique() {
        return codeUnique;
    }

    public void setCodeUnique(UUID codeUnique) {
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
     * @param name User name
     * @param surname User surname
     * @param email User email
     * @param pass User password
     * @param phone User phone number
     */
    public UserPojo( String name, String surname, String email, String pass, String phone) {
        this.codeUnique = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = pass;
        this.phone = phone;
        this.photoB = null;
        this.photoP = null;
    }

    public UserPojo() {

    }
    //endregion
}
