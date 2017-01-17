package exercise07_Beverage;

public class BeverageMain {
	public static void main(String[] args) {
		Coffee c1 = new Coffee("Americano");
		Coffee c2 = new Coffee("Cafe latte");
		Coffee c3 = new Coffee("Cappuccino");
		
		Tea t2 = new Tea("Jasmine Tea");
		Tea t3 = new Tea("Black Tea");
		
		System.out.println("***** Coffee Shop 영업 개시 *****");
		
		c1.print();
		c2.print();
		int a = Coffee.amount;
		int b = Tea.amount;
		System.out.println(a);
		System.out.println(b);
		
	}
}
