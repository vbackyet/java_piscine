package edu.school21.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

// import javax.activation.DataSource;

// import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import edu.school21.models.Product;

public class ProductsReposutoryJdbcImplTest {

    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(0, "хлеб", 30),
            new Product(1, "спички", 5),
            new Product(2, "puk", 50),
            new Product(3, "водка", 250),
            new Product(4, "яблоки", 130)
    );
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(2, "puk", 50);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(3, "водка", 750);
    final Product EXPECTED_SAVED_PRODUCT = new Product(5, "пакет", 10);

	public EmbeddedDatabase db;
	ProductsRepository productsRepository;
	@BeforeEach
	public void init()
	{
		// EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		db = new EmbeddedDatabaseBuilder()
		   .setType(EmbeddedDatabaseType.HSQL)
		   .addScript("/shema.sql")
		   .addScript("/data.sql")
		   .build();
		productsRepository = new ProductsRepositoryJdbcImpl(db);
	}

	@Test
    void testFindById() throws SQLException {
        assertEquals(productsRepository.findById(2).get(), EXPECTED_FIND_BY_ID_PRODUCT);
    }

	@Test
    void testSave() throws SQLException {
		productsRepository.save(EXPECTED_SAVED_PRODUCT);
        assertEquals(productsRepository.findById(5).get(), EXPECTED_SAVED_PRODUCT);
    }

	@Test
    void testUpdate() throws SQLException {
		productsRepository.update(EXPECTED_UPDATED_PRODUCT);
        assertEquals(productsRepository.findById(3).get(), EXPECTED_UPDATED_PRODUCT);
    }
	@Test
    void testSelectAll() throws SQLException {
		// productsRepository.findAll();
        assertEquals(productsRepository.findAll(), EXPECTED_FIND_ALL_PRODUCTS);
    }

	@Test
    void testdelete() throws SQLException {
		productsRepository.delete(2);
        assertThrows(SQLException.class, () -> productsRepository.findById(2));
    }

}



