package ro.sci.java.cardealership.clients;

import main.ro.sci.cardealership.Car;
import ro.sci.java.cardealership.BankINC.BankAccount;

public class Client {
	private String name;
	private String address;
	private BankAccount bankAccount;
	private String id;

	public Client(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public String getId() {
		return id;
	}

	

}
