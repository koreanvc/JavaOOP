package interfaceExercises;


// interface의 형태
public interface Test {
	
	String name = "홍길동";
	int age = 20;
	
	void printInfo();
}


// Java는 단일 상속만 지원한다. (한번에 하나씩만 상속받을 수 있다.) C++은 다중상속 가능
interface MyInterface extends Test{
	
}


// Java는 다중 구현을 지원한다. interface를 이용해서 class를 구현할때, 여러개 implement 가능하다.
class MyClass implements Test{

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		
	}
	
}