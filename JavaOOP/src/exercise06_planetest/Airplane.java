package exercise06_planetest;

public class Airplane extends Plane{
	
	public Airplane() {
		// TODO Auto-generated constructor stub
	}
	
	// 인자를 받아들이는 생성자
	public Airplane(String planeName, int fuelSize){
		// 상위 클래스에 있는 planeName과 fuelSize를 써야한다.
		// 따라서 인자를 상위클래스의 생성자에다 넣어주면 된다.
		super(planeName, fuelSize);		
	}
	
	@Override
	public void flight(int distance){
		// distance 10 운항시, 연료량 30 감소
		int currentFuel = getFuelSize();
		setFuelSize(currentFuel - (distance*3));
	}
}
