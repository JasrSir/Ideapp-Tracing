package com.jasrsir.tracing.interfaces;

import com.jasrsir.tracing.pojo.pojoevent.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface TracingApplication
 */

public interface AnotationRepository {

    List<Note> allNotes = new ArrayList<Note>();

    void addAnotation(Note event);

    void deleteAnotation(Note event);

    void updateAnotation(Note event);

    Note getAnotationById(String id);
}
