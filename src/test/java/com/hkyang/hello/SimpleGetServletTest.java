package com.hkyang.hello;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class SimpleGetServletTest {

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		MockHttpServletRequest req = new MockHttpServletRequest("GET", "/hello");
		req.addParameter("name", "Spring");
		
		MockHttpServletResponse res = new MockHttpServletResponse();
		
		SimpleGetServlet servlet = new SimpleGetServlet();
		servlet.service(req, res);
		
		assertThat(res.getContentAsString(), is("<html><body>Hello Spring</body></html>"));
	}

}
