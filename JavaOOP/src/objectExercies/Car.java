package objectExercies;

public class Car extends Object{
	
	// field
	private int fuel;
	private int speed;
	private String owner;
	
	// constructor
	public Car() {
		
	}

	// setter & getter for private field
	public int getFuel() {
		return fuel;
	}
	public void setFuel(int fuel) {
		this.fuel = fuel;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}	
	public String getOwner(){
		return owner;
	}
	public void setOwner(String owner){
		this.owner = owner;
	}
	
	// toString을 overriding해서 내가 원하는 방식으로 쓰겠다.
	// overriding하려면 원래 method의 원형을 알아야 한다.
	// JAVA에서 도와줌 : Source => Override / Implement Methods
	
	// Annotation이라고 부름. (없어도 됨) 얘가 있으면 컴파일러한테 overriding된 메소드임을 알려줌.
	// 프로그램을 안전하게 해줄수 있게, 오타나면 overriding이 아니니까 오류남.
	@Override	
	public String toString() {
		// TODO Auto-generated method stub
		return "이것은 홍길동의 자동차 입니다!!";
	}
	
	
	// 인자가 Object type(상속 최상위)으로 들어온다? => 모든 객체가 인자로 들어갈 수 있다.
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub			
		boolean result = false;
		
		// 인자로 들어온게 Car라는 class의 instance입니까? 라고 물어보는것
		if( obj instanceof Car ){
			// ★★★★★★ 형변환을 한다.(type casting)★★★★★★
			Car temp = (Car)obj;	
			
			// if(this.owner == temp.owner) String은 항상 equals로 비교!! => String class도 equals 상속받음
			if(this.owner.equals(temp.owner)){
				result = true;
			} else{
				result = false;
			}
		} else{
			result = false;
		}
		
		return result;
		
	}

	
	
}
