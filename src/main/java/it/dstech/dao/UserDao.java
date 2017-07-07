package it.dstech.dao;

import it.dstech.model.User;

public interface UserDao {

	User findByUsername(String username);

}
