package com.cgm.twitter.db.repository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cgm.twitter.db.repository.contract.UserDataStore;
import com.cgm.twitter.db.repository.utils.UserRowMapper;
import com.cgm.twitter.domain.User;






/**
 * 
 * @author Daniel Pavel
 *
 */
@Repository("dbUserDAO")
@EnableTransactionManagement
public class DBUserDAO implements UserDataStore {
	
	public final static Logger logger = LoggerFactory
			.getLogger(DBUserDAO.class);

	private SimpleJdbcInsert insertUser;
	private JdbcTemplate jdbcTemplate;
	

	@Autowired
	public void setDataSource(DataSource dataSource) {
		insertUser = new SimpleJdbcInsert(dataSource)
				.withTableName("users").usingGeneratedKeyColumns("user_id");;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Transactional
	public void storeUsers(User user) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("name", user.getName());
		parameters.put("password", user.getPassword());
			try {
			insertUser.execute(parameters);
			logger.info("Called simple JDBC inserter!");
		} catch (DataAccessException dae) {
			logger.error("A database error occured: " + dae.getMessage());
		}
	}

	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<User> readUsers() {
		StringBuilder selectStatement = new StringBuilder();
		selectStatement.append("SELECT * FROM ").append(
				"users");

		List<User> users = null;
		try {
			users = jdbcTemplate.query(selectStatement.toString(),
					new Object[] { }, new UserRowMapper());
			logger.error("Read list of artists: " + users.size());
		} catch (DataAccessException dae) {
			logger.error("A database error occured: " + dae.getMessage());
		}

		return users;
	}

	

	
}
