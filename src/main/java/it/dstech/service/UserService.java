package it.dstech.service;

import it.dstech.model.User;

public interface UserService {

	User findByUsername(String username);

}
