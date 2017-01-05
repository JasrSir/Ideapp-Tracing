package com.jasrsir.tracing.interfaces;

import com.jasrsir.tracing.pojo.pojoevent.EventPojo;

import java.util.List;

/**
 * Created by jasrsir on 5/01/17.
 */

public interface WallPresenter {

    interface View {
        void showMessage(String message);
        void showEmptyState();
        void showEvents(List<EventPojo> listEvent);
    }

    interface Presenter {
        void loadEvents();
        EventPojo getEvent(long id);
        void deleteEvent(EventPojo event);
        void onDestroy();
    }

}
