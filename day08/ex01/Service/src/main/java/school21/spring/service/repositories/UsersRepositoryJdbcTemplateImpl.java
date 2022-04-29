package school21.spring.service.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import school21.spring.service.models.User;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository{
	private NamedParameterJdbcTemplate jdbcTemplate;
    private final String idQuery = "SELECT * FROM user WHERE id = :id";
    private final String emQuery = "SELECT * FROM user WHERE email = :email";
    private final String alQuery = "SELECT * FROM users.user";
    private final String upQuery = "UPDATE user SET email = :email WHERE id = :id";
    private final String dlQuery = "DELETE FROM user WHERE id = :id";
    private final String inQuery = "INSERT INTO user (id, email) VALUES (:id, :email)";

    private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User(rs.getInt("id"), rs.getString("email"));
            return user;
        }
    }

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public User findById(Long id) {
        User user = jdbcTemplate.query(idQuery,
                new MapSqlParameterSource().addValue("id", id),
                new UserRowMapper()).stream().findAny().orElse(null);

        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = jdbcTemplate.query(alQuery, new UserRowMapper());
        return users;
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update(inQuery, new MapSqlParameterSource()
                .addValue("id", entity.getIdentifier())
                .addValue("email", entity.getEmail()));
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update(upQuery, new MapSqlParameterSource()
                .addValue("id", entity.getIdentifier())
                .addValue("email", entity.getEmail()));
    }

    @Override
    public void delete(int id) throws SQLException{
        jdbcTemplate.update(dlQuery, new MapSqlParameterSource()
                .addValue("id", id));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User user = jdbcTemplate.query(emQuery,
                new MapSqlParameterSource().addValue("email", email),
                        new UserRowMapper()).stream().findAny().orElse(null);
        return Optional.ofNullable(user);
    }

	// @Override
	// public void delete(int id) throws SQLException {
	// 	// TODO Auto-generated method stub
		
	// }
}
