package exercise06_planetest;

public class Cargoplane extends Plane{
	
	public Cargoplane() {
		// TODO Auto-generated constructor stub
	}
	
	public Cargoplane(String planeName, int fuelSize){
		super(planeName, fuelSize);
	}
	
	public void flight(int distance){
		int currentFuel = getFuelSize();
		setFuelSize(currentFuel - (distance*5));
	}
}
