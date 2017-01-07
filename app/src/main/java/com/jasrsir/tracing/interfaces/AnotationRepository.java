package com.jasrsir.tracing.interfaces;

import com.jasrsir.tracing.pojo.pojoevent.Anotation;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface Repository
 */

public interface AnotationRepository {

    List<Anotation> allAnotations = new ArrayList<Anotation>();

    void addAnotation(Anotation event);

    void deleteAnotation(Anotation event);

    void updateAnotation(Anotation event);

    Anotation getAnotationById(String id);
}
