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

		String FIRST_NAME = "Angelo";
		String LAST_NAME = "Suarez";
		String ADDRESS = "av. bocanegra";
		String CITY = "Lima";
		String TELEPHONE = "12154545";

		Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE);
		
		Owner ownerCreated = ownerService.create(owner);
		
		logger.info("OWNER CREATED :" + ownerCreated);

		//          ACTUAL                 , EXPECTED 
		assertThat(ownerCreated.getId()      , notNullValue());
		assertThat(ownerCreated.getFirst_name()    , is(FIRST_NAME));
		assertThat(ownerCreated.getLast_name() , is(LAST_NAME));
		assertThat(ownerCreated.getAddress()  , is(ADDRESS));
		assertThat(ownerCreated.getCity()  , is(CITY));
		assertThat(ownerCreated.getTelephone()  , is(TELEPHONE));

	}

	
	@Test
	public void testUpdateOwnerById() {
		
		String FIRST_NAME = "Miguel";
		String LAST_NAME = "Medina";
		String ADDRESS = "av. bocanegra";
		String CITY = "Callao";
		String TELEPHONE = "935154858";
		long created_id = -1;
		//UPDATE
		
		String UP_FIRST_NAME = "Luis";
		String UP_LAST_NAME = "Carrillo";
		String UP_ADDRESS = "av. casuarinas";
		String UP_CITY = "Santa Anita";
		String UP_TELEPHONE = "9999999999";
		
		Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE);
		
		logger.info(">" + owner);
		Owner ownerCreated = ownerService.create(owner);
		logger.info(">>" + ownerCreated);
		
		created_id = ownerCreated.getId();
		
		ownerCreated.setId(created_id);
		ownerCreated.setFirst_name(UP_FIRST_NAME);
		ownerCreated.setLast_name(UP_LAST_NAME);
		ownerCreated.setAddress(UP_ADDRESS);
		ownerCreated.setCity(UP_CITY);
		ownerCreated.setTelephone(UP_TELEPHONE);
		
		//Execute update
		
		Owner upgradeOwner = ownerService.update(ownerCreated);
		logger.info(">>>>" + upgradeOwner);
		
		//		ACTUAL				EXPECTED
		assertThat(created_id ,notNullValue());
		assertThat(upgradeOwner.getId(), is(created_id));
		assertThat(upgradeOwner.getFirst_name(), is(UP_FIRST_NAME));
		assertThat(upgradeOwner.getLast_name(), is(UP_LAST_NAME));
		assertThat(upgradeOwner.getAddress(), is(UP_ADDRESS));
		assertThat(upgradeOwner.getCity(), is(UP_CITY));
		assertThat(upgradeOwner.getTelephone(), is(UP_TELEPHONE));
		
	}
	
}
