package com.tecsup.petclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.entities.Pet;

@Repository
public interface OwnerRepository 
	extends CrudRepository<Pet, Long> {
	
	// Fetch pets by name
	List<Owner> findByName(String name);

	// Fetch pets by typeId
	List<Owner> findByTypeId(int typeId);

	// Fetch pets by ownerId
	List<Owner> findByOwnerId(int ownerId);

}
