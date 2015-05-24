package j2ee.purchase.supplier.dao.impl;

import j2ee.purchase.supplier.dao.UserDAO;
import j2ee.purchase.supplier.model.User;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		logger.info("User saved successfully, User Details=" + user);

	}

	@Override
	public void updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		logger.info("User updated successfully, User Details=" + user);
	}

	@Override
	public void removeUser(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Integer(id));
		if (null != user) {
			session.delete(user);
		}
		logger.info("User deleted successfully, User details=" + user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> lstUser() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> lstUser = session.createQuery("from User").list();
		return lstUser;
	}

	@Override
	public User getUserById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Integer(id));
		return user;
	}

}
