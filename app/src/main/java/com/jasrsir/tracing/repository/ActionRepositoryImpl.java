package com.jasrsir.tracing.repository;

import com.jasrsir.tracing.interfaces.ActionRepository;
import com.jasrsir.tracing.pojo.pojoevent.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasrsir on 6/01/17.
 */

public class ActionRepositoryImpl implements ActionRepository {

    private ArrayList<Action> events;
    private static ActionRepositoryImpl repository;

    private ActionRepositoryImpl() {
        if (events == null)
            events = new ArrayList<>();
    }
    public static ActionRepositoryImpl getInstance() {
        if (repository == null)
            repository = new ActionRepositoryImpl();

        return repository;
    }
    public List<Action> getEvents() {
        return events;
    }

    @Override
    public void addAction(Action event) {
        events.add(event);
    }

    @Override
    public void deleteAction(Action event) {
        events.remove(event);
    }

    @Override
    public void updateAction(Action event) {
        int index = events.indexOf(getActionById(event.getId()));
        events.remove(index);
        events.add(index, event);

    }

    @Override
    public Action getActionById(String id) {
        for(Action tmp: events){
            if(tmp.getId().equals(id))
                return tmp;
        }
        return null;
    }
}
