package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

public interface OwnerService {
	Owner create(Owner own);
	void delete(Long id) throws OwnerNotFoundException;
	Owner findById(long id) throws OwnerNotFoundException;
}
