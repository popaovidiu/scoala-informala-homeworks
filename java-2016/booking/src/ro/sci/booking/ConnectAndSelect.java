
package ro.sci.booking;

/**
 * @author Ovidiu Popa
 * 
 * This class connects to the DB and interrogates all three tables in DB
 */

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectAndSelect {
	
	public static void main(String[] args) throws SQLException {

		//connects at DB
		PostgresConnection client = new PostgresConnection(DbContract.HOST, DbContract.DB_NAME, DbContract.USERNAME,
				DbContract.PASSWORD);
		try {
			if (client.connect()) {
				System.out.println("DB connected");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// Interrogates ant print out the data from DB
		ResultSet rsAccomodations = client.execQuery("SELECT id, type, bed_type, max_guests, description FROM public.accomodation;");
		System.out.println("Accomodation");
		while (rsAccomodations.next()) {
			System.out.printf("%d\t%s\t%s\t%d\t%s\n", rsAccomodations.getInt(1),
					rsAccomodations.getString(2), rsAccomodations.getString(3), 
					rsAccomodations.getInt(4), rsAccomodations.getString(5));
		}
		
		ResultSet rsRoomFair = client.execQuery("SELECT id, value, season FROM public.room_fair;");
		System.out.println("Room_fair");
		while (rsRoomFair.next()) {
			System.out.printf("%d\t%f\t%s\n", rsRoomFair.getInt(1), rsRoomFair.getDouble(2),rsRoomFair.getString(3));
		}
		
		ResultSet rsAccomodationRoomFairRelation = client.execQuery("SELECT id, id_accomodation, id_room_fair FROM public.accomodation_fair_relation;");
		System.out.println("Accomodation_Room_Fair_Relations");
		while (rsAccomodationRoomFairRelation.next()) {
			System.out.printf("%d\t%d\t%d\n", rsAccomodationRoomFairRelation.getInt(1), 
					rsAccomodationRoomFairRelation.getInt(2), 
					rsAccomodationRoomFairRelation.getInt(2));
		}
	}
}
	

