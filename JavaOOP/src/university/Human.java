package university;

public class Human extends Object{
	
	private String name;
	private String age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public void print(){
		System.out.println("여기는 Human");
	}
	
	
	public Human() {
		// TODO Auto-generated constructor stub
		super(); // 최 상위클래스인 Object에 대한 instance를 먼저 만들어야 한다.(생략가능)
	}
	
	// 해당 class가 가지고 있는 method ("Business method")
	public void printInfo() {
		System.out.println(name + ", " + age);
	}
	
}
