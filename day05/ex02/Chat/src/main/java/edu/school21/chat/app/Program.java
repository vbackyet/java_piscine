package edu.school21.chat.app;


import com.zaxxer.hikari.HikariDataSource;

import java.util.ArrayList;

import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.models.*;

// import java.security.cert.PKIXRevocationChecker.Option;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class Program {
    public static void main(String[] args) throws SQLException {

		HikariDataSource DataSource = new HikariDataSource();
		DataSource.setJdbcUrl("jdbc:postgresql://localhost:5433/vbackyet");
		DataSource.setUsername("vbackyet");
		DataSource.setPassword("");
        // Scanner scanner = new Scanner(System.in);
		User author = new User(2, "user", "user");
		Chatroom room = new Chatroom(3, "room", author, new ArrayList<Message>());
		Message message = new Message(null, author, room, "Hello - this is a test!", LocalDateTime.now());
		MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(DataSource);
		try
		{
			messagesRepository.save(message);
			System.out.println(message.getId()); // ex. id == 11
		}
		catch (Exception e)
		{
			System.out.println("Не удалось сохранить(((");
		}
    }
}