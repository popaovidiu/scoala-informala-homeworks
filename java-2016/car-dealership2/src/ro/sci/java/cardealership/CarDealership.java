package ro.sci.java.cardealership;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import main.ro.sci.cardealership.Car;
import ro.sci.java.cardealership.BankINC.BankAccount;
import ro.sci.java.cardealership.clients.Client;
import ro.sci.java.cardealership.InsufficientFundsException;

public class CarDealership {

	
	private String dealershipName;
	private HashSet<Car> carsInStock = new HashSet<>();
	private HashSet<Car> clientCars = new HashSet<>();
	private HashMap<String, Float> priceCatalog = new HashMap();
	private HashMap<String, ClientAccount> clientAccounts = new HashMap<>();
	private BankAccount bankAccount;

	public CarDealership(String dealershipName){
		this.dealershipName = dealershipName;
	}

	public void addToStock(Car car, float price) {
		carsInStock.add(car);
		priceCatalog.put(car.getChassisNumber(), price);
		
	}

	public List<Car> listAllCars() {
		return new ArrayList<Car>(carsInStock);
	}

	public void sellCarToClient(Client client, Car car) throws InsufficientFundsException, ClientDoesNotHaveBankAccount {
		if (client.getBankAccount()==null){
			throw new ClientDoesNotHaveBankAccount();
		}
		if (carsInStock.contains(car)) {
			client.getBankAccount().transferFunds(priceCatalog.get(car.getChassisNumber()), bankAccount);
			carsInStock.remove(car);
			ClientAccount clientAccount = getWithAddClientAccount(client);
			clientAccount.addCarToFleet(car);
		}
	}

	
	public void buyCarFromClient(Client client, Car car) throws InsufficientFundsException {
			client.getBankAccount().transferFundsFromCarDealershipToClient(car.getPrice(), bankAccount);
			carsInStock.add(car);
			ClientAccount clientAccount = getWithAddClientAccount(client);
			clientAccount.removeCarToFleet(car);
	}
	
	
	private ClientAccount getWithAddClientAccount(Client client) {
		if (!clientAccounts.containsKey(client.getId())) {
			clientAccounts.put(client.getId(), new ClientAccount(client.getName()));
		}
		ClientAccount clientAccount = clientAccounts.get(client.getId());
		return clientAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public ClientAccount getClientAccount(Client client) {
		return clientAccounts.get(client.getId());
	}
		
	public BankAccount getBankAccount() {
		return bankAccount;
	}

	
}
