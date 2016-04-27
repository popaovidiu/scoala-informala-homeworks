package main.ro.sci.cardealership;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarDealership {
	ArrayList<Car> cars = new ArrayList<Car>();
	ArrayList<Client> client = new ArrayList<Client>();
	List<Car> clientCars = new ArrayList<>();
	List<Stock> stockList = new ArrayList<>();
	Car carToBuy = new Car(null, null, null, 0, null, 0, 0, 0);
	Car carToSell = new Car(null, null, null, 0, null, 0, 0, 0);
	private String carDealershipName;

	public String getCarDealershipName() {
		return carDealershipName;
	}

	public CarDealership(String carDealershipName) {
		this.carDealershipName = carDealershipName;
	}

	public void seeAvailableCars(Car car) {
		for (int i = 0; i < cars.size(); i++) {
			cars.get(i).getCarBrand();
			cars.get(i).getCarModel();
			cars.get(i).getChassisNumber();
			cars.get(i).getFuelTankSize();
			cars.get(i).getFuelType();
			cars.get(i).getNumberOfGears();
			cars.get(i).getFuelConsumption();
			cars.get(i).getPrice();
		}
	}

	// create a Client account
	private void createClientAccount(CarDealership carDealershipName, Car car, Client client) {
		clientCars.add(car);
		Map<Client, List<Car>> clientCarsMap = new HashMap<Client, List<Car>>();
		clientCarsMap.put(client, clientCars);

	}

	// Method for selling a car to client
//	public void sellCarToClient(ArrayList<Car> car, Client clientWhoBuysCar)
//			throws CarNotInStockException, InsuficientFundException {
//		checkCarAvailability(carToBuy);
//		double moneyInAccount = clientWhoBuysCar.moneyInAccount.getMoneyInAccount();
//
//		for (int i = 0; i < cars.size(); i++) {
//
//			if (car.get(i).getChassisNumber() == carToBuy.getChassisNumber() || moneyInAccount >= carToBuy.getPrice()) {
//				moneyInAccount -= carToBuy.getPrice();
//				clientWhoBuysCar.moneyInAccount.setMoneyInAccount(moneyInAccount);
//				car.remove(i);
//
//			} else {
//				throw new InsuficientFundException("Not Enough Money!");
//			}
//		}
//	}



	// Method for buying a car back from a client
//	public void buyCarFromClient(ArrayList<Car> cars, Client clientWhoSellsCar) {
//
//		double moneyInAccount1 = clientWhoSellsCar.moneyInAccount.getMoneyInAccount();
//		moneyInAccount1 += carToSell.getPrice();
//		clientWhoSellsCar.moneyInAccount.setMoneyInAccount(moneyInAccount1);
//		cars.add(carToSell);
//
//	}

	// Check if the car that the client wants to buy is available
	// the check is made by chassis number

	public void checkCarAvailability(Car car) throws CarNotInStockException {
		for (int i = 0; i < cars.size(); i++) {
			if (cars.get(i).getChassisNumber() == carToBuy.getChassisNumber()) {
				return;
			}

			else
				throw new CarNotInStockException("Car not in Stock!");
		}

	}

	// Add a car to Car dealership stock.
	public void addToStock(Stock stock) {
		stockList.add(stock);

	}

}
