package school21.spring.service.models;

public class User {
    int id;
    String email;

    public User(int id, String email) {
        this.id = id;
        this.email = email;
    }
	public int getIdentifier() {
        return id;
    }

    public void setIdentifier(int identifier) {
        this.id = identifier;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "identifier=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
