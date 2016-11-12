package com.jasrsir.tracing.pojo.pojoevent;

/**
 * POJO class (event's base)
 */
public class EventPojo {
    //region variables
    private String codeEvent;
    private String codeSender;
    private String codeReceiver;
    private String title;
    private String summary;
    //endregion

    //region getter & setter

    public String getCodeEvent() {
        return codeEvent;
    }

    public void setCodeEvent(String codeEvent) {
        this.codeEvent = codeEvent;
    }

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

    //endregion

    //region constructor

    /**
     * Constructor a event (super class)
     * @param codeEvent     unique code of event
     * @param codeSender    sender unique code
     * @param codeReceiver  receiver unique code
     * @param title         event's title
     * @param summary       event's summary
     */
    public EventPojo(String codeEvent, String codeSender, String codeReceiver, String title, String summary) {
        this.codeEvent = codeEvent;
        this.codeSender = codeSender;
        this.codeReceiver = codeReceiver;
        this.title = title;
        this.summary = summary;
    }

    //endregion
}
