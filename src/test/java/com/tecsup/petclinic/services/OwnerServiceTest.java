package com.tecsup.petclinic.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Owner;

@SpringBootTest
public class OwnerServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);

	@Autowired
     private OwnerService ownerService;

	@Test
	public void testCreateOwner() {

		String OWNER_FIRSTNAME = "Luis";
		String OWNER_LASTNAME = "Martinez";
		String OWNER_ADDRESS = "Av. Girasoles 345";
		String OWNER_CITY = "Lima";
		String OWNER_TELEPHONE = "999999999";

		Owner owner = new Owner(OWNER_FIRSTNAME, OWNER_LASTNAME, OWNER_ADDRESS, OWNER_CITY, OWNER_TELEPHONE);
		
		Owner ownerCreated = ownerService.create(owner);
		
		logger.info("OWNER CREATED :" + ownerCreated);

		//          ACTUAL                 , EXPECTED 
		assertThat(ownerCreated.getId()      , notNullValue());
		assertThat(ownerCreated.getFirst_name()    , is(OWNER_FIRSTNAME));
		assertThat(ownerCreated.getLast_name() , is(OWNER_LASTNAME));
		assertThat(ownerCreated.getAddress()  , is(OWNER_ADDRESS));
		assertThat(ownerCreated.getCity()  , is(OWNER_CITY));
		assertThat(ownerCreated.getTelephone()  , is(OWNER_TELEPHONE));

	}
}
