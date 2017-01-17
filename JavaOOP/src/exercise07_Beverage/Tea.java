package exercise07_Beverage;

public class Tea extends Beverage{
	public static int amount;
	
	public Tea() {
		// TODO Auto-generated constructor stub
	}
	
	public Tea(String name){
		super(name);
		amount++;
	}
	
	public void calcPrice(){
		String name = getName();
		if(name == "Lemon Tea"){
			setPrice(1500);
		}
		else if(name == "Jasmine Tea"){
			setPrice(2000);
		}
		else if(name == "Black Tea"){
			setPrice(2500);
		}
		else{
			System.out.println("메뉴에 없음");
		}
	}

}
