package com.cgm.twitter.db.repository.contract;

import java.util.ArrayList;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cgm.twitter.domain.Message;




public interface MessageDataStore {

	void storeMessage(Message message);
	
	@ResponseBody 
	Map<String, ArrayList<String>>  readMessage(@RequestBody Message message, HttpServletRequest request);
}
