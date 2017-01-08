package com.jasrsir.tracing.interfaces;

import com.jasrsir.tracing.pojo.pojoevent.EventPojo;

/**
 * Created by jasrsir on 5/01/17.
 */

public interface EventPojoPresenter {

    interface View {
        void showMessage(String message);
        void showEvent();
        void showEmptyState(boolean show);
        void showMessageDelete(EventPojo event);

    }

    interface Presenter {
        void addEvent(EventPojo event);
        void updateEvent(EventPojo event);
        void deleteEvent(EventPojo event);
        void onDestroy();

        void onAddToCardButtonClicked();

        EventPojo getEventPojo(long id);

        void onDeleteEventButtonClicked(EventPojo event);
        //void onEditEventButtonClicked(Event event);


    }


}
