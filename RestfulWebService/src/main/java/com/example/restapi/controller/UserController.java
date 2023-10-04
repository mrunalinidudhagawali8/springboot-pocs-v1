package com.example.restapi.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.restapi.dao.UserDaoService;
import com.example.restapi.exception.UserNotFoundException;
import com.example.restapi.model.User;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	private List<User> findAllUsers()
	{
		return userDaoService.findAllUsers();
	}
	
	@GetMapping("/user/{id}")
	private User findOneUser(@PathVariable int id) throws Exception
	{
		User user = userDaoService.findUserById(id);
		if(user==null)
		{
			throw new UserNotFoundException("id:"+id);
		}
		return user;
	}
	
	@DeleteMapping("/user/{id}")
	private void deleteAUser(@PathVariable int id) throws UserNotFoundException
	{
		userDaoService.deleteUserById(id);
	}
	
	@PostMapping("/user")
	private ResponseEntity<User> createNewUser(@Valid @RequestBody User user)
	{
		 User savedUser = userDaoService.createUser(user);
		 
		 //adding location uri once new entry is created, it will return with new id
		 //buildandexpand is used to replace path parameter
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		 
		 return ResponseEntity.created(location).build();
	}
	

}
