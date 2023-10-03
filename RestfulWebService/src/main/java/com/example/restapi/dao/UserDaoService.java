package com.example.restapi.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.restapi.model.User;

@Component
public class UserDaoService {
	
	//JPA/Hibernate --> will connecct with Db
	private static List<User> users = new ArrayList<User>();
	
	public static int id = 0;
	
	static {
		users.add(new User(++id, "Mrunalini", LocalDate.now().minusYears(25)));
		users.add(new User(++id, "Devu", LocalDate.now().minusYears(26)));
		users.add(new User(++id, "Riya", LocalDate.now().minusYears(23)));
	}
	//findAlluser
	public List<User> findAllUsers()
	{
		return users;
	}
	//saveUser
	public User createUser(User user)
	{
		user.setId(++id);
		users.add(user);
		return user;
	}
	//findOne
	public User findUserById(int id)
	{
		return users.stream().filter(user->user.getId()==id).findFirst().orElse(null);
	}
}
