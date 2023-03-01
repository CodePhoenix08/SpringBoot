package com.example.fb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.fb.module.User;
import com.example.fb.service.UserService;
@RestController
public class UserController {
	@Autowired
	UserService s;
	@PostMapping("/Adduser")
	ResponseEntity<User> addUser(@RequestBody User u){
		return new ResponseEntity<User>(s.addUser(u),HttpStatus.CREATED);
	}
	@GetMapping("/login")
	ResponseEntity<Object >login(@RequestHeader String usernameOremail,@RequestHeader String password){
		Object o=s.login(usernameOremail, password);
		if(o instanceof User) {
			return  ResponseEntity.status(200).body(s.login(usernameOremail, password));
		}
		return  ResponseEntity.status(400).body(s.login(usernameOremail, password));
	}

}
