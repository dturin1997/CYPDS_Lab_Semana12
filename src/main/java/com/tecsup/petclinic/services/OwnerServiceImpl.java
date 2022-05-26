package com.tecsup.petclinic.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.repositories.OwnerRepository;

public class OwnerServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceImpl.class);

	@Autowired
	OwnerRepository ownerRepository;
	
	public Owner update(Owner own) {
		return ownerRepository.save(own);
	}
	
	
	//Busqueda por Id
	@Autowired
	public Owner findById(long id) throws OwnerNotFoundException {

		Optional<Owner> own = ownerRepository.findById(id);

		if ( !own.isPresent())
			throw new OwnerNotFoundException("Record not found...!");
			
		return own.get();
	}
}
