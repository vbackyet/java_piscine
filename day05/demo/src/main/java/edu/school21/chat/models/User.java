package edu.school21.chat.models;

import java.util.ArrayList;

public class User {
	private Integer USER_ID;
	private String LOGIN;
	private String PASSWORD;
	private ArrayList<Chatroom> CREATED_CHATROOMS;
	private ArrayList<Chatroom> USING_CHATROOMS;

	User(Integer USER_ID, String LOGIN, String PASSWORD)
	{
		this.USER_ID = USER_ID;
		this.LOGIN = LOGIN;
		this.PASSWORD = PASSWORD;
	}

	public Integer getUSER_ID() {
		return USER_ID;
	}
	public ArrayList<Chatroom> getUSING_CHATROOMS() {
		return USING_CHATROOMS;
	}
	public void setUSING_CHATROOMS(ArrayList<Chatroom> uSING_CHATROOMS) {
		this.USING_CHATROOMS = uSING_CHATROOMS;
	}
	public ArrayList<Chatroom> getCREATED_CHATROOMS() {
		return CREATED_CHATROOMS;
	}
	public void setCREATED_CHATROOMS(ArrayList<Chatroom> cREATED_CHATROOMS) {
		this.CREATED_CHATROOMS = cREATED_CHATROOMS;
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
        return id == user.id && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(createdRooms, user.createdRooms) && Objects.equals(socializedRooms, user.socializedRooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, createdRooms, socializedRooms);
    }

	
	@Override
	public String toString() {
		return "My user with id: " + getUSER_ID()+ "\n" +
		" , with login: " + getLOGIN() + "\n" +
		" , with password: " + getPASSWORD();
	}
	

}
