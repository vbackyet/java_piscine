package school21.spring.service.repositories;
import school21.spring.service.models.*;
// import edu.school21.chat.exceptions.*;
import java.sql.SQLException;
import java.util.Optional;


public interface MessagesRepository {
    // T findById(Long id) throws SQLException;
    // List<T> findAll() throws SQLException;
    boolean save(Message entity);
	boolean email_is_free(String my_email);
	boolean is_exist(User my_user);
	boolean register(User my_user);
    // void update(T entity);
    // void delete(int id) throws SQLException;
}
