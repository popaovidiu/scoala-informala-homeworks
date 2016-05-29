package ro.sci.DBTests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import ro.sci.booking.DbContract;
/**
 * 
 * @author Ovidiu Popa
 * 
 * This test print out the room and the room price
 *
 */

public class TestSelect {
	Connection conn;

	@Before
	public void init() {

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(DbContract.HOST + DbContract.DB_NAME, DbContract.USERNAME,
					DbContract.PASSWORD);
			System.out.println("DB connected");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testSelect1() {

		PreparedStatement statment = null;
		ResultSet resultSet = null;
		final String format = "%s\n";

		try {
			//preparing join query
			String sqlSelectQuery = "SELECT accomodation.type as room, room_fair.value as price "
					+ "FROM accomodation_fair_relation "
					+ "INNER JOIN accomodation ON accomodation_fair_relation.id_accomodation = accomodation.id "
					+ "INNER JOIN room_fair ON accomodation_fair_relation.id_room_fair=room_fair.id";

			statment = conn.prepareStatement(sqlSelectQuery);
			resultSet = statment.executeQuery();

			boolean hasResults = resultSet.next();

			if (hasResults) {
				do {
					System.out.printf("%s\t%s\n", resultSet.getString("room"), resultSet.getDouble("price"));
				} while (resultSet.next());
			} else {
				System.out.println("No results");
			}
		} catch (SQLException e) {
			System.err.println("Cannot execute query: " + e.getMessage());
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException e) {
				}
			if (statment != null)
				try {
					statment.close();
				} catch (SQLException e) {
				}
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
}