package j2ee.purchase.service.impl;

import j2ee.purchase.dao.UserDAO;
import j2ee.purchase.model.User;
import j2ee.purchase.service.UserService;
import j2ee.purchase.utils.Security;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public void addUser(User user) {
		userDAO.addUser(user);

	}

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);

	}

	@Override
	public List<User> lstUsers() {
		return userDAO.lstUser();
	}

	@Override
	public User getUserById(String id) {
		return userDAO.getUserById(id);
	}

	@Override
	public void removeUser(String id) {
		userDAO.removeUser(id);
	}

	@Override
	public boolean checkLogin(User user) {
		if (user != null) {
			if (userDAO.getUserByEmail(user.getEmail()).equals(
					user.getPassword())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean login(String email, String password) {
		User user = userDAO.getUserByEmail(email);

		if (user != null) {
			String encryptPassword = Security.encryptPassword(password
					+ user.getSalt());
			if (encryptPassword.equals(user.getPassword())) {
				user.setLogin_date(new Date());
				userDAO.updateUser(user);
				return true;
			}
		}
		return false;
	}

	@Override
	public User getUserByEmail(String email) {
		return userDAO.getUserByEmail(email);
	}

}
