package com.inmyshow.webbase.action;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.inmyshow.webbase.config.DefaultAppConfig;
import com.inmyshow.webbase.config.DispatcherConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { DefaultAppConfig.class,
		DispatcherConfig.class })
public class TestActionTest {
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testDodododo() throws Exception {
		mockMvc.perform(get("/user.do").accept(MediaType.TEXT_HTML)).andExpect(
				status().isOk());
	}

	@Test
	public void testHelloWorld() throws Exception {
		mockMvc.perform(get("/helloWorld").accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk())
				.andExpect(model().attribute("message", "Hello World!"));
				//.andDo(print());
	}

	@Test
	public void testError404() throws Exception {
		mockMvc.perform(get("/helloWorld1")).andExpect(status().isNotFound());
	}
}
