package com.tecsup.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.entities.Pet;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
