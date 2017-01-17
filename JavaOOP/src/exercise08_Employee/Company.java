package exercise08_Employee;

import java.util.HashMap;

public class Company {
	
	public static void main(String[] args) {
		
		HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
		
		// 상위타입으로 Employee로 위에 선언을 해놓았으므로(HashMap<Integer, Employee>) 
		// 바로 new Secretary로 선언 가능
		map.put(1, new Secretary("Hilery", 1, "secretary", 800));
		map.put(2,  new Sales("Clinten", 2, "sales", 1200));
		
		for(int i=0; i<map.size(); i++){
			System.out.println(map.get(i+1).toString());
		}
		
		//map.get(1).tax();
		/*
		for(int i=0; i<map.size(); i++){
			map.get(i+1).
		}
		*/
		//map.get
		Sales s1 = new Sales("koh", 12, "hhh", 1200);
		s1.incentive(100);
		System.out.println(s1.toString());
		// Bonus를 이용해야 할듯..
		
	}
}
