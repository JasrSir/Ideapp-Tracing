package com.jasrsir.tracing.interfaces;

import com.jasrsir.tracing.pojo.pojoevent.EventPojo;

/**
 * Created by jasrsir on 5/01/17.
 */

public interface EventPojoPresenter {

    interface View {
         void showMessage(String message);
    }

    interface Presenter {
        void addEvent(EventPojo event);
        void updateEvent(EventPojo event);
        void deleteEvent(EventPojo event);
        void onDestroy();
    }


}
