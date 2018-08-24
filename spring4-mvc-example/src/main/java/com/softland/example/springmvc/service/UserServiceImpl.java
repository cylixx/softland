package com.softland.example.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softland.example.springmvc.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	//Creates a new AtomicLong with initial value 0.
	private static final AtomicLong counter = new AtomicLong();  
	private static List<User> users;
	
	static {
		users = populateDummyUsers();
	}
	

	@Override
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	@Override
	public List<User> findAllUsers() {
		return users;
	}
	
	@Override
	public User findByName(String name) {
		for(User user : users) {
			if (user.getName().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}
	
	@Override
	public boolean isUserExist(User user) {
		return findByName(user.getName()) != null;
	}
	
	private static List<User> populateDummyUsers() {
        List<User> users = new ArrayList<User>();
        users.add(new User(counter.incrementAndGet(),"Sam",30));
        users.add(new User(counter.incrementAndGet(),"Tom",40));
        users.add(new User(counter.incrementAndGet(),"Jerome",45));
        users.add(new User(counter.incrementAndGet(),"Silvia",50));
        return users;
    }

}
