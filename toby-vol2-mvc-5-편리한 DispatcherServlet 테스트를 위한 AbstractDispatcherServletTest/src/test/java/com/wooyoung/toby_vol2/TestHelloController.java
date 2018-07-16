package com.wooyoung.toby_vol2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class TestHelloController extends AbstractDispatcherServletTest {
	@Test
	public void test1() throws ServletException, IOException {
		ModelAndView mav = setRelativeLocations("spring-servlet.xml").setClasses(HelloSpring.class)
				.initRequest("/hello", RequestMethod.GET).addParameter("name", "Spring").runService().getModelAndView();

		assertThat(mav.getViewName(), is("hello"));
		assertThat((String) mav.getModel().get("message"), is("Hello Spring"));
	}

	@Test
	public void test2() throws ServletException, IOException {
		setRelativeLocations("spring-servlet.xml").setClasses(HelloSpring.class);
		initRequest("/hello", "GET").addParameter("name", "Spring");
		runService().assertModel("message", "Hello Spring").assertViewName("hello");
	}
}
