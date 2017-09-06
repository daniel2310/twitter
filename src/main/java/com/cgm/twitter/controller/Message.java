package com.cgm.twitter.controller;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Message implements Serializable {
	public String user;
	public String content;
	
	
	public Message() {
		
	}
	
	public Message(String user, String content) {
		super();
		this.user = user;
		this.content = content;
		
	}



	
	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}

}
