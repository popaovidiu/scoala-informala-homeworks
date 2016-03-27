package ro.sci.bookstore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Ovidiu Popa This TestStock class tests: 
 * if stock is not null; 
 * if stock > 0; 
 * if stock equals a predefined value.
 *
 */

public class TestStock {

	int[] stock = new int[3];

	@Before
	public void initStock() {
		// init Stock
		Stock stockQuantity = new Stock();
		stockQuantity.setQuantity(12);
		for (int i = 0; i < stock.length; i++) {
			stock[i] = stockQuantity.getQuantity();
		}
	}

	@Test
	public void test() {
		for (int i = 0; i < stock.length; i++) {
			assertNotNull(stock[i]);
			assertTrue(stock[i] > 0);
			assertEquals(12, stock[i]);
		}

	}

	@After
	// Destroying Stock
	public void destroyStock() {
		stock = null;
	}
}
