package test.ro.sci.booking;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import exception.ro.sci.booking.BookingPeriodValidationException;
import main.ro.sci.booking.Accommodation;
import main.ro.sci.booking.AccommodationType;
import main.ro.sci.booking.Booking;
import main.ro.sci.booking.BookingPeriod;
import main.ro.sci.booking.RoomFair;
import main.ro.sci.booking.Season;
import main.ro.sci.booking.SeasonType;

/**
 * Test for view booking. The test assert if you can book a room.
 * 
 * In this case we test if you can book a allready booked room.
 * 
 * @author Ovidiu Popa
 *
 */
public class TestBook extends AbstractBookingTest {

	//TODO add visibility modifiers
	List<Accommodation> rooms;
	List<BookingPeriod> periods;
	List<Booking> bookings;

	@Before
	public void init() {

		/**
		 * Creating a mock booking: create a room, define a period, attach an
		 * booking Id to room and period and a bookingStatus.
		 * 
		 */
		rooms = new ArrayList<Accommodation>();

		Date from = getDate(2016, 5, 12);
		Date to = getDate(2016, 5, 17);
		Season season = createSeason(SeasonType.HIGH, from, to);

		RoomFair roomFair1 = createRoomFair(100, season);
		Accommodation room1 = createNewRoom(AccommodationType.ROYAL, roomFair1);
		rooms.add(room1);

		periods = new ArrayList<BookingPeriod>();
		periods.add(new BookingPeriod(getDate(2016, 5, 12), getDate(2016, 5, 17)));

		bookings = new ArrayList<Booking>();

		bookings.add(new Booking(room1, periods.get(0)));

	}

	@Test
	public void testBook() throws BookingPeriodValidationException {
		Date from = getDate(2016, 5, 12);
		Date to = getDate(2016, 5, 17);
		assertTrue(bookRoom(AccommodationType.ROYAL, from, to));

		Date from1 = getDate(2016, 1, 12);
		Date to1 = getDate(2016, 1, 17);
		assertFalse(bookRoom(AccommodationType.ROYAL, from1, to1));
	}

	private boolean bookRoom(AccommodationType type, Date from, Date to) throws BookingPeriodValidationException {
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

}
