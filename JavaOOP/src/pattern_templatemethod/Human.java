package pattern_templatemethod;

// 상위 class를 추상 class로 만든다.
public abstract class Human {
	
	// 이게 template method이다. (상위 class에서 전체 logic을 알고리즘에 의해 돌리는 메소드)
	// 따라서 상위 class에서 프로그램이 어떻게 동작할 것인지에 대한 결정이 이루어진다.
	public void makeFriends() {
		dress();
		search();
		doAction();
		confess();
	}
	
	
	// interface를 쓸 수 없는 이유는, 완전히 구현된 코드가 여기 들어와서이다.
	public void dress() {
		System.out.println("옷을 입어요!!");
	}
	public void confess() {
		System.out.println("고백을 해요!!");		
	}
	
	public abstract void search();
	public abstract void doAction();
	
	
}
