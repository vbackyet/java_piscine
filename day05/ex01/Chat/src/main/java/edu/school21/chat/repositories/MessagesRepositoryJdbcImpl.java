package edu.school21.chat.repositories;
import edu.school21.chat.models.*;
import java.sql.SQLException;
import java.util.Optional;
import java.time.LocalDateTime;
import javax.sql.DataSource;
import java.sql.*;



public class MessagesRepositoryJdbcImpl implements MessagesRepository {

	private final DataSource ds;

    public MessagesRepositoryJdbcImpl(DataSource ds) {
        this.ds = ds;
    }

	@Override
	public Optional<Message> findById(Long id) throws SQLException
	{


		String query = "select * from chat.msgs join chat.users on chat.users.id = chat.msgs.sender join " +
		"chat.room on chat.msgs.room_id = chat.room.room_id where chat.msgs.msg_id = " + id +";";
		Connection con = ds.getConnection();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();

		User user = new User(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("passwd"));
		Chatroom chatroom = new Chatroom(resultSet.getInt("room_id"), resultSet.getString("chat_name"), user, null);

		Optional <Message> my_message = Optional.of(new Message(resultSet.getInt("msg_id"), user, chatroom, resultSet.getString("message"), LocalDateTime.of(2014, 9, 19, 14, 5)));
		return my_message;
	}
}
