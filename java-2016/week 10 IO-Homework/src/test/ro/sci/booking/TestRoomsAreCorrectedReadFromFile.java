package test.ro.sci.booking;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.naming.directory.InvalidAttributeIdentifierException;

import org.junit.Test;

import exception.ro.sci.booking.IllegalFormatInputDateException;
import exception.ro.sci.booking.InvalidAttributeIdentiefierException;
import main.ro.sci.booking.Accommodation;
/**
 * Test that rooms are correct read from file
 * @author Ovidiu Popa
 *
 */
public class TestRoomsAreCorrectedReadFromFile {

	private static String ROOMS_FILE_PATH = "C:\\Users\\Petronia\\Desktop\\booking\\doc\\rooms.txt";
	ArrayList<Accommodation> rooms = new ArrayList<>();
	String line;

	
	@Test
	public void testReadRoomDataFromFilePozitive() throws InvalidAttributeIdentifierException, IOException {
		Path file = Paths.get(ROOMS_FILE_PATH);//read room from file
		try {
			Scanner readFromFile = new Scanner(file);
			readFromFile.useDelimiter(",");

			while (readFromFile.hasNextLine()) {
				String name1 = readFromFile.next();
				String name2 = readFromFile.next();
				String name3 = readFromFile.next();
				int name4 = Integer.parseInt(readFromFile.next());
				String name5 = readFromFile.next();
				double name6 = Double.parseDouble(readFromFile.next());
				System.out.println("Numele camerei: " + name1);
				System.out.println("Pat: " + name2);
				System.out.println("Descriere: " + name3);
				System.out.println("Numar locuri: " + name4);
				System.out.println("Marime pat: " + name5);
				System.out.println("Tarif: " + name6);
			}
		} catch (FileNotFoundException e) {
			System.err.printf("Error: %s\n", e); // catch any problemat reading
		}

	}
	
	
	
	

	private Accommodation createAccommodation(String line) throws InvalidAttributeIdentifierException {
		Accommodation room = new Accommodation();
		String[] values = line.split(",");
		if (values.length != 6) {
			throw new InvalidAttributeIdentifierException();
		}
		System.out.println("aic: " + room);
		return room;
	}

		
	
}
