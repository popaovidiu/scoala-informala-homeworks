package ro.sci.bookstore;
/**
 * Test Customer and Address for:
 * if a customer name and email are not null;
 * if street and number equal street and number of mock customer;
 * if the wrong city not equal the correct city.
 */

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCustomerAndAdress {

	Customer customer = new Customer();

	@Before
	/**
	 * Creating a mock Customer with a mock address
	 */
	public void initCustomer() {
		// init customer
		customer.setName("Popescu Ion");
		customer.setEmail("popescu@personal.ro");
		customer.address.setStreet("Gherghina");
		customer.address.setNumber(101);
		customer.address.setCity("Cluj-Napoca");		
		customer.address.setNumber(101);
		customer.address.setCity("Cluj-Napoca");

		customer.cart = null;
		System.out.println("Before");
		System.out.println("Name: " + customer.getName() + ", email: " + customer.getEmail());
		System.out.println("ADRESS Street: " + customer.address.getStreet() + ", No: " + customer.address.getNumber()
				+ ", City: " + customer.address.getCity());
	}

	@Test
	public void testCustomer() {
		assertNotNull(customer.getName());
		assertNotNull(customer.getEmail());
		assertEquals("Gherghina", customer.address.getStreet());
		assertEquals(101, customer.address.getNumber());
		assertNotEquals("Oradea", customer.address.getCity());
		assertTrue(customer.cart == null);
	}

	@After
	public void destroyCustomer() {
		// destroy customer
		customer.setName(null);
		customer.setEmail(null);
		customer.address.setStreet(null);
		customer.address.setNumber(0);
		customer.address.setCity(null);
	}

}
