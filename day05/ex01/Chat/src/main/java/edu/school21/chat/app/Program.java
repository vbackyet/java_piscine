package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
// import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.models.*;
import java.util.Optional;
// import java.security.cert.PKIXRevocationChecker.Option;
import java.sql.SQLException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws SQLException {

		HikariDataSource DataSource = new HikariDataSource();
		DataSource.setJdbcUrl("jdbc:postgresql://localhost:5433/vbackyet");
		DataSource.setUsername("vbackyet");
		DataSource.setPassword("");
		MessagesRepository repository = new MessagesRepositoryJdbcImpl(DataSource);
        // Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a message ID");
        System.out.print("-> ");
		try{
			System.out.println(repository.findById(scanner.nextLong()).get());
		}
		catch (Exception e)
		{
			System.out.println("нет такого ай ди");
		}
    }
}