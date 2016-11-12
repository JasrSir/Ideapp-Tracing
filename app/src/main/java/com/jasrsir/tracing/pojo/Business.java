package com.jasrsir.tracing.pojo;

/**
 * this class create a new Business user
 */
public class Business extends UserPojo {

    //region variables
    private String nameBusiness;
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
     * @param phone business phone number
     * @param nameBusiness business namework
     * @param adress business adress
     * @param cif business cif number
     * @param zone business area services
     */
    public Business(String codeUnique, String name, String surname, String email, String phone, String nameBusiness, String adress, String cif, String zone) {
        super(codeUnique, name, surname, email, phone);
        this.nameBusiness = nameBusiness;
        this.adress = adress;
        this.cif = cif;
        this.zone = zone;
    }
    //endregion
}
