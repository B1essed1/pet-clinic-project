package com.springpetclinic.service;

import com.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>
{
    Owner findByLastName(String lastName);
}
