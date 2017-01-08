package com.jasrsir.tracing.repository;

import com.jasrsir.tracing.interfaces.DateRepository;
import com.jasrsir.tracing.pojo.pojoevent.Date;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasrsir on 6/01/17.
 */

public class DateRepositoryImpl implements DateRepository {

    private ArrayList<Date> events;
    private static DateRepositoryImpl repository;

    private DateRepositoryImpl() {
        if (events == null)
            events = new ArrayList<>();
        addDate(new Date("codesender","codereceiver","Comercial de Bofrost","Pago de 30€ por las papas que te traje el otro dia","21-05-2017","12:30","13:30"));
        addDate(new Date("codesender","codereceiver","Comercial de Bofrost","Pago de 30€ por las papas que te traje el otro dia","21-05-2017","12:30","13:30"));
        addDate(new Date("codesender","codereceiver","NO voy a ir","Se me he retrasao","21-05-2017","12:30","13:30"));
    }
    public static DateRepositoryImpl getInstance() {
        if (repository == null)
            repository = new DateRepositoryImpl();

        return repository;
    }
    public List<Date> getEvents() {
        return events;
    }


    @Override
    public void addDate(Date event) {
        events.add(event);
    }

    @Override
    public void deleteDate(Date event) {
        events.remove(event);
    }

    @Override
    public void updateDate(Date event) {
        int index = events.indexOf(getDateById(event.getId()));
        events.remove(index);
        events.add(index, event);
    }

    @Override
    public Date getDateById(String id) {
        for(Date tmp: events){
            if(tmp.getId().equals(id))
                return tmp;
        }
        return null;
    }
}
