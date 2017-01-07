package com.jasrsir.tracing.pojo.pojoevent;

/**
 * Action class.
 * this class is used to send a action, physic exercises or recomendation
 * to other user
 */
public class Action extends EventPojo {
    //region variables
    private String repetition;
    private String duration;
    //endregion

    //region getter & setter
    public String getRepetition() {
        return repetition;
    }

    public void setRepetition(String repetition) {
        this.repetition = repetition;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    //endregion

    //region constructor
    /**
     * Link constructor
     *
     * @param codeSender   sender unique code
     * @param codeReceiver receiver unique code
     * @param title        action's title
     * @param summary      action's summary
     * @param repetition   repetitions per day, week, month
     * @param duration     duration in minutes, hours, days
     */
    public Action( String codeSender, String codeReceiver, String title, String summary, String repetition, String duration) {
        super( codeSender, codeReceiver, title, summary);
        this.repetition = repetition;
        this.duration = duration;
    }

    //endregion
}
