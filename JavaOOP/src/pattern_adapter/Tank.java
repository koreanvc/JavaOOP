package pattern_adapter;

public class Tank implements TerranInterface{

	@Override
	public void attack() {
		System.out.println("퉁퉁포를쏴요!!");		
	}

	@Override
	public void move() {
		System.out.println("탱크가 움직여요..느려요!!");		
	}

}
