package com.jasrsir.tracing.repository;

import com.jasrsir.tracing.interfaces.AnotationRepository;
import com.jasrsir.tracing.interfaces.LinkRepository;
import com.jasrsir.tracing.pojo.pojoevent.Anotation;
import com.jasrsir.tracing.pojo.pojoevent.Link;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasrsir on 6/01/17.
 */

public class AnotationRepositoryImpl implements AnotationRepository {

    private ArrayList<Anotation> events;
    private static AnotationRepositoryImpl repository;

    private AnotationRepositoryImpl() {
        if (events == null)
            events = new ArrayList<>();
    }
    public static AnotationRepositoryImpl getInstance() {
        if (repository == null)
            repository = new AnotationRepositoryImpl();

        return repository;
    }
    public List<Anotation> getEvents() {
        return events;
    }

    @Override
    public void addAnotation(Anotation event) {
        events.add(event);
    }

    @Override
    public void deleteAnotation(Anotation event) {
        events.remove(event);
    }

    @Override
    public void updateAnotation(Anotation event) {
        int index = events.indexOf(getAnotationById(event.getId()));
        events.remove(index);
        events.add(index, event);
    }

    @Override
    public Anotation getAnotationById(String id) {
        for(Anotation tmp: events){
            if(tmp.getId().equals(id))
                return tmp;
        }
        return null;
    }
}
