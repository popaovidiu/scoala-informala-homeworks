package ro.sci.bookstore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCatalog {

	List<Book> catalog = null;

	@Before
	public void initCatalog() {
		// init catalog
		catalog = new ArrayList<Book>();
		catalog.add(createNewBook("Abecedar", "Education", "Prof", 10001, 15d));
	}

	@Test
	public void testCatalogSize() {
		assertNotNull(catalog);
		assertTrue(catalog.size() > 0);
	}

	@Test
	public void testCatalogContent() {
		Book firstBook = catalog.get(0);

		assertEquals("Abecedar", firstBook.getTitle());
	}

	private Book createNewBook(String title, String genre, String author, int isbn, double price) {
		Book book = new Book(isbn);
		book.setAuthor(author);
		book.setGenre(genre);
		book.setPrice(price);
		book.setTitle(title);
		book.setWeight(200);
		return book;
	}

	@After
	public void destroyCatalog() {
		// destroy catalog
		catalog = null;

	}
}