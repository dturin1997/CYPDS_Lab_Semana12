package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;

import com.tecsup.petclinic.exception.OwnerNotFoundException;

public interface OwnerService {

	Owner findById(long id) throws OwnerNotFoundException;
}