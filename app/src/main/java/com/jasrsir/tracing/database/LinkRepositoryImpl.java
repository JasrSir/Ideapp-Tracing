package com.jasrsir.tracing.database;

import com.jasrsir.tracing.interfaces.LinkRepository;
import com.jasrsir.tracing.pojo.pojoevent.Link;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasrsir on 6/01/17.
 */

public class LinkRepositoryImpl implements LinkRepository {

    private ArrayList<Link> events;
    private static LinkRepositoryImpl repository;

    private LinkRepositoryImpl() {
        if (events == null)
            events = new ArrayList<>();
    }
    public static LinkRepositoryImpl getInstance() {
        if (repository == null)
            repository = new LinkRepositoryImpl();

        return repository;
    }
    public List<Link> getEvents() {
        return events;
    }

    @Override
    public void addLink(Link event) {
        events.add(event);
    }

    @Override
    public void deleteLink(Link event) {
        events.remove(event);
    }

    @Override
    public void updateLink(Link event) {
        int index = events.indexOf(getLinkById(event.getId()));
        events.remove(index);
        events.add(index, event);
    }

    @Override
    public Link getLinkById(String id) {
        for(Link tmp: events){
            if(tmp.getId().equals(id))
                return tmp;
        }
        return null;
    }
}
