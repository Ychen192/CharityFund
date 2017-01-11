package com.oreo.charity.webTier;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oreo.charity.beans.User;
import com.oreo.charity.dataTier.UserDAO;
import com.oreo.charity.middleTier.Delegate;

@Controller
public class CharityController {
	
	
	private Delegate delegate;

	@Autowired
	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}
	
	@RequestMapping(value = { "/" }, method = { RequestMethod.GET })
	public String getHome(HttpSession session) {
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = { "/home" }, method = { RequestMethod.GET })
	public String test(HttpSession session) {
		System.out.println("in Controller");
		delegate.test();	
		return "charityHome";
	}
	
	@ResponseBody
	@RequestMapping(value = { "/testget" }, method = { RequestMethod.GET })
	public String testget(HttpSession session) {
		return delegate.testGet().toString();
	}
	
	@ResponseBody
	@RequestMapping(value = { "/login" }, method = { RequestMethod.POST })
	public String login (HttpSession session) {
		return "test";
	}
	
	


}


