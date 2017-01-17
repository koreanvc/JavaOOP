package myException;

import java.util.Random;

public class Main {
	
	// 만약에 Exception이 발생하면, 이것을 호출한 곳으로 던지겠다.
	// 메소드에서 throws라는 구문을 이용해서 main의 try로 던진다. (try~catch의 산재성 방지)
	// Exception을 각 메소드에서 개별적으로 처리하는게 아니라, 하나로 묶어서 모든 Exception을 한 곳으로 모은다.
	public static void test() throws Exception{
		System.out.println("호출되요!!");
		// 만약 exception 처리 코드가 필요하다면?
		// exception처리가 필요한 모든 메소드마다 try~catch가 다 들어가야 한다.
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	public static void main(String[] args) {
		
		// 발생 가능한 여러 가지 예외 상황들이 있어요.
		// 코드 상에는 문제가 없지만, 실제 실행할 때 문제가 생긴다.
		// exception이 발생했을 때, 프로그램이 강제종료되지 않고 프로그램을 계속 돌리는것 -> try ~ catch 구문
		// 여기서 에러가 발생할 수 있을 것 같다. -> try로 묶는다.
		
		/*
		try {
			int a = 100 / 0 ;
			
			Random r = null;			// 변수는 있지만 실제로 가리키는 것은 없다. (객체가 없다.)
			int num = r.nextInt();		// 객체가 없는데(실체가없는데) 그 객체를 사용하려고 한다. -> nullPointer exception!
			
		} catch(ArithmeticException e) {
			// try에서 잘 되면, catch문을 실행하지 않는다.
			System.out.println(e); 		// 실제 exception처리는 이렇게 하지 않는다. 오류가 무엇인지 알기 위해 그냥 쓰는것.
			
			// 이 부분은 발생한 Exception을 처리해서 프로그램이 정상적으로 계속 수행될 수 있도록
			// 처리하는 코드가 나와야 한다. -> 이게 Exception Handling이다.
			
		} catch(NullPointerException e1) {
			System.out.println(e1);
		} finally {
			
		}
		*/
		
		// 2. 만약 강제로 Exception을 발생시키고 싶으면?
		try { 
			// Exception 객체를 하나 만들어준다.
			test();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("잘 수행 되나요??");
		
	}
}
