package com.howtographql.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages link persistence
 */
public class LinkRepository {

    private final List<Link> links;

    public LinkRepository() {
        links = new ArrayList<>();
        //add some links to start off with
        links.add(new Link("link-01", "http://howtographql.com", "Your favorite GraphQL page", "user-01"));
        links.add(new Link("link-02", "http://graphql.org/learn/", "The official docks", "user-02"));
    }

    public Link findById(String id) {
        return links
                .stream()
                .filter(link -> link.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Link> getAllLinks() {
        return links;
    }

    public void saveLink(Link link) {
        links.add(link);
    }

    public Link updateLink(Link updated) {
        Link link = findById(updated.getId());
        links.remove(link);
        links.add(updated);
        return updated;
    }

    public Link deleteLink(String id) {
        Link link = findById(id);
        links.remove(link);
        return link;
    }
}
