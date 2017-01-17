package pattern_adapter;

public class MedicAdapter implements TerranInterface {

	// MedicInterface를 기본으로 하는 field를 가지고있다.
	private MedicInterface medic;
	
	// Dependency Injection
	// adapter 안에 메딕을 넣어서 adapter를 붙여준다.  
	public MedicAdapter(MedicInterface medic) {
		this.medic = medic;
	}
	
	@Override
	public void attack() {
		medic.heal(); 		// 이 어댑터는 메딕이 가지고 있는 heal을 호출한다. (기존의 메소드를 대체한다.)
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		medic.move();
	}
	
}
