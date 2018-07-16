package com.wooyoung.toby_vol2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.wooyoung.toby_vol2.SimpleGetServlet;

public class TestSimpleGetServlet {

	@Test
	public void test() throws Exception {
		MockHttpServletRequest req = new MockHttpServletRequest();
		req.setMethod("GET");
		req.addParameter("name", "Spring");
		MockHttpServletResponse res = new MockHttpServletResponse();
		
		SimpleGetServlet servlet = new SimpleGetServlet();
		servlet.service(req, res);
		
		assertThat(res.getContentAsString(), is("<html><body>Hello Spring</body></html>"));
	}
	
	@Test
	public void test1() throws Exception {
		MockHttpServletRequest req = new MockHttpServletRequest();
		req.setMethod("GET");
		req.addParameter("name", "Spring");
		MockHttpServletResponse res = new MockHttpServletResponse();
		
		SimpleGetServlet servlet = new SimpleGetServlet();
		servlet.service(req, res);
		
		String str = res.getContentAsString();
		
		assertThat(str.contains("Hello Spring"), is(true));
	}
}
