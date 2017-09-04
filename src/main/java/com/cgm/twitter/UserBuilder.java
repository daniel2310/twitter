package com.cgm.twitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

public class UserBuilder {
	public static List<User> users;
	public static Map<String, ArrayList<String>> friends;
	

	public static User anUser() {
		User user = new User();
		user.setName("daniel");
		user.setPassword("12345");

		return user;
	}

	/*
	 * public static List<User> users() { List<User> users = new ArrayList<User>();
	 * 
	 * 
	 * User florian = new User(); florian.setName("florian");
	 * florian.setPassword("florian"); return users; }
	 */
/*
	public static List<User> friends() {
		List<User> friends = new ArrayList<User>();

		User andrei = new User();
		andrei.setName("Nica");

		User alex = new User();
		alex.setName("Iliescu");

		friends.add(alex);
		friends.add(andrei);

		return friends;
	}
*/
	
	
	static {
		users = new ArrayList<User>();
		friends = new HashMap<String, ArrayList<String>>();
		

		User daniel = new User();
		daniel.setName("daniel");
		daniel.setPassword("12345");

		User andrei = new User();
		andrei.setName("andrei");
		andrei.setPassword("andrei");
		friends.put("daniel", new ArrayList<String>());
		

		User florin = new User();
		florin.setName("florin");
		florin.setPassword("florin");
		friends.put("daniel", new ArrayList<String>());
		friends.put("andrei", new ArrayList<String>());
		friends.put("florin", new ArrayList<String>());
		friends.get("florin").add("andrei");
		friends.get("florin").add("daniel");
		friends.get("daniel").add("florin");
		friends.get("andrei").add("florin");

		users.add(florin);
		users.add(daniel);
		users.add(andrei);
	}

	
		
	
	
}
