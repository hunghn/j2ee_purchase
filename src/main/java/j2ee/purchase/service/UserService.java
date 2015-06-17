package j2ee.purchase.service;

import java.util.List;

import j2ee.purchase.model.User;

public interface UserService {
	public void addUser(User user);

	public void updateUser(User user);

	public List<User> lstUsers();

	public User getUserById(String id);

	public void removeUser(String id);
	
	public boolean checkLogin(User user);	
	
	public boolean login(String email, String password);
	
	public User getUserByEmail(String email);
	
	public boolean checkExistUserName(String username);
	
	public boolean checkExistUserEmail(String email);
}
