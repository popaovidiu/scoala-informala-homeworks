package ro.sci.DBTests;
/**
 * @author Ovidiu Popa
 * 
 * In this class I tested the if the connection is made
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import ro.sci.booking.DbContract;

public class TestConnection {
	Connection conn;
	@Test
	public void testConnection() {
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(DbContract.HOST + DbContract.DB_NAME, DbContract.USERNAME,
					DbContract.PASSWORD);

			System.out.println("DB connected");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
