package main.ro.sci.cardealership;

public class InsuficientFundException extends Exception {

	private String message;

	public InsuficientFundException(String message) {

		this.message = message;

	}

	public String getMessage() {
		return message;
	}

}