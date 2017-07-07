package it.dstech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.dao.UserDao;
import it.dstech.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public User saveUser(User user) {
		return dao.saveUser(user);
	}

	@Override
	public User findByUsername(String username) {
		return dao.findByUsername(username);
	}

}
