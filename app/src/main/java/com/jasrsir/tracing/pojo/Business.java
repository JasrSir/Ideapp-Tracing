package com.jasrsir.tracing.pojo;

/**
 * this class create a new Business user
 */
public class Business extends User {

    //region variables
    private String nameBusiness;
    private String profession;
    private String adress;
    private String cif;
    private String zone;
    //endregion

    //region getter & setter

    public String getNameBusiness() {
        return nameBusiness;
    }

    public void setNameBusiness(String nameBusiness) {
        this.nameBusiness = nameBusiness;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
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
     * Constructor super to create a business user
     * @param codeUnique Auto code unique for business id
     * @param name business CEO name
     * @param surname business CEO surname
     * @param email business email
     * @param pass User password
     * @param phone business phone number
     * @param nameBusiness business namework
     * @param profession professional profession
     * @param adress business adress
     * @param cif business cif number
     * @param zone business area services
     */
    public Business(String codeUnique, String name, String surname, String email,String pass, String phone, String nameBusiness, String profession, String adress, String cif, String zone) {
        super(codeUnique, name, surname, email, pass, phone);
        this.nameBusiness = nameBusiness;
        this.profession = profession;
        this.adress = adress;
        this.cif = cif;
        this.zone = zone;
    }
    public Business(){}
    //endregion
}
