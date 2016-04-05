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

public class TestAvailability {

	List<Accomodation> rooms;
	List<BookingPeriod> periods;
	List<Booking> bookings;

	@Before
	public void init() {
		rooms = new ArrayList<Accomodation>();

		Date from = getDate(2016, 05, 01);
		Date to = getDate(2016, 05, 10);
		Season season = createSeason(SeasonType.HIGH, from, to);

		RoomFair roomFair1 = createRoomFair(100, season);
		Accomodation room1 = createNewRoom(AccomodationType.ROYAL, roomFair1);
		rooms.add(room1);

		periods = new ArrayList<BookingPeriod>();

		periods.add(new BookingPeriod(getDate(2016, 5, 12), getDate(2016, 5, 17)));
		periods.add(new BookingPeriod(getDate(2016, 6, 10), getDate(2016, 6, 13)));
		periods.add(new BookingPeriod(getDate(2016, 7, 6), getDate(2016, 7, 12)));
		periods.add(new BookingPeriod(getDate(2016, 8, 2), getDate(2016, 8, 4)));

		bookings = new ArrayList<Booking>();

		bookings.add(new Booking(room1, periods.get(0)));

	}

	@Test
	public void testPeriod() {
		Date from = getDate(2016, 5, 12);
		Date to = getDate(2016, 1, 17);

		assertFalse(findAccomodationTypePeriod(AccomodationType.ROYAL, from, to));

	}

	private boolean findAccomodationTypePeriod(AccomodationType type, Date from, Date to) {
		boolean found = false;
		for (Booking booking : bookings) {
			if (booking.getRoom().getType().equals(type) && booking.getBookingPeriod().getFrom().before(from)
					&& booking.getBookingPeriod().getTo().after(to)) {
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
		return c.getTime();
	}

}
