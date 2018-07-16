package com.wooyoung.toby_vol2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.web.servlet.ModelAndView;

import com.wooyoung.toby_vol2.ConfigurableDispatcherServlet;
import com.wooyoung.toby_vol2.HelloSpring;

public class TestHelloController {
	@Test
	public void test() throws Exception {
		ConfigurableDispatcherServlet servlet = new ConfigurableDispatcherServlet();
		servlet.setRelativeLocations(getClass(), "spring-servlet.xml");
		servlet.setClasses(HelloSpring.class);
		
		servlet.init(new MockServletConfig("spring"));
		
		MockHttpServletRequest req = new MockHttpServletRequest("GET", "/hello");
		req.addParameter("name", "Spring");
		
		MockHttpServletResponse res = new MockHttpServletResponse();
		servlet.service(req, res);
		
		ModelAndView mav = servlet.getModelAndView();
		assertThat(mav.getViewName(), is("hello"));
		assertThat((String)mav.getModel().get("message"), is("Hello Spring"));
	}
}
