package main.ro.sci.cardealership;

public class BankAccountNotFoundException extends Exception {

	String message;

	public BankAccountNotFoundException(String message) {
		this.message = message;

	}

	public String getMessage() {
		return message;
	}
}