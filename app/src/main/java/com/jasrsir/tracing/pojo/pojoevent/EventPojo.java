package com.jasrsir.tracing.pojo.pojoevent;

import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * POJO class (event's base)
 */
public class EventPojo {
    //region variables
    private String id;
    private String codeSender;
    private String codeReceiver;
    private String title;
    private String summary;
    private String dateCreation;
    //endregion

    //region getter & setter

    public String getCodeSender() {
        return codeSender;
    }

    public void setCodeSender(String codeSender) {
        this.codeSender = codeSender;
    }

    public String getCodeReceiver() {
        return codeReceiver;
    }

    public void setCodeReceiver(String codeReceiver) {
        this.codeReceiver = codeReceiver;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = new SimpleDateFormat("dd-MM-yyyy hh:mm").format(dateCreation);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //endregion

    //region constructor

    /**
     * Constructor a event (super class)
     * @param codeSender    sender unique code
     * @param codeReceiver  receiver unique code
     * @param title         event's title
     * @param summary       event's summary
     */
    public EventPojo(  String codeSender, String codeReceiver, String title, String summary) {
        this.id = UUID.randomUUID().toString();
        this.codeSender = codeSender;
        this.codeReceiver = codeReceiver;
        this.title = title;
        this.summary = summary;
    }

    //endregion
}
