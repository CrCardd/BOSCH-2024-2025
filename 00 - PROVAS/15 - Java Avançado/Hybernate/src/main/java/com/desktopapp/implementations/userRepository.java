package com.desktopapp.implementations;

import java.util.List;

import com.desktopapp.Context;
import com.desktopapp.model.User;
import com.desktopapp.repository.repository;

public class userRepository extends repository<User> {
    
    public List<User> getByName(String name){
        Context ctx = new Context();
        String query_str = "FROM User u WHERE u.name = :name";
        var query = ctx.createQuery(User.class, query_str);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public List<User> getByEmail(String email){
        Context ctx = new Context();
        String query_str = "FROM User u WHERE u.email = :email";
        var query = ctx.createQuery(User.class, query_str);
        query.setParameter("email", email);
        return query.getResultList();
    }

    public User getById(Long id){
        Context ctx = new Context();
        String query_str = "FROM User u WHERE Id = :id";
        var query = ctx.createQuery(User.class, query_str);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
