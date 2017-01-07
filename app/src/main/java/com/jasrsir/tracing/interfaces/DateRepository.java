package com.jasrsir.tracing.interfaces;

import com.jasrsir.tracing.pojo.pojoevent.Date;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface Repository
 */

public interface DateRepository {

    List<Date> allDates = new ArrayList<Date>();

    void addDate(Date event);

    void deleteDate(Date event);

    void updateDate(Date event);

    Date getDateById(String id);
}
