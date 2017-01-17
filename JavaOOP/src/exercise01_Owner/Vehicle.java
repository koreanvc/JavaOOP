package exercise01_Owner;

public class Vehicle {
	private Owner owner;
	private int price;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}
	
	public Vehicle(Owner owner, int price) {
		this.owner = owner;
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result;
		
		if( obj instanceof Vehicle ){
			Vehicle temp = (Vehicle)obj;
			if( this.owner.equals(temp.owner) ){
				result = true;
			} else{
				result = false;
			}			
		} else{
			result = false;
		}		
		return result;
	}

	@Override
	public String toString() {
		
		return this.owner.toString() + "\n차량정보 : 가격은 " + this.price + "입니다.";
		/*
		String temp;
		String name = this.owner.getName();
		String cell = this.owner.getCellPhone();
				
		temp = "이름은 " + name + "이고, 핸드폰 번호는 " + cell + "입니다. \n"
				+ "차량정보 : 가격은 " + this.price + "입니다.";
		return temp; 
		*/		
		
	}
	
	
	
	
}
