package com.tecsup.petclinic.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;


@SpringBootTest
public class OwnerServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);
	
	@Autowired
	private OwnerService ownerService;
	
	@Test
	public void testDeleteOwner() {

		String first_name = "Dario";
		String last_name = "Turin";
		String address = "Av. Siempre viva 2118";
		String city = "Lima";
		String telephone = "963852147";

		Owner own = new Owner(first_name, last_name, address,city,telephone);
		own = ownerService.create(own);
		logger.info("" + own);

		try {
			ownerService.delete(own.getId());
		} catch (OwnerNotFoundException e) {
			assertThat(e.getMessage(), false);
		}
			
		try {
			ownerService.findById(own.getId());
			assertThat(true, is(false));
		} catch (OwnerNotFoundException e) {
			assertThat(true, is(true));
		} 				

	}
}
