package com.howtographql.resolver;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.howtographql.model.Link;
import com.howtographql.repository.LinkRepository;
import com.howtographql.model.User;
import com.howtographql.repository.UserRepository;

/**
 * Mutation root
 */
public class Mutation implements GraphQLRootResolver {

    private final LinkRepository linkRepository;
    private final UserRepository userRepository;

    public Mutation(LinkRepository linkRepository, UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }

    public Link createLink(String id, String url, String description, String userId) {
        Link newLink = new Link(id, url, description, userId);
        linkRepository.saveLink(newLink);
        return newLink;
    }

    public Link updateLink(String id, String url, String description, String userId) {
        Link link = new Link(id, url, description, userId);
        return linkRepository.updateLink(link);
    }

    public User createUser(String id, String name, String email, String password) {
        User newUser = new User(id, name, email, password);
        return userRepository.saveUser(newUser);
    }

    public Link deleteLink(String id) {
        return linkRepository.deleteLink(id);
    }
}