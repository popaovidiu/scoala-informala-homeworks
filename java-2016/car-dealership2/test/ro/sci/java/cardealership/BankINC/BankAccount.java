package ro.sci.java.cardealership.BankINC;

import main.ro.sci.cardealership.CarDealership;
import ro.sci.java.cardealership.InsufficientFundsException;

public class BankAccount {

	private String iban;
	protected float balance;
	CarDealership dealership;
	
	public BankAccount(String iban, float balance) {
		super();
		this.iban = iban;
		this.balance = balance;
	}

	public void transferFunds(Float amount, BankAccount destinationAccount) throws InsufficientFundsException {
		if (balance < amount) {
			throw new InsufficientFundsException();
		}
		balance -= amount;
		destinationAccount.balance += amount;
	}
	
	public void transferFundsFromCarDealershipToClient(Float amount, BankAccount destinationAccount) throws InsufficientFundsException {
		if (balance < amount) {
			throw new InsufficientFundsException();
		}
		balance += amount;
		destinationAccount.balance -= amount;
	}

}