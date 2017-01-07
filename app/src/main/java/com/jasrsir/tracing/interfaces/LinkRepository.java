package com.jasrsir.tracing.interfaces;

import com.jasrsir.tracing.pojo.pojoevent.Link;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface Repository
 */

public interface LinkRepository {

    List<Link> allLinks = new ArrayList<Link>();

    void addLink(Link event);

    void deleteLink(Link event);

    void updateLink(Link event);

    Link getLinkById(String id);
}
