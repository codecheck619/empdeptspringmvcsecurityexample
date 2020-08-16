package com.deptempspbsecurityi18.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.deptempspbsecurityi18.model.Department;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
public class DeptEmpTestController {
	
	private MockMvc mockMvc;
	@Autowired(required = true)
	private WebApplicationContext context;
	
	ObjectMapper objMap = new ObjectMapper();
	@Before
	public void configureMvcMock()
	{
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
@Test
	public void addDeptTest() throws Exception
	{
		Department dept = new Department(1,"Training","Pune");
		String jasonReq=objMap.writeValueAsString(dept);
		MvcResult result = mockMvc.perform(post("/savedept")
				.content(jasonReq).contentType(MediaType
						.APPLICATION_JSON_VALUE)).andExpect(status()
								.isOk()).andReturn();
		
	}
}
