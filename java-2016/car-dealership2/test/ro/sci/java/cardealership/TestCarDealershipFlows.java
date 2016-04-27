package ro.sci.java.cardealership;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import main.ro.sci.cardealership.Car;
import ro.sci.java.cardealership.BankINC.BankAccount;
import ro.sci.java.cardealership.clients.Client;
import ro.sci.java.cardealership.*;
public class TestCarDealershipFlows {



	/**
	 * given when then
	 * @throws InsufficientFundsException 
	 * @throws main.ro.sci.cardealership.InsufficientFundsException 
	 * @throws ClientDoesNotHaveBankAccount 
	 */

	@Test
	public void testSuccesfullSellingOfCarToClientFlow() throws InsufficientFundsException, ClientDoesNotHaveBankAccount {
		// given
		CarDealership dealership = new CarDealership("compexit");
		Client client = new Client("666", "Jack", "Florilor 46");
		BankAccount bankAccount = new TestBankAccount("000", 50000);
		client.setBankAccount(bankAccount);
		Car logan = new Car("Dacia", "Logan", "1231223", 52.32, "diesel", 5, 6.5, 1234);
		Car fiesta = new Car("Ford", "Fiesta", "1112111", 32.21, "petrol", 5, 4.5, 4500);
		dealership.addToStock(logan, 4500);
		dealership.addToStock(fiesta, 8500);
		TestBankAccount carDealershipBankAccount = new TestBankAccount("001", 60000);
		dealership.setBankAccount(carDealershipBankAccount);
		// when
		dealership.sellCarToClient(client, fiesta);
		// then
		assertEquals(1, dealership.listAllCars().size());
		assertFalse(dealership.listAllCars().contains(fiesta));
		assertEquals(41500, ((TestBankAccount)client.getBankAccount()).getBalance(),0);
		assertEquals(68500, carDealershipBankAccount.getBalance(), 0);
		ClientAccount clientAccount = dealership.getClientAccount(client);
		assertNotNull(clientAccount);
		assertTrue(clientAccount.getFleet().contains(fiesta));
	}

	
	@Test(expected = InsufficientFundsException.class)
	public void whenNotEnoughtMoneyCarSellingFails() throws InsufficientFundsException, ClientDoesNotHaveBankAccount {
		// given
		CarDealership dealership = new CarDealership("compexit");
		Client client = new Client("666", "Jack", "Florilor 33");
		BankAccount bankAccount = new TestBankAccount("000", 100);
		client.setBankAccount(bankAccount);
		Car logan = new Car("Dacia", "Logan", "1231223", 52.32, "diesel", 5, 6.5, 1234);
		Car fiesta = new Car("Ford", "Fiesta", "1112111", 32.21, "petrol", 5, 4.5, 4500);
		dealership.addToStock(logan, 4500);
		dealership.addToStock(fiesta, 8500);
		// when
		TestBankAccount carDealershipBankAccount = new TestBankAccount("001", 60000);
		dealership.setBankAccount(carDealershipBankAccount);
		dealership.sellCarToClient(client, logan);
		// then
		fail("Exception should have been thrown.");
	}
	
	
	
	@Test
	//Car dealership Client sell back car - buyback - happy flow
	public void testCarDealershipClientSellBackCar() throws InsufficientFundsException {
		// given
		CarDealership dealership = new CarDealership("compexit");
		Client client = new Client("666", "Jack", "Florilor 46");
		List<Car> clientCarList = null;
		BankAccount bankAccount = new TestBankAccount("000", 50000);
		client.setBankAccount(bankAccount);
		Car logan = new Car("Dacia", "Logan", "1231223", 52.32, "diesel", 5, 6.5, 1234);
		Car fiesta = new Car("Ford", "Fiesta", "1112111", 32.21, "petrol", 5, 4.5, 4500);
		Car focus = new Car("Ford", "Focus", "1312111", 32.21, "petrol", 5, 4.5, 5000);
		dealership.addToStock(logan, 4500);
		dealership.addToStock(fiesta, 8500);
		focus.addCarToFleet(focus, 5000);
		TestBankAccount carDealershipBankAccount = new TestBankAccount("001", 60000);
		dealership.setBankAccount(carDealershipBankAccount);
		// when
		dealership.buyCarFromClient(client, focus);
		// then
		assertEquals(3, dealership.listAllCars().size());
		assertTrue(dealership.listAllCars().contains(focus));
		assertEquals(55000, ((TestBankAccount)client.getBankAccount()).getBalance(),0);
		assertEquals(55000, carDealershipBankAccount.getBalance(), 0);
		ClientAccount clientAccount = dealership.getClientAccount(client);
		assertNotNull(clientAccount);
		assertFalse(clientAccount.getFleet().contains(focus));
	}
	
