package booking;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import booking.Accomodation;
import booking.BookingPeriod;
import booking.Booking;

/**
 * Test for view booking. The test assert if you can book a room. 
 * 
 * In this case we test if you can book a allready booked room.
 *  
 * @author Ovidiu Popa
 *
 */
public class TestBook {

	List<Accomodation> rooms;
	List<BookingPeriod> periods;
	List<Booking> bookings;

	@Before
	public void init() {
		
		/**
		 * Creating a mock booking: create a room, define a period, attach an
		 * booking Id to room and period and a bookingStatus.
		 * 
		 */
		rooms = new ArrayList<Accomodation>();

		Date from = getDate(2016, 5, 12);
		Date to = getDate(2016, 5, 17);
		Season season = createSeason(SeasonType.HIGH, from, to);

		RoomFair roomFair1 = createRoomFair(100, season);
		Accomodation room1 = createNewRoom(AccomodationType.ROYAL, roomFair1);
		rooms.add(room1);

		periods = new ArrayList<BookingPeriod>();
		periods.add(new BookingPeriod(getDate(2016, 5, 12), getDate(2016, 5, 17)));

		bookings = new ArrayList<Booking>();

		bookings.add(new Booking(room1, periods.get(0)));

	}

	@Test
	public void testBook() {
		Date from = getDate(2016, 5, 12);
		Date to = getDate(2016, 5, 17);
		assertTrue(bookRoom(AccomodationType.ROYAL, from, to));

		Date from1 = getDate(2016, 1, 12);
		Date to1 = getDate(2016, 1, 17);
		assertFalse(bookRoom(AccomodationType.ROYAL, from1, to1));
	}

	private boolean bookRoom(AccomodationType type, Date from, Date to) {
		boolean found = false;
		for (Booking booking : bookings) {
			if (booking.getRoom().getType().equals(type) && booking.getBookingPeriod().getFrom().compareTo(from) == 0
					&& booking.getBookingPeriod().getTo().compareTo(to) == 0) {
				found = true;
				break;
			}
		}
		return found;
	}

	private Accomodation createNewRoom(AccomodationType type, RoomFair fair) {
		Accomodation accomodation = new Accomodation();
		accomodation.setType(type);
		accomodation.setFair(fair);
		return accomodation;
	}

	private RoomFair createRoomFair(int i, Season season) {
		RoomFair roomFair = new RoomFair();
		roomFair.setSeason(season);
		roomFair.setValue(i);
		return roomFair;

	}

	private Season createSeason(SeasonType type, Date from, Date to) {
		Season season = new Season();
		season.setFrom(from);
		season.setTo(to);
		season.setType(type);
		return season;
	}

	private Date getDate(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

}
