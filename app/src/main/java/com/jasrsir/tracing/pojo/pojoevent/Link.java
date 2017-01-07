package com.jasrsir.tracing.pojo.pojoevent;

/**
 * Link class.
 * this class is used to send a url util to other user
 */
public class Link extends EventPojo {

    //region variables
    private String link;
    //endregion

    //region getter & setter

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    //endregion

    //region constructor
    /**
     * Link constructor
     *
     * @param codeSender   sender unique code
     * @param codeReceiver receiver unique code
     * @param title        link's title
     * @param summary      link's summary
     * @param link         url
     */
    public Link( String codeSender, String codeReceiver, String title, String summary, String link) {
        super( codeSender, codeReceiver, title, summary);
        this.link = link;
    }
    //endregion
}
