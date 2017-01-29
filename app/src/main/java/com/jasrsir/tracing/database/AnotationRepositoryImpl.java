package com.jasrsir.tracing.database;

import com.jasrsir.tracing.interfaces.AnotationRepository;
import com.jasrsir.tracing.pojo.pojoevent.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasrsir on 6/01/17.
 */

public class AnotationRepositoryImpl implements AnotationRepository {

    private ArrayList<Note> events;
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
    public List<Note> getEvents() {
        return events;
    }

    @Override
    public void addAnotation(Note event) {
        events.add(event);
    }

    @Override
    public void deleteAnotation(Note event) {
        events.remove(event);
    }

    @Override
    public void updateAnotation(Note event) {
        int index = events.indexOf(getAnotationById(event.getId()));
        events.remove(index);
        events.add(index, event);
    }

    @Override
    public Note getAnotationById(String id) {
        for(Note tmp: events){
            if(tmp.getId().equals(id))
                return tmp;
        }
        return null;
    }
}
