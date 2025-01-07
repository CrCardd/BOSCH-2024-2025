package com.desktopapp.repository;

import com.desktopapp.Context;

public abstract class repository<T> {

    public void create(T item) {
        Context ctx = new Context();
        ctx.begin();
        ctx.persist(item);
        ctx.commit();
    }

    public void update(T item){
        Context ctx = new Context();
        ctx.begin();
        ctx.update(item);    
        ctx.commit();
    }

    public void delete(T item) {
        Context ctx = new Context();
        ctx.begin();
        ctx.delete(item);    
        ctx.commit();
    }
}
