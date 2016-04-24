package main.ro.sci.booking;
import exception.ro.sci.booking.BookingPeriodValidationException;
import  main.ro.sci.booking.BookingPeriod;


public class Booking {

	private Accommodation room;
	private BookingPeriod bookingPeriod;
	// customer
	// id
	// price
	// status

	public Booking(Accommodation room, BookingPeriod bookingPeriod) {
		this.setRoom(room);
		this.setBookingPeriod(bookingPeriod);
	}

	public Accommodation getRoom() {
		return room;
	}

	public void setRoom(Accommodation room) {
		this.room = room;
	}

	public BookingPeriod getBookingPeriod() throws BookingPeriodValidationException {
		if (bookingPeriod == null) {
			throw new BookingPeriodValidationException("not ok");
		}
		
		return bookingPeriod;
	}

	public void setBookingPeriod(BookingPeriod bookingPeriod) {
		this.bookingPeriod = bookingPeriod;
	}

}
