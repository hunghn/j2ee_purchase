package j2ee.purchase.dao.impl;

import j2ee.purchase.dao.UserDAO;
import j2ee.purchase.model.User;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addUser(User user) {
		Session session = this.getCurrentSession();
		session.persist(user);
		logger.info("User saved successfully, User Details=" + user);

	}

	@Override
	public void updateUser(User user) {
		Session session = this.getCurrentSession();
		session.update(user);
		logger.info("User updated successfully, User Details=" + user);
	}

	@Override
	public void removeUser(String id) {
		Session session = this.getCurrentSession();
		User user = (User) session.get(User.class, id);
		if (null != user) {
			session.delete(user);
		}
		logger.info("User deleted successfully, User details=" + user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> lstUser() {
		Session session = this.getCurrentSession();
		List<User> lstUser = session.createQuery("from User").list();
		return lstUser;
	}

	@Override
	public User getUserById(String id) {
		Session session = this.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByEmail(String email) {
		Session session = this.getCurrentSession();
		String hql = "from User as o where o.email=:email";
		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		List<User> lstUser = query.list();
		if (!lstUser.isEmpty()) {
			return lstUser.get(0);
		}
		return null;
	}

}
