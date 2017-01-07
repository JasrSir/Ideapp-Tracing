package com.jasrsir.tracing.pojo.pojoevent;

/**
 * Date class (event based a Calendar date)
 */
public class Date extends EventPojo {
    //region variables
    private String date;
    private String hourStart;
    private String hourEnd;
    //endregion

    //region getter & setter

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHourStart() {
        return hourStart;
    }

    public void setHourStart(String hourStart) {
        this.hourStart = hourStart;
    }

    public String getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(String hourEnd) {
        this.hourEnd = hourEnd;
    }

    //endregion

    //region constructor

    /**
     * Date event constructor
     * @param codeSender    sender unique code
     * @param codeReceiver  receiver unique code
     * @param title         date's title
     * @param summary       date's summary
     * @param date          date's date
     * @param hourStart     the date start at...
     * @param hourEnd       the date end at...
     */
    public Date(String codeSender, String codeReceiver, String title, String summary, String date, String hourStart, String hourEnd) {
        super( codeSender, codeReceiver, title, summary);
        this.date = date;
        this.hourStart = hourStart;
        this.hourEnd = hourEnd;
    }

    //endregion
}
