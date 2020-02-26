package com.howtographql.demo;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

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

    public User createUser(String id, String name, String email, String password) {
        User newUser = new User(id, name, email, password);
        return userRepository.saveUser(newUser);
    }
}