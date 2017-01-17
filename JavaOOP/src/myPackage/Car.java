// package 구문
package myPackage;

public class Car {
	
	// class의 구성요소 1 : Field (변수)
	//int fuel;
	// static int fuel => static Field
	
	private int fuel; 	
	private int speed;	// Field
	
	// Getter, 외부에서 사용을 해야 하니까 무조건 public
	public int getFuel(){
		return this.fuel;
	}
	
	// Setter, 이것도 무조건 public
	public void setFuel(int fuel){
		this.fuel = fuel;
	}

	// class의 구성요소 2 : Method
	public void refuel(int k){
		if( k < 0 ){
			System.out.println("말도안되요!");
		}
		else
			this.fuel += k;		
	}
	// class의 구성요소 3 : Constructor(생성자)
	// 생성자의 이름은 class의 이름과 같아야함. return type이 존재하지 않음.
	// 인스턴스를 만드는게 목적!
	public Car(){
		
	}	
	
	
	
}


