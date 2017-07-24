package com.hkyang.hello;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Autowired
	private HelloSpring helloSpring;

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String message = helloSpring.sayHello(name);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("message", message);
		
		return new ModelAndView("/WEB-INF/view/hello.jsp", model);
	}
}
