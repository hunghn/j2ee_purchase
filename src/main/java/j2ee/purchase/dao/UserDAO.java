package j2ee.purchase.supplier.dao;

import java.util.List;

import j2ee.purchase.supplier.model.User;

public interface UserDAO {
	public void addUser(User user);
	public void updateUser(User user);
	public void removeUser(Integer id);
	public List<User> lstUser();
	public User getUserById(Integer id);
}
