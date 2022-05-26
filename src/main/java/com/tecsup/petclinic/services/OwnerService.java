package com.tecsup.petclinic.services;

import com.tecsup.petclinic.exception.PetNotFoundException;

public interface OwnerService {
	void delete(Long id) throws PetNotFoundException;
}
