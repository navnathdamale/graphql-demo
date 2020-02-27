package com.howtographql.repository;

import com.howtographql.model.Link;

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
        links.add(new Link("link-01", "http://custom.demo.org/1/", "Your favorite GraphQL page-1", "user-01"));
        links.add(new Link("link-02", "http://custom.demo.org/2/", "Your favorite GraphQL page-2", "user-02"));
        links.add(new Link("link-03", "http://custom.demo.org/3/", "Your favorite GraphQL page-3", "user-03"));
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
