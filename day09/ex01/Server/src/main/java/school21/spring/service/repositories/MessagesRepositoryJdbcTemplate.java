package school21.spring.service.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import school21.spring.service.models.Message;
import school21.spring.service.models.User;


public class MessagesRepositoryJdbcTemplate implements MessagesRepository{
	private NamedParameterJdbcTemplate jdbcTemplate;
    private final String saveQuery = "INSERT INTO chat.msgs (room_id, sender, message) VALUES (100, :sender, :message)";
    private final String email_is_freeQuery = "SELECT * FROM chat.users WHERE login = :login";
    private final String is_existQuery = "SELECT * FROM chat.users WHERE login = :login and passwd = :passwd";
    private final String registerQuery = "insert into chat.users (login, passwd) VALUES (:login, :passwd);";
  	

    // public void UsersRepositoryJdbcTemplateImpl(NamedParameterJdbcTemplate jdbcTemplate) {
    //     // super(dataSource);
    //     this.jdbcTemplate = jdbcTemplate;
    // }
	    public MessagesRepositoryJdbcTemplate(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

	private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User(rs.getInt("id"), rs.getString("login"), rs.getString("passwd"));
            return user;
        }
    }
	@Override
	public boolean save(Message entity) {
		try
		{
			jdbcTemplate.update(saveQuery, new MapSqlParameterSource()
			.addValue("sender", entity.getAuthor())
			.addValue("message", entity.getText()));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean email_is_free(String my_email) {
		User user = jdbcTemplate.query(email_is_freeQuery,
		new MapSqlParameterSource().addValue("login", my_email),
				new UserRowMapper()).stream().findAny().orElse(null);
		return ((user == null)  ? false : true);
		// return false;
	}

	@Override
	public boolean is_exist(User my_user) {
		User user = jdbcTemplate.query(is_existQuery,
		new MapSqlParameterSource().addValue("login", my_user.getLOGIN()).addValue("passwd", my_user.getPASSWORD()),
				new UserRowMapper()).stream().findAny().orElse(null);
		return ((user == null)  ? false : true);
	}

	@Override
	public boolean register(User my_user) {
		jdbcTemplate.update(registerQuery, new MapSqlParameterSource()
		.addValue("login", my_user.getLOGIN())
		.addValue("passwd", my_user.getPASSWORD()));
		return false;
	}
	
}
