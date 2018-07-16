package com.wooyoung.toby_vol2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.wooyoung.toby_vol2.HelloController;

public class TestNotUsedServletHelloController {
	@Test
	public void test() throws Exception {
		ApplicationContext ac = new GenericXmlApplicationContext("com/wooyoung/toby_vol2/spring-servlet.xml");
		HelloController helloController = ac.getBean(HelloController.class);
				
		MockHttpServletRequest req = new MockHttpServletRequest("GET", "/hello");
		req.addParameter("name", "Spring");		
		MockHttpServletResponse res = new MockHttpServletResponse();
		
		ModelAndView mav = helloController.handleRequest(req, res);
		assertThat(mav.getViewName(), is("hello"));
		assertThat((String)mav.getModel().get("message"), is("Hello Spring"));
	}
}
