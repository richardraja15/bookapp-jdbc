package bookapp_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookObjDAO {
	// Connection connection=null;
	// PreparedStatement preparedStatement = null;
	// ResultSet resultSet = null;
	String sql;

	public void addBook(Book book) throws Exception {
		Connection connection = ConnectionUtil.getConnection();

		PreparedStatement preparedStatement;
		try {
			sql = "insert into book(name,price,author,published_date)values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, book.name);
			preparedStatement.setInt(2, book.price);
			preparedStatement.setString(3, book.author);
			preparedStatement.setDate(4,Date.valueOf(book.publishedDate));
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("unable to insert book");

		}

		ConnectionUtil.close(connection, preparedStatement, null);
	}

	public ArrayList<Book> FindAll() throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<Book> bList = new ArrayList<Book>();
		try {
			String sql = "select id,name,price,author,published_date from book";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);

			while (resultSet.next()) {
				Book book = new Book();
				book.id = resultSet.getInt("id");
				book.name = resultSet.getString("name");
				book.price = resultSet.getInt("price");
				book.author = resultSet.getString("author");
				book.publishedDate=resultSet.getDate("published_date").toLocalDate();
				bList.add(book);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("unable to display records");
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return bList;
	}

	public Book FindById(Book book) throws Exception {
		Book book1 = null;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			sql = "select id,name,price,author,published_date from book where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, book.id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				book1 = new Book();
				book1.id = resultSet.getInt("id");
				book1.name = resultSet.getString("name");
				book1.price = resultSet.getInt("price");
				book1.author = resultSet.getString("author");
				book1.publishedDate=resultSet.getDate("published_date").toLocalDate();

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("unable to select records");
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return book1;
	}
	public void delete(int id) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		try {
			sql = "delete from book where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
preparedStatement.executeUpdate();

			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("unable to delete records");
		}
		ConnectionUtil.close(connection, preparedStatement, null);

}
}