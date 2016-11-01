package com.frank.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by frankzhu on 1/11/16.
 */
public interface UserDao extends CrudRepository<User, Long> {

    Optional<User> findUserByNameAndEmail(String name, String email);
}
