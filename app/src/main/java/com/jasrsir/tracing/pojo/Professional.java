package com.jasrsir.tracing.pojo;

import com.jasrsir.tracing.interfaces.IValidateUser;

/**
 * this class create a new professional user
 */
public class Professional extends User {

    //region variables
    private String profession;
    private String zone;
    //endregion

    //region getter & setter

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    //endregion

    //region constructor
    /**
     * Constructor super to create a professional user
     * @param name professional name
     * @param surname professional surname
     * @param email professional email
     * @param pass User password
     * @param phone professional phone number
     * @param profession professional profession
     * @param zone professional area services
     */
    public Professional( String name, String surname, String email, String pass, String phone, String profession, String zone) {
        super( name, surname, email,pass, phone);
        this.profession = profession;
        this.zone = zone;
    }
    public Professional(){}
    //endregion
}
