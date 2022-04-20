package ex03;

public interface UsersList  {

	void addUser(User user);

	User getUserById(Integer id) throws UserNotFoundException;

	User getUserByIndex(Integer index);

	Integer getNumberofUsers();
}