package ro.sci.DBTests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import ro.sci.booking.DbContract;
/**
 * 
 * @author Ovidiu Popa
 * 
 * JUnit test class - testing INSERTION in database
 *
 */

public class TestInsert {
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
	public void testInsert() {

		PreparedStatement statment1 = null;
		PreparedStatement statment2 = null;
		PreparedStatement statment3 = null;
		int id=3;
		
		try {

			// insert values to first table - accommodation

			statment1 = conn.prepareStatement(
					"INSERT INTO public.accomodation(id, type, bed_type, max_guests, description) VALUES (?, ?, ?, ?, ?);  ");
			statment1.setInt(1, id);
			statment1.setString(2, "SINGLE");
			statment1.setString(3, "SINGLE");
			statment1.setFloat(4, 1);
			statment1.setString(5, "Cu balcon");
			statment1.executeUpdate();

			// insert values to second table - room_fair

			statment2 = conn.prepareStatement("INSERT INTO public.room_fair(id, value, season)VALUES (?, ?, ?);");
			statment2.setInt(1, id);
			statment2.setFloat(2, 100);
			statment2.setString(3, "LOW");
			statment2.executeUpdate();

			// insert values to the third table - accomodation_fair_relation

			statment3 = conn.prepareStatement(
					"INSERT INTO public.accomodation_fair_relation(id, id_accomodation, id_room_fair)VALUES (?, ?, ?);");
			statment3.setInt(1, id);
			statment3.setInt(2, id);
			statment3.setInt(3, id);
			statment3.executeUpdate();

		} catch (SQLException e) {
			System.err.println(" Insertion error " + e.getMessage());

		} finally {

			if (statment1 != null || statment2 != null || statment3 != null)
				try {
					statment1.close();
					statment2.close();
					statment3.close();
				} catch (SQLException e) {
				}
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}

	}
}
