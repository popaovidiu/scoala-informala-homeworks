package main.ro.sci.cardealership;

public class CarNotInStockException extends Exception {

	String message;

	public CarNotInStockException(String message) {
		this.message = message;

	}

	public String getMessage() {
		return message;
	}

}