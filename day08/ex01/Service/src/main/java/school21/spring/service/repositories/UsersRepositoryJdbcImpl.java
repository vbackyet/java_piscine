package school21.spring.service.repositories;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import school21.spring.service.models.User;

public class UsersRepositoryJdbcImpl implements UsersRepository{
	private DataSource dataSource;
    public UsersRepositoryJdbcImpl(DataSource ds) {
        dataSource = ds;
    }
	@Override
	public User findById(Long id) throws SQLException {
		String query = "select * from user where id = " + id +";";
		ResultSet resultSet = dataSource.getConnection().createStatement().executeQuery(query);
        resultSet.next();
		Optional<User> my_message = Optional.of(new User(resultSet.getInt("id"), resultSet.getString("email")));
		return my_message.get();
	}

	@Override
	public List<User> findAll() throws SQLException {
		List<User> productList = new ArrayList<>();
		String query = "select * from users.user";
		ResultSet resultSet = dataSource.getConnection().createStatement().executeQuery(query);

        while (resultSet.next()) {
           productList.add(new User(
                   resultSet.getInt(1),
                   resultSet.getString(2)
           ));
        }
        return productList;

	}

	@Override
	public void save(User entity) {
		String query = "insert into user (id, email) VALUES " +  "('"+ entity.getIdentifier() + "', "+ entity.getEmail() + ");";

		try
		{	
			Statement statement = dataSource.getConnection().createStatement();
			statement.execute(query);
			statement.close();
		}
		catch (SQLException e)
		{
			System.out.print(e);
			System.out.print("не так вставилось");
		}
		
	}

	@Override
	public void update(User entity) {
		String query = "update user set email="+ entity.getEmail()+ " where identifier =" + entity.getIdentifier() + ";";

		try
		{	
			Statement statement = dataSource.getConnection().createStatement();
			statement.execute(query);
			statement.close();
		}
		catch (SQLException e)
		{
			System.out.print(e);
			System.out.print("не так обновилось");
		 }
	}

	@Override
	public void delete(int id) throws SQLException {
		Connection connection = dataSource.getConnection();
		Statement preparedStatement = connection.createStatement();
		String query =	"DELETE FROM user " +
						"WHERE id =" + id  + ";";
		preparedStatement.execute(query);
		preparedStatement.close();
		connection.close();
		
	}

	@Override
	public Optional<User> findByEmail(String email) throws SQLException {
		String query = "select * from user where email = " + email +";";
		ResultSet resultSet = dataSource.getConnection().createStatement().executeQuery(query);
        resultSet.next();
		Optional<User> my_message = Optional.of(new User(resultSet.getInt("id"), resultSet.getString("email")));
		return my_message;
	}
	
}
