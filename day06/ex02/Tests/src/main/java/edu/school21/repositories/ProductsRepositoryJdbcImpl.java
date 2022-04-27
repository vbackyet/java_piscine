package edu.school21.repositories;
import edu.school21.models.*;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;


public class ProductsRepositoryJdbcImpl implements ProductsRepository{
	// List<Product> findAll()
	// {

	// }
	private final EmbeddedDatabase dataSource;

    public ProductsRepositoryJdbcImpl(EmbeddedDatabase ds) {
        dataSource = ds;
    }

	@Override
	public Optional<Product> findById(int id) throws SQLException
	{


		String query = "select * from shop where identifier = " + id +";";
		// Connection con = dataSource.getConnection();
		Statement statement = dataSource.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
		Optional <Product> my_message = Optional.of(new Product(resultSet.getInt("identifier"), resultSet.getString("name"), resultSet.getInt("price")));
		// statement.close();
		return my_message;
	}

	@Override
	public void save(Product product) throws SQLException
	{
		String query = "insert into shop (name, price) VALUES " +  "('"+ product.getName() + "', "+ product.getPrice() + ");";

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
	public void update(Product product)
	{
		String query = "update shop set name=" +  "'"+ product.getName() + "', price="+ product.getPrice()+ " where identifier =" + product.getId() + ";";

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
    public List<Product> findAll() throws SQLException {
        List<Product> productList = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from shop;");

        while (resultSet.next()) {
           productList.add(new Product(
                   resultSet.getInt(1),
                   resultSet.getString(2),
                   resultSet.getInt(3)
           ));
        }

        statement.close();
        connection.close();

        return productList;
    }
	@Override
	public void delete (int id) throws SQLException 
	{

			Connection connection = dataSource.getConnection();
			Statement preparedStatement = connection.createStatement();
			String query =	"DELETE FROM shop " +
							"WHERE identifier =" + id  + ";";
			preparedStatement.execute(query);
			preparedStatement.close();
			connection.close();

	}

	// UPDATE Customers
	// SET ContactName = 'Alfred Schmidt', City= 'Frankfurt'
	// WHERE CustomerID = 1;

	// void save(Product product);
	// void delete (Long id);
}
