package ro.sci.java.cardealership;


import java.util.ArrayList;
import java.util.List;

import main.ro.sci.cardealership.Car;

public class ClientAccount {
	private String clientName;

	public ClientAccount(String clientName) {
		super();
		this.clientName = clientName;
	}

	private List<Car> clientCarList = new ArrayList<>();

	public void addCarToFleet(Car car) {
		clientCarList.add(car);
	}

	public void removeCarToFleet(Car car) {
		clientCarList.remove(car);
	}

	
	public List<Car> getFleet() {
		
		return new ArrayList<Car>(clientCarList);
	}

}