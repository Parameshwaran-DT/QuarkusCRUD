package com.example.resource;

import com.example.repository.UserRepository;
import com.example.entity.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {


    @Inject
    UserRepository repository;


    @GET
    public Iterable<User> list() {
        return repository.listAll();
    }


    @POST
    public User create(User user) {
        repository.persist(user);
        return user;
    }


    @PUT
    @Path("/{id}")
    public User update(@PathParam("id") Long id, User user) {
        User existingUser = repository.findById(id);
        existingUser.name = user.name;
        existingUser.email = user.email;
        repository.persist(existingUser);
        return existingUser;
    }


    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        repository.deleteById(id);
    }
}

