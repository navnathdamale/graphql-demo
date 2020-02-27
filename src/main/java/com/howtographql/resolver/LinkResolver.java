package com.howtographql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.howtographql.model.Link;
import com.howtographql.model.User;
import com.howtographql.repository.UserRepository;

/**
 * Contains Link sub-queries
 */
public class LinkResolver implements GraphQLResolver<Link> {
    
    private final UserRepository userRepository;

    public LinkResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User postedBy(Link link) {
        if (link.getUserId() == null) {
            return null;
        }
        return userRepository.findById(link.getUserId());
    }
}
