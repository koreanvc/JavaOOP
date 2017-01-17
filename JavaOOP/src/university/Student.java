package university;

public class Student extends Human{
	
	private String department;
	
	public Student(int k){
		// this(); 생성자 내에서 다른 생성자를 호출해줄 수 있다. 
		
	}
	
	
	// 기본생성자는 사용하던, 사용하지 않던, 반드시 작성해주세요.	
	public Student() {
		// 앗.. 상위클래스가 존재한다.
		// 상위클래스의 instance를 먼저 만들어야겠네?
		// super(); 자신의 상위클래스의 생성자를 호출하는 명령
		// 만약 생성자 안에서 상위 클래스의 생성자를 호출해주는 구문이 실제
		// 존재하지 않으면 javac compiler가 자동적으로 구문을 추가해준다.
		
	}	
	
	// method Overriding
	public void print(){
		System.out.println("여기는 Student");
	}
	
	
	
	
	// private Field에 대한 Setter와 Getter	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
