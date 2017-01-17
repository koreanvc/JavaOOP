package pattern_adapter;

public class Marine implements TerranInterface{

	@Override
	public void attack() {
		System.out.println("총을쏴요!! 두두두두!!");
	}

	@Override
	public void move() {
		System.out.println("열심히 뛰어갑니다.");		
	}
	
}
