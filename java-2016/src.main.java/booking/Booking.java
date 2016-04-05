package booking;

public class Booking {

	private Accomodation room;
	private BookingPeriod bookingPeriod;
	private BookingStatus bookingStatus;
	private BookingId bookingId;
	
	public BookingId getBookingId() {
		return bookingId;
	}

	public void setBookingId(BookingId bookingId) {
		this.bookingId = bookingId;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	
	public Booking(Accomodation room, BookingPeriod bookingPeriod){
		this.setRoom(room);
		this.setBookingPeriod(bookingPeriod);
		}
	
		
	public Accomodation getRoom(){
		return room;
	}
	
	public void setRoom(Accomodation room) {
		this.room = room;
	}

	public BookingPeriod getBookingPeriod() {
		return bookingPeriod;
	}

	public void setBookingPeriod(BookingPeriod bookingPeriod) {
		this.bookingPeriod = bookingPeriod;
	}
	
}
