package com.project.technicalTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.technicalTest.models.User;
import com.project.technicalTest.services.UserService;

@RestController 
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*@author Johnny El Beyrouthy
	 *@see A get webservice linked to the following url is localhost:8080/user/{userName}
	 * */
	@GetMapping("/{userName}")
	public User getUserByName(@PathVariable(value = "userName") String name ) {
		return this.userService.findByName(name);
		
	}
	
	/*@author Johnny El Beyrouthy
	 *@see A get webservice linked to the following url is localhost:8080/user/createUser
	 * */
	@PostMapping("/createUser")
	public ResponseEntity<User> createUSer(@RequestBody User user) {
		return new ResponseEntity<User>( userService.saveUser(user), HttpStatus.CREATED);
	
	}
	
}
