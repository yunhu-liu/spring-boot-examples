package com.luitech.springbootexamples.data;

import com.luitech.springbootexamples.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}