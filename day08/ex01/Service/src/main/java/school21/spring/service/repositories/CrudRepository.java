package school21.spring.service.repositories;

import java.sql.SQLException;
import java.util.List;

public interface CrudRepository<T> {
    T findById(Long id) throws SQLException;
    List<T> findAll() throws SQLException;
    void save(T entity);
    void update(T entity);
    void delete(int id) throws SQLException;
}
