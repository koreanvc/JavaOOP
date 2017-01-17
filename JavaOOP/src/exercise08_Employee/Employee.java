package exercise08_Employee;

public abstract class Employee {
	
	private String name;
	private int number;
	private String department;
	private int salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int number, String department, int salary) {
		super();
		this.name = name;
		this.number = number;
		this.department = department;
		this.salary = salary;
	}
	
	
	// abstract method - 세금을 리턴한다.
	public abstract double tax();
		
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name: " + name + "\tnumber: " + number + "\tdepartment: " + department + "\tsalary: " + salary;
	}
	

	// Setter & Getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
