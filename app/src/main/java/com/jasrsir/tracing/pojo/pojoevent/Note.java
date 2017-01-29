package com.jasrsir.tracing.pojo.pojoevent;

/**
 * Note class. Is equals to EventPojo class
 * this class is used to send a anotation to other user
 */
public class Note extends EventPojo {

    //region variables
    //endregion

    //region getter & setter
    //endregion

    //region constructor
    /**
     * Note constructor (equals super class)
     *
     * @param codeSender   sender unique code
     * @param codeReceiver receiver unique code
     * @param title        anotation title
     * @param summary      anotation summary
     */
    public Note(String codeSender, String codeReceiver, String title, String summary) {
        super( codeSender, codeReceiver, title, summary);
    }
    //endregion
}
