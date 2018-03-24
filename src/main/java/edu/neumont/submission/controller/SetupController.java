package edu.neumont.submission.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.neumont.submission.service.BootstrapService;

@Controller
public class SetupController {
	@Inject BootstrapService b;
	
	@RequestMapping(value="/setup")
	public
	@ResponseBody String setup() {
		b.setup();
		
		return "OK";
	}
	
	@RequestMapping(value="/setup-round-two")
	public
	@ResponseBody String setupRoundTwo() {
		b.setupRoundTwo();
		
		return "OK";
	}
	
	@RequestMapping(value="/setup-round-three")
	public
	@ResponseBody String setupRoundThree() {
		b.setupRoundThree();
		
		return "OK";
	}
	
	@RequestMapping(value="/setup-round-four")
	public
	@ResponseBody String setupRoundFour() {
		b.setupRoundFour();
		
		return "OK";
	}

	@RequestMapping(value="/setup-round-five")
	public
	@ResponseBody String setupRoundFive() {
		b.setupRoundFive();
		
		return "OK";
	}
	
	@RequestMapping(value="/setup-round-six")
	public
	@ResponseBody String setupRoundSix() {
		b.setupRoundSix();
		
		return "OK";
	}
}
