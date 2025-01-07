package com.desktopapp.implementations;

import java.util.List;

import com.desktopapp.Context;
import com.desktopapp.model.Message;
import com.desktopapp.repository.repository;

public class messageRepository extends repository<Message>{

    public List<Message> getMessagesByUser(Long id){
        Context ctx = new Context();
        String query_str = "FROM Message m WHERE m.id_from = :id";
        var query = ctx.createQuery(Message.class, query_str);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
