package edu.school21.repositories;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import javax.sql.DataSource;
import java.sql.SQLException;


public class EmbeddedDataSourceTest {
	public DataSource db;
	@BeforeEach
	public void init()
	{
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		db = builder
		   .setType(EmbeddedDatabaseType.HSQL)
		   .addScript("/shema.sql")
		   .addScript("/data.sql")
		   .build();
		
	}

	@Test
	public void getConnectionTest() throws SQLException
	{
		assertNotNull(db.getConnection());
	}


}
