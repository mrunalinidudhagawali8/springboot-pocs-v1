package com.example.restapi.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

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

import com.example.restapi.dao.UserDao_nonJPA;
import com.example.restapi.exception.UserNotFoundException;
import com.example.restapi.model.Post;
import com.example.restapi.model.User;
import com.example.restapi.repo.PostRepository;
import com.example.restapi.repo.UserRepository;

@RestController
public class UserPostController {
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
	private UserDao_nonJPA userDaoNonJPA;

	@Autowired
	UserRepository userRepo;

	@Autowired
	PostRepository postRepo;

	private MessageSource messageSource;

	public UserPostController(MessageSource messageSourc) {
		this.messageSource = messageSourc;
	}

	@GetMapping("/users")
	protected List<User> findAllUsers() {
		return userDaoNonJPA.findAllUsers();
	}

	@GetMapping("/hello-user-internationalized/{id}")
	private String helloUserInternationalised(@PathVariable int id) {

		User user = userDaoNonJPA.findUserById(id);
		if (user == null) {
			throw new UserNotFoundException("id:" + id);
		}
		Locale locale = LocaleContextHolder.getLocale();
		return "Hello " + user.getName() + ", "
				+ messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}

	@GetMapping("/user/{id}")
	private EntityModel<User> findOneUser_v1(@PathVariable int id) throws Exception {
		User user = userDaoNonJPA.findUserById(id);
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
		userDaoNonJPA.deleteUserById(id);
	}

	@PostMapping("/user")
	private ResponseEntity<User> createNewUser(@Valid @RequestBody User user) {
		User savedUser = userDaoNonJPA.createUser(user);

		// adding location uri once new entry is created, it will return with new id
		// buildandexpand is used to replace path parameter
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	//JPA -------------------------------------------------------------------------------------------------------------

	@GetMapping("jpa/users")
	protected List<User> findAllUsersJPA() {
		return userRepo.findAll();
	}

	@GetMapping("jpa/hello-user-internationalized/{id}")
	private String helloUserInternationalisedJpa(@PathVariable int id) {

		Optional<User> user = userRepo.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id:" + id);
		}
		Locale locale = LocaleContextHolder.getLocale();
		return "Hello " + user.get().getName() + ", "
				+ messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}

	@GetMapping("jpa/user/{id}")
	private EntityModel<User> findOneUser_v1_jpa(@PathVariable int id) throws Exception {
		Optional<User> user = userRepo.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id:" + id);
		}

		EntityModel<User> userEntity = EntityModel.of(user.get());

		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAllUsersJPA());
		userEntity.add(link.withRel("all-users-db"));
		return userEntity;
	}

	@DeleteMapping("jpa/user/{id}")
	private void deleteAUserJpa(@PathVariable int id) throws UserNotFoundException {
		Optional<User> user = userRepo.findById(id);
		userRepo.delete(user.get());
	}

	@PostMapping("jpa/user")
	private ResponseEntity<User> createNewUser_JPA(@Valid @RequestBody User user) {
		User savedUser = userRepo.save(user);

		// adding location uri once new entry is created, it will return with new id
		// buildandexpand is used to replace path parameter
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping("jpa/user/{id}/posts")
	private List<Post> getAllPostsOfUser(@PathVariable int id) throws UserNotFoundException {
		Optional<User> user = userRepo.findById(id);

		if (user.isEmpty()) {
			throw new UserNotFoundException("User not found!");
		}

		return user.get().getPosts();
	}

	@PostMapping("jpa/user/{id}/post")
	private ResponseEntity<User> createNewPost_JPA(@Valid @RequestBody Post post, @PathVariable int id) {
		Optional<User> user = userRepo.findById(id);
		
		if(user.isEmpty())
			throw new UserNotFoundException("User Id" + id + " not found!");
		
		post.setUser(user.get());
		Post savedPost = postRepo.save(post);

		// adding location uri once new entry is created, it will return with new id
		// buildandexpand is used to replace path parameter
		URI location = ServletUriComponentsBuilder.fromPath("jpa/user/{id}/posts").buildAndExpand(savedPost.getUser().getId()).toUri();

		return ResponseEntity.created(location).build();
	}

}
