package com.oreo.charity.webTier;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oreo.charity.beans.Event;
import com.oreo.charity.middleTier.CreateEventService;
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

	@RequestMapping(value = { "/home" }, method = { RequestMethod.GET })
	public String test(HttpSession session) {
		/*
		 * System.out.println("in Controller"); delegate.test();
		 */
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

	@RequestMapping(value = "/home/insert", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody HttpEntity createEvent(@RequestBody @Valid Event event, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity("Failed", HttpStatus.BAD_REQUEST);
		}
		// businessDelegate.createReservation(reservation);
		return new ResponseEntity<Event>(event, HttpStatus.CREATED);
	}
}


