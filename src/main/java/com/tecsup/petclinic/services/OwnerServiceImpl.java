package com.tecsup.petclinic.services;

import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Pet;

public class OwnerServiceImpl {
	@Override
	public Owner create(Owner owner) {
		return ownerRepository.save(owner);
	}
}
