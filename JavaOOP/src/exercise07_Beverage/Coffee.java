package exercise07_Beverage;


public class Coffee extends Beverage {
	public static int amount;
	
	public Coffee() {
		// TODO Auto-generated constructor stub
	}
	
	public Coffee(String name){
		super(name);
		amount++;
	}	
	
	public void calcPrice(){
		String name = getName();
		if(name == "Americano"){
			setPrice(1500);
		}
		else if(name == "Cafe latte"){
			setPrice(2500);
		}
		else if(name == "Cappuccino"){
			setPrice(3000);
		}		
		else{
			System.out.println("메뉴에 없음");
		}
	}
	
	
}
