package com.tecsup.petclinic.controllers;

import static org.hamcrest.CoreMatchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
public class OwnerControllerTest {
	private static final Logger logger 
	= LoggerFactory.getLogger(OwnerControllerTest.class);

	private static final ObjectMapper om = new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetOwners() throws Exception {
	
	//int SIZE = 216;
	int ID_FIRST = 1;
	//int ID_LAST = 332;  
	
	this.mockMvc.perform(get("/owners"))
				.andExpect(status().isOk()) // HTTP 200
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
							    // ACTUAL      EXPECTED 
				//.andExpect(jsonPath("$", hasSize(SIZE)))
				.andExpect(jsonPath("$[0].id", is(ID_FIRST)));
				//.andExpect(jsonPath("$[212].id", is(ID_LAST)));
	}
	
	@Test
	public void testFindOwnerOK() throws Exception {

		int ID_SEARCH = 13;
		String FIRST_NAME = "Luis";
		String LAST_NAME = "Carrillo";
		String ADDRESS = "av. casuarinas";
		String CITY = "Santa Anita";
		String TELEPHONE = "9999999999";

		/*
		 {
		    "id": 1,
		    "name": "Leo",
		    "typeId": 1,
		    "ownerId": 1,
		    "birthDate": "2000-09-07"
		}
		 */
		
		mockMvc.perform(get("/owners/" + ID_SEARCH))  // Finding object with ID = 1
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				//.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(13)))
				.andExpect(jsonPath("$.first_name", is(FIRST_NAME)))
				.andExpect(jsonPath("$.last_name", is(LAST_NAME)))
				.andExpect(jsonPath("$.address", is(ADDRESS)))
				.andExpect(jsonPath("$.city", is(CITY)))
				.andExpect(jsonPath("$.telephone", is(TELEPHONE)));

	}
	
	@Test
	public void testFindOwnerKO() throws Exception {

		int ID_SEARCH = 666;

		
		mockMvc.perform(get("/owners/" + ID_SEARCH)) // Finding object with ID = 666
				.andExpect(status().isNotFound());

	}
	
}
