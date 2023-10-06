package com.example.restapi.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
	/**
	 * HATEOAS is achieved by including hyperlinks in the responses from the server
	 * to the client. These hyperlinks tell the client what actions it can take next
	 * and what resources are available to it. This allows the client to navigate
	 * through the application without having to know the specific details of the
	 * application's implementation.
	 * 
	 * Step:1] add dependency 
	 * <dependency>
	 * <groupId>org.springframework.boot</groupId>
	 * <artifactId>spring-boot-starter-hateoas</artifactId> </dependency>
	 * 
	 * Step:2] EntityModel/RepresentationalModel - to wrap the model with entity class(make it compatible to add links)
	 * Step:3] 
	 */
	@Autowired
	private UserDaoService userDaoService;

	private MessageSource messageSource;

	public UserController(MessageSource messageSourc) {
		this.messageSource = messageSourc;
	}

	@GetMapping("/users")
	protected List<User> findAllUsers() {
		return userDaoService.findAllUsers();
	}

	@GetMapping("/hello-user-internationalized/{id}")
	private String helloUserInternationalised(@PathVariable int id) {

		User user = userDaoService.findUserById(id);
		if (user == null) {
			throw new UserNotFoundException("id:" + id);
		}
		Locale locale = LocaleContextHolder.getLocale();
		return "Hello " + user.getName() + ", "
				+ messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}

	@GetMapping("/user/{id}")
	private EntityModel<User> findOneUser_v1(@PathVariable int id) throws Exception {
		User user = userDaoService.findUserById(id);
		if (user == null) {
			throw new UserNotFoundException("id:" + id);
		}
		
		EntityModel<User> userEntity = EntityModel.of(user);
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAllUsers());
		userEntity.add(link.withRel("all-users"));
		return userEntity;
	}

	@DeleteMapping("/user/{id}")
	private void deleteAUser(@PathVariable int id) throws UserNotFoundException {
		userDaoService.deleteUserById(id);
	}

	@PostMapping("/user")
	private ResponseEntity<User> createNewUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.createUser(user);

		// adding location uri once new entry is created, it will return with new id
		// buildandexpand is used to replace path parameter
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

}
