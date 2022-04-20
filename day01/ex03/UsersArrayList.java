package ex03;


// Now we need to implement a functionality for storing users while the program runs.

// At the moment, your application has no persistent storage (such as a file system or a database). However, we want to avoid the dependence of your logic on user storage implementation method. To ensure more flexibility, let us define UsersList interface that describes the following behavior:




// This interface will enable to develop the business logic of your application so that a specific storage implementation does not affect other system components.

// We shall also implement UsersArrayList class that implements UsersList interface.

// This class shall use an array to store user data.
// The default array size is 10. If the array is full, its size is increased by half. 
// The user-adding method puts an object of User type in the first empty (vacant) cell of the array.

// In case of an attempt to retrieve a user with a non-existent ID, an unchecked UserNotFoundException must be thrown.


public class UsersArrayList implements UsersList{
	static private int BASE_CAPCITY = 10;
	private User[] initial_massive = new User[BASE_CAPCITY];
	public void multiply_array(int ind, User user)
	{
		BASE_CAPCITY = (int) (BASE_CAPCITY * 1.5);
		User[] initial_massive_new = new User[BASE_CAPCITY];
		for (int i = 0 ; i < BASE_CAPCITY; i++)
		{
			initial_massive_new[i] = initial_massive[i];
		}
		initial_massive_new[ind] = user;
		this.initial_massive = initial_massive_new;
	}
// vopros this.
	public void addUser(User user)
	{
		int i = 0 ;
		while ( i < BASE_CAPCITY)
		{
			if (initial_massive[i] == null)
			{
				initial_massive[i] = user;
				return;
			}
			i++;
		}
		multiply_array(i, user);
	}
	public User getUserById(Integer id) throws UserNotFoundException
	{
		int i = 0 ;
		while ( this.initial_massive[i] != null)
		{
			if (this.initial_massive[i].getIdentifier() == id)
				return this.initial_massive[i];
			i++;
		}
		throw new UserNotFoundException(id);

		// return i;
	}
	public User getUserByIndex(Integer index)
	{
		return this.initial_massive[index];
	}
	public Integer getNumberofUsers()
	{
		int i = 0 ;
		while ( this.initial_massive[i] != null)
			i++;

		return i;
	}
	
}
