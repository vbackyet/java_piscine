package school21.spring.service.models;

import java.util.Objects;
import java.util.ArrayList;

public class User {
	private Integer USER_ID;
	private String LOGIN;
	private String PASSWORD;
	// private ArrayList<Chatroom> CREATED_CHATROOMS;
	// private ArrayList<Chatroom> USING_CHATROOMS;

	public User(Integer USER_ID, String LOGIN, String PASSWORD)
	{
		this.USER_ID = USER_ID;
		this.LOGIN = LOGIN;
		this.PASSWORD = PASSWORD;
	}

	public Integer getUSER_ID() {
		return USER_ID;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		this.PASSWORD = pASSWORD;
	}
	public String getLOGIN() {
		return LOGIN;
	}
	public void setLOGIN(String lOGIN) {
		this.LOGIN = lOGIN;
	}
	public void setUSER_ID(Integer uSER_ID) {
		this.USER_ID = uSER_ID;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return USER_ID == user.USER_ID && Objects.equals(LOGIN, user.LOGIN) && Objects.equals(PASSWORD, user.PASSWORD);
    }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(USER_ID, LOGIN, PASSWORD, CREATED_CHATROOMS, USING_CHATROOMS);
    // }
    @Override
    public int hashCode() {
        return Objects.hash(USER_ID, LOGIN, PASSWORD);
    }
	
	@Override
	public String toString() {
		return "My user with id: " + getUSER_ID()+ "\n" +
		" , with login: " + getLOGIN() + "\n" +
		" , with password: " + getPASSWORD();
	}
	

}

