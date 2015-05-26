package j2ee.purchase.dao;

import java.util.List;

import j2ee.purchase.model.User;

public interface UserDAO {
	public void addUser(User user);

	public void updateUser(User user);

	public void removeUser(Integer id);

	public List<User> lstUser();

	public User getUserById(Integer id);

	public User getUserByEmail(String email);
}
