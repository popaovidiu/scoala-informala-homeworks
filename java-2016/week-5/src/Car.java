
public abstract class Car implements Vehicle {

	protected boolean carStart = false;
	protected boolean carStop = false;
	double totalDistance = 0;
	double distanceInGear;

	private double fuelTankSize;
	protected static String fuelType;
	protected static int numberOfGears;
	protected static double fuelConsumption;
	private float totalFuelAmount;
	protected int gear = 1;
	private float averageFuelConsumption = 0;
	protected float averageFuelConsumptionPerGear;
	protected float availableFuelAmount;

	public Car(float totalFuelAmount, String chassisNumber, double fuelTankSize, String fuelType, int numberOfGears,
			double fuelConsumption) {
		this.totalFuelAmount = totalFuelAmount;
		this.fuelTankSize = fuelTankSize;
		Car.fuelType = fuelType;
		Car.numberOfGears = numberOfGears;
		Car.fuelConsumption = fuelConsumption;
	}

	public float getTotalFuelAmount() {
		return totalFuelAmount;
	}

	public void setTotalFuelAmount(float fuelAmount) {
		this.totalFuelAmount = fuelAmount;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		Car.fuelType = fuelType;
	}

	public float getAvailableFuel() {
		availableFuelAmount = getTotalFuelAmount();
		System.out.println("Total fuel amount was: " + getTotalFuelAmount() + " litters");
		availableFuelAmount -= averageFuelConsumptionPerGear;
		System.out.println("Available fuel amount is : " + availableFuelAmount + " litters");
		return availableFuelAmount;
	}

	public void shiftGear(int shiftgear) {
		gear = shiftgear;
	}

	public float getAverageFuelConsumption() {
		fuelConsumption = getAverageFuelConsumptionPerGear();
		System.out.println("The car consume: " + fuelConsumption + "  litters");
		averageFuelConsumption = (float) (100 * fuelConsumption / totalDistance);
		System.out.println("The car average fuel consumption was: " + averageFuelConsumption + "/100km");
		return averageFuelConsumption;

	}

	private float getAverageFuelConsumptionPerGear() {
		double consumtionFactorPerGear = 1.00; // Different for every type of
												// car
		if (carStart == true) {
			switch (gear) {
			case 1:
				averageFuelConsumptionPerGear += 0.14 * consumtionFactorPerGear * distanceInGear;
				System.out.println("The car moves " + distanceInGear + " km in 1 gear. Fueld used: "
						+ averageFuelConsumptionPerGear + " litters");
				break;

			case 2:
				averageFuelConsumptionPerGear += 0.11 * consumtionFactorPerGear * distanceInGear;
				System.out.println("The car moves " + distanceInGear + " km in 2 gear. Fueld used: "
						+ averageFuelConsumptionPerGear + " litters");
				break;

			case 3:
				averageFuelConsumptionPerGear += 0.09 * consumtionFactorPerGear * distanceInGear;
				System.out.println("The car moves " + distanceInGear + " km in 3 gear. Fueld used: "
						+ averageFuelConsumptionPerGear + " litters");
				break;

			case 4:
				averageFuelConsumptionPerGear += 0.07 * consumtionFactorPerGear * distanceInGear;
				System.out.println("The car moves " + distanceInGear + " km in 4 gear. Fueld used: "
						+ averageFuelConsumptionPerGear + " litters");
				break;

			case 5:
				averageFuelConsumptionPerGear += 0.05 * consumtionFactorPerGear * distanceInGear;
				System.out.println("The car moves " + distanceInGear + " km in 5 gear. Fueld used: "
						+ averageFuelConsumptionPerGear + " litters");
				break;
			}
		}
		return averageFuelConsumptionPerGear;
	}

	@Override
	public void start() {
		System.out.println("/p-------   START -------");
		System.out.println(
				"The " + fuelTankSize + " liters fuel tank contains " + getTotalFuelAmount() + " liters of fuel");
		carStart = true;
		carStop = false;
		fuelConsumption = 0;
		averageFuelConsumptionPerGear = 0;
	}

	@Override
	public void stop() {
		carStop = true;
		carStart = false;
		System.out.println("-----  STOP -----");
		System.out.println("The car has been driven for: " + totalDistance + " km");

	}

	@Override
	public double drive(double distance) {
		if (carStart == true) {
			distanceInGear = distance;
			totalDistance += distance;
			getAverageFuelConsumptionPerGear();
		} else {
			totalDistance = 0;
		}
		return totalDistance;
	}
}
