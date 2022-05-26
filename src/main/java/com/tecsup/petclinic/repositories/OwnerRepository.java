package com.tecsup.petclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tecsup.petclinic.entities.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long>{

	// Fetch pets by name
		List<Owner> findById(String owner_id);
	
}
