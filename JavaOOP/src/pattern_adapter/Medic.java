package pattern_adapter;

public class Medic implements MedicInterface{

	@Override
	public void heal() {
		System.out.println("열심히 치료해요!!");		
	}

	@Override
	public void move() {
		System.out.println("메딕이 열심히 걸어갑니다..");		
	}

}
