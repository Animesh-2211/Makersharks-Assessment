package com.spring.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springrest.model.User;
import com.spring.springrest.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController{
	
	@Autowired
	private UserService userService;
	

@PostMapping("/register")
public ResponseEntity<String> registerUser(@RequestBody User user) {
//	boolean isregisterd=userService.checkUser(user);
//	if(isregisterd) {
//		userService.registerUser(user);
//		return ResponseEntity.ok("User registerd successfully.");
//		
//	}else {
//		return ResponseEntity.badRequest().body("User registration failed as User already exists");
//	}
	if(userService.checkUser(user.getUsername())) {
		return ResponseEntity.badRequest().body("User registration failed as User already exists");
	}
	
	userService.registerUser(user);
	  return ResponseEntity.ok("User Successfully Registered.");
	}

	
	
	
   @GetMapping("/fetch")
  public ResponseEntity<User> fetchUser(@RequestParam  String username) {
	 User user=  userService.fetchUser(username);
	 if(user !=null) {
		 return ResponseEntity.ok(user);
	 }
	 else {
		 return ResponseEntity.notFound().build();
	 }
	
	

	
}
}