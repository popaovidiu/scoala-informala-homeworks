public class VehicleApp {

	public static void main(String[] args) {
		// Car car = new Car(); // Car should be a base class.

		int currentFuelAmmount = 27;

		String chasseNumber = "oiqe0934hkkadsn";

		// Car car = new Fiat(currentFuelAmmount, chasseNumber); // This should
		// not be allowed! If I
		// want to create a Fiat car, I
		// will need to create an instance of a
		// model.

		Car car = new Panda(currentFuelAmmount, chasseNumber); // Panda can
																// extend from
																// Fiat, while
																// Fiat extends
																// from Car

		car.start();

		car.shiftGear(1);

		car.drive(0.01);// drives 0.01 KMs

		car.shiftGear(2);

		car.drive(0.02);

		car.shiftGear(3);

		car.drive(0.5);

		car.shiftGear(4);

		car.drive(0.5);

		car.shiftGear(4);

		car.drive(0.5);

		car.shiftGear(5);

		car.drive(10);

		car.shiftGear(4);

		car.drive(0.5);

		car.shiftGear(3);

		car.drive(0.1);

		car.stop();

		float availableFuel = (float) car.getAvailableFuel(); // this value must
																// be smaller
																// than the
																// initial value
																// passed
																// in the
																// constructor

		float fuleConsumedPer100Km = car.getAverageFuelConsumption();

		Vehicle vehicle = new Laguna(30, "1987ddkshik289"); // available fuel
															// and chases
															// number

		vehicle.start();

		vehicle.drive(1);

		vehicle.stop();

		Car car1 = (Car) vehicle;

		float availableFuel1 = car1.getAvailableFuel();

		float fuleConsumedPer100Km1 = car1.getAverageFuelConsumption();

	}

}
