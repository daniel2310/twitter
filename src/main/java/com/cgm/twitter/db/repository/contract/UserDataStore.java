package com.cgm.twitter.db.repository.contract;



import java.util.List;

import com.cgm.twitter.domain.User;


/**
 * 
 * @author Daniel Pavel
 *
 */
public interface UserDataStore {
	
	/**
	 * 
	 * @param artist
	 */
	void storeUsers(User user);

	/**
	 * 
	 * @return
	 */
	List<User> readUsers();
}
