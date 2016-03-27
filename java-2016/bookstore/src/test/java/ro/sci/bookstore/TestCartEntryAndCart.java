package ro.sci.bookstore;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.lang.Integer;

/**
 * 
 * @author Ovidiu Popa
 * This TestCartEntryAndCart class tests:
 * if cart entry is not null;
 * if the book from cart entry equals a predefined value;
 * if the stock for every book is > 0.
 *
 */

public class TestCartEntryAndCart {

	List<Book> cartEntryBook = null;
	List<Integer> cartEntryQuantytiToBuy = new ArrayList<Integer>();
	private int[] stock = { 10, 10, 10 };
	// The Initial stock for "Abecedar" is 10.
	// The Initial stock for "Citire" is 10.
	// The Initial stock for "Matematica" is 10.
	private int[] finalStock = new int[3];

	CartEntry cartEntry = new CartEntry();

	@Before
	public void initCartEntry() {
		// init cartEntry
		cartEntryBook = new ArrayList<Book>();

		cartEntryBook.add(cartEntryBook("Abecedar", "Education", "Prof", 10001, 15d));
		cartEntry.setQuantityToBuy(1);
		cartEntryQuantytiToBuy.add(cartEntry.getQuantityToBuy());

		cartEntryBook.add(cartEntryBook("Citire", "Education", "Prof", 10002, 15d));
		cartEntry.setQuantityToBuy(2);
		cartEntryQuantytiToBuy.add(cartEntry.getQuantityToBuy());

		cartEntryBook.add(cartEntryBook("Matematica", "Education", "Prof", 10003, 15d));
		cartEntry.setQuantityToBuy(3);
		cartEntryQuantytiToBuy.add(cartEntry.getQuantityToBuy());

	}

	@Test
	public void testCartEntry() {
		Book bookAddInCart = cartEntryBook.get(0);
		assertNotNull(cartEntry.getQuantityToBuy());
		assertEquals("Abecedar", bookAddInCart.getTitle());

	}

	@Test
	public void testCartStock() {
		stockCheckingAndUpdating();
		for (int i = 0; i < cartEntryBook.size(); i++) {
			assertTrue(finalStock[i] > 0);
		}

	}

	public void stockCheckingAndUpdating() {
		// checking if quantity that customer wants to buy is less than stock
		//if quantity < stock than updating stock
		for (int i = 0; i < cartEntryBook.size(); i++) {
			if (cartEntryQuantytiToBuy.get(i) <= stock[i]) {
				finalStock[i] = stock[i] - cartEntryQuantytiToBuy.get(i);
				Book bookAddInCart = cartEntryBook.get(i);
				System.out.println("For book: " + bookAddInCart.getTitle() + " the stock left is " + finalStock[i]);

			}

		}

		return;
	}

	private Book cartEntryBook(String title, String genre, String author, int isbn, double price) {
		Book book = new Book(isbn);
		book.setAuthor(author);
		book.setGenre(genre);
		book.setPrice(price);
		book.setTitle(title);
		book.setWeight(200);
		return book;
	}

	@After
	public void destroyCartEntry() {
		// destroy cartEntry
		cartEntryBook = null;

	}

}
