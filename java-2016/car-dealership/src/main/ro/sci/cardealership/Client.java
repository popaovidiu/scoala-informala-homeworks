package main.ro.sci.cardealership;


//Holds info about clients: Firs name, last name, account number and money in account
public class Client {

	private String firstName;
	private String lastName;
	BankAccount accountNumber;
	BankAccount moneyInAccount;

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

//	public Client (String firstName, String lastName, BankAccount accountNumber, BankAccount moneyInAccount) {
//		this.firstName = getFirstName();
//		this.lastName = getLastName();
//		accountNumber.getAccountNumber();
//		moneyInAccount.getMoneyInAccount();
//	}

	

	
}
