package ro.sci.bookstore;

/**
 * 
 * @author Ovidiu Popa This is a class that defines the Customer who has: 
 * 			name, email - defined in this class. 
 * 			address - defined in Address class.
 *          and cart - defined in Cart class.
 */

public class Customer {

	private String name;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	Address address = new Address();
	Cart cart = new Cart();

}
