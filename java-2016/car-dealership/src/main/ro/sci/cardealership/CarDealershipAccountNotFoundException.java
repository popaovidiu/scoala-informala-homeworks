package main.ro.sci.cardealership;

public class CarDealershipAccountNotFoundException extends Exception {

	String message;

	public CarDealershipAccountNotFoundException(String message) {
		this.message = message;

	}

	public String getMessage() {
		return message;
	}
}
