package ro.sci.java.cardealership;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import main.ro.sci.cardealership.Car;

public class CarDealershipTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCarDealershipListNotEmpty() {
		// given
		CarDealership dealership = new CarDealership("compexit");
		Car car = new Car("Dacia", "Logan", "1231223", 52.32, "diesel", 5, 6.5, 1234);
		Car car2 = new Car("Ford", "Fiesta", "1112111", 32.21, "petrol", 5, 4.5, 3211);
		// when
		dealership.addToStock(car,0);
		dealership.addToStock(car2,0);
		List<Car> cars = dealership.listAllCars();
		// then
		assertTrue(!cars.isEmpty());
	}

	@Test
	public void testCarDealershipContainCorrectNUmberOfCars() {
		// given
		CarDealership dealership = new CarDealership("compexit");
		Car car = new Car("Dacia", "Logan", "1231223", 52.32, "diesel", 5, 6.5, 1234);
		Car car2 = new Car("Ford", "Fiesta", "1112111", 32.21, "petrol", 5, 4.5, 3211);
		// when
		dealership.addToStock(car,0);
		dealership.addToStock(car2,0);
		List<Car> cars = dealership.listAllCars();
		// then
		assertTrue(cars.size() == 2);
	}

	@Test
	public void testCarDealershipDoesNotContainDuplicates() {
		// given
		CarDealership dealership = new CarDealership("compexit");
		Car car = new Car("Dacia", "Logan", "1231223", 52.32, "diesel", 5, 6.5, 1234);
		Car car2 = new Car("Ford", "Fiesta", "1112111", 32.21, "petrol", 5, 4.5, 3211);
		// when
		dealership.addToStock(car,0);
		dealership.addToStock(car2,0);
		dealership.addToStock(car2,0);
		List<Car> cars = dealership.listAllCars();
		// then
		assertTrue(cars.size() == 2);
	}

	@Test
	public void testExternalModificationOnCarDealershipDoNotAffectInternelStructure() {
		// daca stergem o masina cumparata
		// given
		CarDealership dealership = new CarDealership("compexit");
		Car logan = new Car("Dacia", "Logan", "1231223", 52.32, "diesel", 5, 6.5, 1234);
		Car fiesta = new Car("Ford", "Fiesta", "1112111", 32.21, "petrol", 5, 4.5, 3211);
		// when
		dealership.addToStock(logan,0);
		dealership.addToStock(fiesta,0);
		List<Car> cars = dealership.listAllCars();
		cars.remove(logan);
		// then
		assertEquals(2, dealership.listAllCars().size());	

	}
}
