package test.ro.sci.booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import exception.ro.sci.booking.IllegalFormatInputDateException;
import exception.ro.sci.booking.InvalidAttributeIdentiefierException;
import main.ro.sci.booking.Accommodation;

/**
 * Test that booking periods are read correct from file
 * 
 * @author Ovidiu Popa
 *
 */
public class TestDatesAreCorrectReadFromFile extends AbstractBookingTest {

	private static String BOOKING_PERIODS_FILE_PATH = "C:\\Users\\Petronia\\Desktop\\booking\\doc\\bookingperiods.txt";

	ArrayList<Accommodation> rooms = new ArrayList<>();
	String friend = "";
	String line;
	Accommodation room;
	public List<Date> dateIn;
	public List<Date> dateOut;
	private Date date;
	private SimpleDateFormat simpleDateFormat;

	@Test
	public void testReadBookingsFromFilePozitive() throws IllegalFormatInputDateException {
		Path file2 = Paths.get(BOOKING_PERIODS_FILE_PATH);
		dateIn = new ArrayList<>();
		dateOut = new ArrayList<>();
		try {
			readDateFromFiles(file2, dateIn, dateOut);
		} catch (InvalidAttributeIdentiefierException e) {
			e.printStackTrace();
		}
	}

	// TODO add visibility modifier
	// read data from file
	void readDateFromFiles(Path file1, List<Date> in, List<Date> out)
			throws InvalidAttributeIdentiefierException, IllegalFormatInputDateException {
		Charset charset = Charset.forName("UTF8");
		try (BufferedReader reader = Files.newBufferedReader(file1, charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				in.add(createObjectfromDateIn(line));
				out.add(createObjectfromDateOut(line));
			}
		} catch (IOException x) {
			System.err.println("IOException " + x);
		}
	}

	// create object from date that were read from file. Format of date is
	// yyyy-mm-dd
	// Date in
	public Date createObjectfromDateIn(String line) throws IllegalFormatInputDateException {
		String regex = "[\\d]{4}-[\\d]{2}-[\\d]{2}";
		String[] dates = line.split(",");
		if (dates[0].matches(regex)) {
			return createDate(dates[0].trim());
		} else
			throw new IllegalFormatInputDateException("The input data must be only numbers");
	}

	// create object from date that were read from file. Format of date is
	// yyyy-mm-dd
	// Date out
	public Date createObjectfromDateOut(String line) throws IllegalFormatInputDateException {
		String regex = "[\\d]{4}-[\\d]{2}-[\\d]{2}";
		String[] dates = line.split(",");
		if (dates[1].matches(regex)) {
			return createDate(dates[1].trim());
		} else
			throw new IllegalFormatInputDateException("The input data must be only numbers");
	}

	// create date for Date in and Date out
	public Date createDate(String line) {
		try {
			simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			// TODO - date should be declared here, not as a field
			date = simpleDateFormat.parse(line);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

}
