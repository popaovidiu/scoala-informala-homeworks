package main.ro.sci.cardealership;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//Holds info about cars
public class Car {

	private double fuelTankSize;
	private String chassisNumber;
	private String fuelType;
	private int numberOfGears;
	private double fuelConsumption;
	private String carBrand;
	private String carModel;
	private float price;

	static ArrayList<Car> cars;

	public Car(String carBrand, String carModel, String chassisNumber, double fuelTankSize, String fuelType,
			int numberOfGears, double fuelConsumption, float price) {
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.chassisNumber = chassisNumber;
		this.fuelTankSize = fuelTankSize;
		this.fuelType = fuelType;
		this.numberOfGears = numberOfGears;
		this.fuelConsumption = fuelConsumption;
		this.price = price;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public double getFuelTankSize() {
		return fuelTankSize;
	}

	public String getFuelType() {
		return fuelType;
	}

	public int getNumberOfGears() {
		return numberOfGears;
	}

	public double getFuelConsumption() {
		return fuelConsumption;
	}

	public float getPrice() {
		return price;
	}

	private HashSet<Car> carsInStock = new HashSet<>();
	private HashMap<String, Float> priceCatalog = new HashMap();
	
	private List<Car> clientCarList = new ArrayList<>();

	public void addCarToFleet(Car car, float price) {
			carsInStock.add(car);
			priceCatalog.put(car.getChassisNumber(), price);
		}
	
	
}