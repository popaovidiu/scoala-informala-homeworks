package main.ro.sci.cardealership;

//manages the bank account info: account number and money in account;


public class BankAccount {

	private String iban;
	protected float balance;

	public BankAccount(String iban, float balance) {
		super();
		this.iban = iban;
		this.balance = balance;
	}

	public void transferFunds(Float amount, BankAccount destinationAccount) throws InsuficientFundException {
		if (balance < amount) {
			throw new InsuficientFundException("Fonduri insuficiente");
		}
		balance -= amount;
		destinationAccount.balance += amount;
	}
	
}
