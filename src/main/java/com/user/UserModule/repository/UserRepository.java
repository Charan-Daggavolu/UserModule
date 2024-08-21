package com.user.UserModule.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.UserModule.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, String> {
    Users findByUsername(String username);

    List<Users> findByFirstName(String firstName);
}
