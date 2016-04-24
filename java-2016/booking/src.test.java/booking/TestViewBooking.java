
package booking;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for view booking. The test assert if you can view a booking based on a:
 * bookingId, first name, last name, email and phone number
 * 
 * @author Ovidiu Popa
 *
 */

public class TestViewBooking {

	Customer customer = new Customer();
	List<Booking> booking;
	List<Object> bookingView = new ArrayList<>();

	@Before
	public void init() {
		/**
		 * Creating a mock Customer
		 */

		customer.setFirstName("Andrei");
		customer.setLastName("Gheorghe");
		customer.setEmail("adghe@gmail.com");
		customer.setPhoneNumber("0721-123456");

		/**
		 * Creating a mock booking: create a room, define a period, attach an
		 * booking Id to room and period and a bookingStatus.
		 * 
		 * All this info will be capture in a arrayList call bookingView that
		 * will be unique for every booking.
		 */

		Date from = getDate(2016, 05, 01);
		Date to = getDate(2016, 05, 10);

		Season season = createSeason(SeasonType.LOW, from, to);

		BookingPeriod period = new BookingPeriod(getDate(2016, 5, 12), getDate(2016, 5, 17));

		RoomFair roomFair1 = createRoomFair(100, season);

		Accomodation room1 = createNewRoom(AccomodationType.ROYAL, roomFair1);

		Booking bookings = new Booking(null, null);

		bookings.setRoom(room1);
		bookings.setBookingPeriod(period);

		BookingStatus bookingStatus = BookingStatus.APPROVED;

		BookingId bookingId = new BookingId();
		bookingId.setBookingId(1232);

		booking = new ArrayList<Booking>();
		booking.add(new Booking(room1, period));

		bookingView = new ArrayList<>();
		bookingView.add(booking.get(0));
		bookingView.add(bookingId.getBookingId());
		bookingView.add(bookingStatus);
		bookingView.add(customer.getFirstName());
		bookingView.add(customer.getLastName());
		bookingView.add(customer.getEmail());
		bookingView.add(customer.getPhoneNumber());
	}

	@Test
	public void test() {

		assertTrue(viewBookingPozitive());
		assertFalse(viewBookingNegative());

	}

	private boolean viewBookingPozitive() {
		boolean found = false;
		if ((Integer) bookingView.get(1) == 1232 && bookingView.get(3) == "Andrei" && bookingView.get(4) == "Gheorghe"
				&& bookingView.get(5) == "adghe@gmail.com" && bookingView.get(6) == "0721-123456") {
			found = true;
		}

		return found;
	}

	private boolean viewBookingNegative() {
		boolean found = false;
		if ((Integer) bookingView.get(1) == 1232 && bookingView.get(3) == "Andrei" && bookingView.get(4) == "George"
				&& bookingView.get(5) == "adghe@gmail.com" && bookingView.get(6) == "0721-123456") {
			found = true;
		}

		return found;
	}

	private Date getDate(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);
		return c.getTime();
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

	@After
	public void destroyCustomer() {
		customer.setFirstName(null);
		customer.setLastName(null);
		customer.setEmail(null);
		customer.setPhoneNumber(null);
	}

}
