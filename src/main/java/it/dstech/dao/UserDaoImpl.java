package it.dstech.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.dstech.model.User;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDao implements UserDao {

	@Override
	public User saveUser(User user) {
		return (User) persist(user);
	}

	@Override
	public User findByUsername(String username) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		return (User) criteria.uniqueResult();
	}

}
