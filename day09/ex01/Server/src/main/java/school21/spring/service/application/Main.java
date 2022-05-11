package school21.spring.service.application;

import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import school21.spring.service.models.User;
import school21.spring.service.repositories.MessagesRepository;
import school21.spring.service.repositories.MessagesRepositoryJdbcTemplate;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		MessagesRepository usersRepository = context.getBean("MessagesRepositoryJdbcTemplate", MessagesRepository.class);
		// User my_user = (User) context.getBean("User",200, "rosfryd", "1234567", User.class);
		User my_user = new User(200, "rosfryd", "1234567");
		System.out.println(usersRepository.is_exist(my_user) );
	}
}