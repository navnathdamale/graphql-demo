package com.howtographql.resolver;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.howtographql.model.Link;
import com.howtographql.model.User;
import com.howtographql.repository.LinkRepository;
import com.howtographql.repository.UserRepository;

import java.util.List;

/**
 * Query root. Contains top-level queries.
 */
public class Query implements GraphQLRootResolver {

    private final LinkRepository linkRepository;

    private final UserRepository userRepository;

    public Query(LinkRepository linkRepository, UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }

    public List<Link> allLinks() {
        return linkRepository.getAllLinks();
    }

    public List<User> allUsers() {
        return userRepository.getAllUsers();
    }

    public Link link(String id) {
        return linkRepository.findById(id);
    }

    public User user(String id) {
        return userRepository.findById(id);
    }
}
