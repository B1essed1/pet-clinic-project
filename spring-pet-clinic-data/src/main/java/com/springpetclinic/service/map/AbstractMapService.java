package com.springpetclinic.service.map;
import com.springpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long>
{
    protected Map<Long,T> map = new HashMap();

    Set<T> findAll()
    {

        return new HashSet<>(map.values());
    }

    T findById(ID id)
    {
        return map.get(id);
    }

    T save( T object )
    {
        if (object != null)
        {
            if (object.getId() == null)
            {
                object.setId(getNextId());
            }
        }
        else
            {
            throw new RuntimeException("Object can not be null");
        }

        map.put(object.getId(), object);
        return object;
    }

    void delete(T object)
    {
        map.entrySet().removeIf(en->en.getValue().equals(object));
    }

    void deleteById(ID id)
    {
        map.remove(id);
    }
    Long getNextId()
    {
        Long nextId = null;
        try
        {
            return nextId = Collections.max(map.keySet())+1;
        } catch (NoSuchElementException e){
            return nextId = 1l;
        }
    }
}
