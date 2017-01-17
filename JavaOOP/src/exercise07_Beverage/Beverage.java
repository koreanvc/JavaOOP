package exercise07_Beverage;

public abstract class Beverage {
	
	private String name;
	private int price;
	
	public Beverage() {
		// TODO Auto-generated constructor stub
	}
	
	public Beverage(String name){
		this.name = name;
	}
	
	public abstract void calcPrice();
	
	public void print(){
		System.out.println("음료는 " + name + "이며, 가격은 " + price + " 입니다.");
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
	
}