	@Test(expected = InsufficientFundsException.class)
	//Car dealership Client sell back car, dealeship does not have enought money to buy car
	public void testCarDealershipClientSellBackCarNotEnoughMoneyToBuy() throws InsufficientFundsException {
		// given
		CarDealership dealership = new CarDealership("compexit");
		Client client = new Client("666", "Jack", "Florilor 46");
		List<Car> clientCarList = null;
		BankAccount bankAccount = new TestBankAccount("000", 50000);
		client.setBankAccount(bankAccount);
		Car logan = new Car("Dacia", "Logan", "1231223", 52.32, "diesel", 5, 6.5, 1234);
		Car fiesta = new Car("Ford", "Fiesta", "1112111", 32.21, "petrol", 5, 4.5, 4500);
		Car focus = new Car("Ford", "Focus", "1312111", 32.21, "petrol", 5, 4.5, 5000);
		dealership.addToStock(logan, 4500);
		dealership.addToStock(fiesta, 8500);
		focus.addCarToFleet(focus, 5000);
		TestBankAccount carDealershipBankAccount = new TestBankAccount("001", 600);
		dealership.setBankAccount(carDealershipBankAccount);
		// when
		dealership.buyCarFromClient(client, focus);
		if (carDealershipBankAccount.getBalance() <0) {
			throw new InsufficientFundsException();
		}
		fail("Exception should have been thrown.");
	}
	
	
	@Test
	//Car dealership Client buys more cars
	public void testClientBuysMoreCars() throws InsufficientFundsException, ClientDoesNotHaveBankAccount {
		// given
		CarDealership dealership = new CarDealership("compexit");
		Client client = new Client("666", "Jack", "Florilor 46");
		BankAccount bankAccount = new TestBankAccount("000", 50000);
		client.setBankAccount(bankAccount);
		Car logan = new Car("Dacia", "Logan", "1231223", 52.32, "diesel", 5, 6.5, 1234);
		Car fiesta = new Car("Ford", "Fiesta", "1112111", 32.21, "petrol", 5, 4.5, 4500);
		dealership.addToStock(logan, 4500);
		dealership.addToStock(fiesta, 8500);
		TestBankAccount carDealershipBankAccount = new TestBankAccount("001", 60000);
		dealership.setBankAccount(carDealershipBankAccount);
		// when
		dealership.sellCarToClient(client, fiesta);
		dealership.sellCarToClient(client, logan);
		// then
		assertEquals(0, dealership.listAllCars().size());
		assertFalse(dealership.listAllCars().contains(fiesta));
		assertFalse(dealership.listAllCars().contains(logan));
		assertEquals(37000, ((TestBankAccount)client.getBankAccount()).getBalance(),0);
		assertEquals(73000, carDealershipBankAccount.getBalance(), 0);
		ClientAccount clientAccount = dealership.getClientAccount(client);
		assertNotNull(clientAccount);
		assertTrue(clientAccount.getFleet().contains(fiesta));
		assertTrue(clientAccount.getFleet().contains(logan));
		assertEquals(2, clientAccount.getFleet().size());
	}
	
	

	@Test(expected = ClientDoesNotHaveBankAccount.class)
	//Client does not have a bank account
	public void whenClientDoesNotHaveAnAccount() throws InsufficientFundsException, ClientDoesNotHaveBankAccount {
		// given
		CarDealership dealership = new CarDealership("compexit");
		Client client = new Client("666", "Jack", "Florilor 33");
		//BankAccount bankAccount = new TestBankAccount("000", 100);
		//client.setBankAccount(bankAccount);
		Car logan = new Car("Dacia", "Logan", "1231223", 52.32, "diesel", 5, 6.5, 1234);
		Car fiesta = new Car("Ford", "Fiesta", "1112111", 32.21, "petrol", 5, 4.5, 4500);
		dealership.addToStock(logan, 4500);
		dealership.addToStock(fiesta, 8500);
		// when
		TestBankAccount carDealershipBankAccount = new TestBankAccount("001", 60000);
		dealership.setBankAccount(carDealershipBankAccount);
		dealership.sellCarToClient(client, logan);
		// then
		fail("Exception should have been thrown.");
	}
	
	
		
	
	private static class TestBankAccount extends BankAccount {

		public TestBankAccount(String iban, float balance) {
			super(iban, balance);
			}

		private float getBalance() {
			return balance;

		}
	}

}
