package com.kodigo.managmentflights.DAL;

import com.kodigo.managmentflights.Entities.Entity;

import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public abstract class InMemoryRepository<T extends Entity> implements  IRepository<T>{
   protected Set<T> entities = new HashSet<>();

    @Override
    public T create(T t)  {
        entities.add(t);
        return t;
    }

    @Override
    public void delete(T t) {
       entities.remove(t);
    }

    @Override
    public T find(T t) {
       for(T e:entities){
           if (e.equals(t) ){
               return e;
           }
       }
       return null;
    }

    @Override
    public T update(T t) {
       for(T e:entities){
           if (e.equals(t)){
               entities.remove(e);

               entities.add(t);
               break;
           }
       }

       return t;
    }

    @Override
    public Set<T> findAll() {
        return Collections.unmodifiableSet(entities);
    }
}
