package j2ee.purchase.impl;

import j2ee.purchase.dao.UserDAO;
import j2ee.purchase.model.User;
import j2ee.purchase.service.UserService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);

	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userDAO.updateUser(user);

	}

	@Override
	@Transactional
	public List<User> lstUsers() {
		return userDAO.lstUser();
	}

	@Override
	@Transactional
	public User getUserById(Integer id) {
		return userDAO.getUserById(id);
	}

	@Override
	@Transactional
	public void removeUser(Integer id) {
		userDAO.removeUser(id);
	}

}
