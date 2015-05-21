package j2ee.purchase.supplier.service;

import java.util.List;

import j2ee.purchase.supplier.model.User;

public interface UserService {
	public void addUser(User user);

	public void updateUser(User user);

	public List<User> lstUsers();

	public User getUserById(Integer id);

	public void removeUser(Integer id);
}
