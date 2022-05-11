package school21.spring.service.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import school21.spring.service.models.User;
import school21.spring.service.repositories.MessagesRepository;

public class UsersServiceImpl implements UsersService{

	@Override
	public boolean signIN(String email, String password) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		MessagesRepository usersRepository = context.getBean("MessagesRepositoryJdbcTemplate", MessagesRepository.class);
		User my_user = new User(200, email, password);
		if (usersRepository.is_exist(my_user))
			return true;
		return false;
	}

	@Override
	public boolean signUP(String email, String password) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		MessagesRepository usersRepository = context.getBean("MessagesRepositoryJdbcTemplate", MessagesRepository.class);
		if (!usersRepository.email_is_free(email))
			return false;
		User my_user = new User(200, email, password);
		if (usersRepository.register(my_user))
			return true;		
		return false;	
	}
	
}
