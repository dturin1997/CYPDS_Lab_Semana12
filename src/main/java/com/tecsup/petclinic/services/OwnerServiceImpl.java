package com.tecsup.petclinic.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.repositories.OwnerRepository;

public class OwnerServiceImpl implements OwnerService{
	

	@Autowired
	OwnerRepository ownerRepository;
	
	@Override
	public Owner create(Owner owner) {
		return ownerRepository.save(owner);
	}
}
