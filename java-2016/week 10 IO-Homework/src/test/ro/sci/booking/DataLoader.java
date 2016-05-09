package test.ro.sci.booking;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.management.relation.RelationServiceNotRegisteredException;
import javax.naming.directory.InvalidAttributeIdentifierException;
import org.junit.Test;

import main.ro.sci.booking.Accommodation;
import main.ro.sci.booking.BookingPeriod;

//TODO this is an utility class, not a test class, @Test methods should be in Test specific classes
public class DataLoader {

	private static String ROOMS_FILE_PATH = "C:\\Users\\Petronia\\Desktop\\booking\\doc\\rooms.txt";
	private static String BOOKING_FILE_PATH = "C:\\Users\\Petronia\\Desktop\\booking\\doc\\booking.txt";
	private static String BOOKING_PERIODS_FILE_PATH = "C:\\Users\\Petronia\\Desktop\\booking\\doc\\bookingperiods.txt";
	ArrayList<Accommodation> room = new ArrayList<Accommodation>();
	

	@Test
	//Testing if we can read rooms from file 
	public void readRooms() throws InvalidAttributeIdentifierException {
		List<Accommodation> rooms = new ArrayList<>();
		Path file = Paths.get(ROOMS_FILE_PATH);
		readFileAccommodation(file, rooms);
		Path fileOut = Paths.get(BOOKING_FILE_PATH);
		writeFile(fileOut);
		//TODO where is the assertion? every test should check something
	}

	@Test
	//Testing if we can read booking periods from file 
	public void readBookingPeriods() throws InvalidAttributeIdentifierException {
		List<BookingPeriod> bookingperiods = new ArrayList<>();
		Path file1 = Paths.get(BOOKING_PERIODS_FILE_PATH);
		readFileBookingPeriods(file1, bookingperiods);
//TODO where is the assertion? every test should check something
	}

	public void readFileAccommodation(Path file, List<Accommodation> rooms) throws InvalidAttributeIdentifierException {
		Charset charset = Charset.forName("UTF8");
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				rooms.add(createAccommodation(line));
			}
		} catch (IOException x) {
			System.err.println("IOException: " + x);
		}
	}

	public void readFileBookingPeriods(Path file, List<BookingPeriod> bookingPeriods)
			throws InvalidAttributeIdentifierException {
		Charset charset = Charset.forName("UTF8");
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				bookingPeriods.add(createBookingPeriods(line));
			}
		} catch (IOException x) {
			System.err.println("IOException: " + x);
		}
	}
	
	@Test
	public void testingIfDataAreCorrect() throws InvalidAttributeIdentifierException {
		List<Accommodation> rooms = new ArrayList<>();
		Path file = Paths.get(ROOMS_FILE_PATH);
		Charset charset = Charset.forName("UTF8");
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				rooms.add(createAccommodation(line));
			}
		} catch (IOException x) {
			System.err.println("IOException: " + x);
		}
		
		for (int i = 0; i < rooms.size(); i++) {
			System.out.println(rooms.get(i));		
		}
		
		
		
	}

	private Accommodation createAccommodation(String line) throws InvalidAttributeIdentifierException {
		Accommodation room = new Accommodation();
		String[] values = line.split(",");
		if (values.length != 6) {
			throw new InvalidAttributeIdentifierException();
		}
		return room;
	}

	private BookingPeriod createBookingPeriods(String line) throws InvalidAttributeIdentifierException {

		BookingPeriod bookingperiods = new BookingPeriod();
		String[] values1 = line.split(",");
		if (values1.length != 2) {
			throw new InvalidAttributeIdentifierException();
		}
		return bookingperiods;
	}

	
	
	public void writeFile(Path fileOut) {
		Accommodation room = new Accommodation();
		Charset charset = Charset.forName("UTF8");
		room.setDescription("Are vedere la mare");
		try (BufferedWriter writer = Files.newBufferedWriter(fileOut, charset, CREATE, APPEND)) {
			writer.write(room.getDescription());
			writer.close();
		} catch (IOException e) {
			System.err.println("IOException: " + e);
		}

	}

}
