package com.jasrsir.tracing.pojo.pojoevent;

/**
 * Anotation class. Is equals to EventPojo class
 * this class is used to send a anotation to other user
 */
public class Anotation extends EventPojo {

    //region variables
    //endregion

    //region getter & setter
    //endregion

    //region constructor
    /**
     * Anotation constructor (equals super class)
     *
     * @param codeEvent    unique code of event
     * @param codeSender   sender unique code
     * @param codeReceiver receiver unique code
     * @param title        anotation title
     * @param summary      anotation summary
     */
    public Anotation(String codeEvent, String codeSender, String codeReceiver, String title, String summary) {
        super(codeEvent, codeSender, codeReceiver, title, summary);
    }
    //endregion
}
