package school21.spring.service.services;

public interface UsersService {
	boolean signIN(String email, String password);
	boolean signUP(String email, String password);
	boolean saveMSG(String email, String meassage);
}
