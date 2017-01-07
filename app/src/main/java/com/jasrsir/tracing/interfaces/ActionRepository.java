package com.jasrsir.tracing.interfaces;

import com.jasrsir.tracing.pojo.pojoevent.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface Repository
 */

public interface ActionRepository {

    List<Action> allAction = new ArrayList<Action>();

    void addAction(Action event);

    void deleteAction(Action event);

    void updateAction(Action event);

    Action getActionById(String id);
}
