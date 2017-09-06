package com.cgm.twitter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

public class UserBuilder {
	public static List<User> users;
	public static Map<String, ArrayList<String>> friends;
	public static Map<String, ArrayList<Message>> messages = new HashMap<String, ArrayList<Message>>();

	public static User anUser() {
		User user = new User();
		user.setName("daniel");
		user.setPassword("12345");

		return user;
	}
		
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
		
		messages.put("daniel", new ArrayList<Message>());
		messages.put("florin", new ArrayList<Message>());
		messages.put("andrei", new ArrayList<Message>());
		
		users.add(florin);
		users.add(daniel);
		users.add(andrei);
	}

	
		
	
	
}
