package com.seeth.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloController {

	
	@GetMapping("/all")
	public String hello() {
		return "Hello";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/secured/all")
	public String securedHello() {
		return "Secured Hello";
	}
	
	
}
