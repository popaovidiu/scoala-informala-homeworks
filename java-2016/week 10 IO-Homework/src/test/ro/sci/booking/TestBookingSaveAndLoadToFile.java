package test.ro.sci.booking;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exception.ro.sci.booking.InvalidAttributeIdentiefierException;
import main.ro.sci.booking.Accommodation;
import main.ro.sci.booking.AccommodationType;
import main.ro.sci.booking.Booking;
import main.ro.sci.booking.BookingPeriod;
import main.ro.sci.booking.RoomFair;
import main.ro.sci.booking.Season;
import main.ro.sci.booking.SeasonType;

/**
 * Test to see that a bookingis saved and load correct from file
 * 
 * @author Ovidiu Popa
 *
 */

public class TestBookingSaveAndLoadToFile {

	private static final OpenOption CREATE = null;
	private static final OpenOption APPEND = null;
	private static String ROOMS_FILE_PATH = "C:\\Users\\Petronia\\Desktop\\booking\\doc\\rooms.txt";
	private static String BOOKING_FILE_PATH = "C:\\Users\\Petronia\\Desktop\\booking\\doc\\booking.txt";
	private static String BOOKING_PERIODS_FILE_PATH = "C:\\Users\\Petronia\\Desktop\\booking\\doc\\bookingperiods.txt";
	ArrayList<Accommodation> rooms = new ArrayList<>();
	String line;
	ArrayList<Object> bookingView = new ArrayList<>();
	ArrayList<Object> bookingPeriod = new ArrayList<>();
	ArrayList<Object> bookingCheck = new ArrayList<>();
	private Scanner readFromFile;
	private Scanner readFromFile2;

	@Test
	public void testBookISSavedCorrect() throws IOException {
		Path file = Paths.get(ROOMS_FILE_PATH);//reading room data from file
		try {
			readFromFile2 = new Scanner(file);
			readFromFile2.useDelimiter(",");

			while (readFromFile2.hasNextLine()) {
				bookingView.add(readFromFile2.next());
				bookingView.add(readFromFile2.next());
				bookingView.add(readFromFile2.next());
				bookingView.add(Integer.parseInt(readFromFile2.next()));
				bookingView.add(readFromFile2.next());
				bookingView.add(Double.parseDouble(readFromFile2.next()));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: %s\n" + e); // catch any problem
		}

		Path file1 = Paths.get(BOOKING_PERIODS_FILE_PATH);//reading booking periods from file
		try {
			readFromFile = new Scanner(file1);
			readFromFile.useDelimiter(",");

			while (readFromFile.hasNextLine()) {
				bookingPeriod.add(readFromFile.nextLine());
				bookingPeriod.add(readFromFile.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: %s\n" + e); // catch any problem
		}

		BufferedWriter writer = new BufferedWriter(
				new FileWriter("C:\\Users\\Petronia\\Desktop\\booking\\doc\\booking.txt"));//wrinting booking to file
		String room = (String) bookingView.get(0);
		String roomType = (String) bookingView.get(1);
		String roomDescription = (String) bookingView.get(2);
		int roomCapacity = (int) bookingView.get(3);
		String bedType = (String) bookingView.get(4);
		double roomFair = (double) bookingView.get(5);
		String bookingP = (String) bookingPeriod.get(0);

		String bookingInfo = room + "," + roomType + "," + roomDescription + "," + roomCapacity + "," + bedType + ","
				+ roomFair + "," + bookingP;
		writer.write(bookingInfo);
		writer.newLine();
		writer.close();

	}

	@Test
	public void testBookIsLoadCorrect() throws IOException {
		for (int i = 0; i < bookingCheck.size(); i++) {
			assertNotNull(bookingCheck.get(i));
		}
	}

	public void loadBookingFromFile() throws IOException {
		Path file = Paths.get(BOOKING_FILE_PATH);//load booking data from file
		try {
			readFromFile = new Scanner(file);
			readFromFile.useDelimiter(",");

			while (readFromFile.hasNextLine()) {
				bookingCheck.add(readFromFile.next());
				bookingCheck.add(readFromFile.next());
				bookingCheck.add(readFromFile.next());
				bookingCheck.add(readFromFile.next());
				bookingCheck.add(readFromFile.next());
				bookingCheck.add(readFromFile.next());
				bookingCheck.add(readFromFile.next());
				bookingCheck.add(readFromFile.next());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: %s\n" + e); // catch any problem

		}
	}
}