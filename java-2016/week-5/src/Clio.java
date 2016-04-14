
public class Clio extends Renault {

	private final static float fuelTankSize = (float) 25.15;

	public Clio(float totalFuelAmount, String chasseNumber) {

		super(totalFuelAmount, chasseNumber, fuelTankSize, fuelType, numberOfGears, fuelConsumption);
	}

	private float getAverageFuelConsumptionPerGear() {
		double consumtionFactorPerGear = 0.89; // Different for every type of
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
		System.out.println("");
		System.out.println("-------   Renault Clio   -------");
		System.out.println("-------   START   -------");
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
