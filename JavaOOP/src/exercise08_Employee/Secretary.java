package exercise08_Employee;

public class Secretary extends Employee implements Bonus{

	public Secretary() {
		// TODO Auto-generated constructor stub
	}
	
	// 자기 상위의 constructor를 호출해야 한다. (superclass의 private field를 사용하기 위해)
	public Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);
		// TODO Auto-generated constructor stub
	}
	
	
	// 상속받은 abstract method 구현

	@Override
	public void incentive(int pay) {
		setSalary(getSalary() + (int)(pay * 0.8));
	}

	
	@Override
	public double tax() {
		return getSalary() * 0.1;
	}

}
