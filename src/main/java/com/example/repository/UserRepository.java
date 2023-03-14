package com.example.repository;

import javax.enterprise.context.ApplicationScoped;

import com.example.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;


@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
}
