package main.ro.sci.cardealership;

//A class for cars that are in dealership stock
public class Stock {

	Car car;

	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void addCarToStock(CarDealership carDealership, Car car) {
		Stock stock = new Stock();
		stock.setCar(car);
		carDealership.addToStock(stock);
	}

}
