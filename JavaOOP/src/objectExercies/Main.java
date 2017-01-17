package objectExercies;

public class Main {
	
	public static void main(String[] args) {
		
		// Car class의 instance를 생성
		Car a = new Car();
		
		// println 안에는 String이 들어가야 한다. 하지만 instance가 들어간다면?
		// 문자열을 출력하려고 했는데, 인자로 instance ( a )가 들어갔다.
		// 그러면 해당 instance를 문자열로 바꾸어야 해요.
		
		
		// Overriding된 메소드가 있으면, data type의 method를 쓴다!!
		/*
		System.out.println(a.toString());
		*/
		
		Car car1 = new Car();	// 주소값 : 0x22334
		Car car2 = new Car();	// 주소값 : 0x22387
		
		// car1과 car2는 heap 안의 메모리 주소의 hash code 값을 가지고 있다.
		// 아무 처리도 하지 않으면 == 는 메모리 주소로 서로 같고 다름을 판단한다.
		
		car1.setOwner("홍길동");
		car2.setOwner("홍길동");
		
		// 나는 두 차의 owner가 같으면 같은 차라고 프로그램적으로 인식을 하고 있다.
		
		
		// 기본적으로 상속받는 equals()의 기능은 "==" 와 같다. (JAVA는 연산자 오버로딩은 안된다.)
		// 그래서 equals()를 overriding해서 내가 원하는 비교방식으로 재 작성하면 된다.
		if( car1.equals(car2) ){
			System.out.println("같아요!!");
		}
		else{
			System.out.println("달라요!!");
		}
		
	}
}
