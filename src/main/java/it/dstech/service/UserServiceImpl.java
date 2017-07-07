package it.dstech.service;

import org.springframework.stereotype.Service;

import it.dstech.dao.UserDao;
import it.dstech.model.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDao dao;

	@Override
	public User findByUsername(String username) {
		return dao.findByUsername(username);
	}

}
