package it.dstech.dao;

import it.dstech.model.User;

public interface UserDao {

	User saveUser(User user);

	User findByUsername(String username);

}
