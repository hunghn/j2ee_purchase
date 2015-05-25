package j2ee.purchase.service;

import java.util.List;

import j2ee.purchase.model.User;

public interface UserService {
	public void addUser(User user);

	public void updateUser(User user);

	public List<User> lstUsers();

	public User getUserById(Integer id);

	public void removeUser(Integer id);
}
