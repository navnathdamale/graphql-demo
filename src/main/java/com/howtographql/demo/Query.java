package com.howtographql.demo;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import java.util.List;

/**
 * Query root. Contains top-level queries.
 */
class Query implements GraphQLRootResolver {

    private final LinkRepository linkRepository;

    private final UserRepository userRepository;

    public Query(LinkRepository linkRepository, UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }

    public List<Link> allLinks() {
        return linkRepository.getAllLinks();
    }

    public Link link(String id) {
        return linkRepository.findById(id);
    }

    public User user(String id) {
        return userRepository.findById(id);
    }
}
