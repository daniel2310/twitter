package com.cgm.twitter.db.repository.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.cgm.twitter.domain.User;


/**
 * 
 * @author Vlad Ungureanu
 *
 */
public class UserResultSetExtractor implements ResultSetExtractor<User> {

	@Override
	public User extractData(ResultSet rs) throws SQLException {
		User cashDrawer = new User();
		cashDrawer.setName(rs.getString("name"));
		return cashDrawer;
	}

}
