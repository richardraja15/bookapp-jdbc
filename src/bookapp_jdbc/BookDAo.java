package bookapp_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAo {
	// Connection connection=null;
	// PreparedStatement preparedStatement = null;
	// ResultSet resultSet = null;
	String sql;

	public void addBook(String name, int price) throws Exception {
		Connection connection = ConnectionUtil.getConnection();

		PreparedStatement preparedStatement;
		try {
			sql = "insert into book values(book_id_seq.NEXTVAL,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, price);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("unable to insert book");

		}

		ConnectionUtil.close(connection, preparedStatement, null);
	}

	public void setUpdate(int id, String name) throws Exception {

		Connection connection = ConnectionUtil.getConnection();

		PreparedStatement preparedStatement;
		try {
			sql = "update book set name=? where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(2, id);
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("unable to update");
		}
		ConnectionUtil.close(connection, preparedStatement, null);
	}

	
	public void FindAll() throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			String sql = "select id,name,price from book";

			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			System.out.println("id\tname\tprice");
			while (resultSet.next()) {

				System.out.println(resultSet.getInt("id") + "\t"
						+ resultSet.getString("name") + "\t"
						+ resultSet.getInt("price"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("unable to display records");
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
	}

	public void FindById(int id) throws Exception {

		Connection connection = ConnectionUtil.getConnection();

		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			sql = "select id,name,price from stu where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("id\tname\tprice");
				System.out.println(resultSet.getInt("id") + "\t"
						+ resultSet.getString("name") + "\t"
						+ resultSet.getInt("price"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("unable to select records");
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
	}
	public void deleteById(int id) throws Exception {
		Connection connection = ConnectionUtil.getConnection();

		PreparedStatement preparedStatement;
		try {
			sql = "delete from book where id=?";
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("unable to delete");
		}
		ConnectionUtil.close(connection, preparedStatement, null);
	}

	public void deleteByName(String name) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		try {
			sql = "delete from book where name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,name);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("unable to delete record");
		}

		ConnectionUtil.close(connection, preparedStatement, null);
	}
}
