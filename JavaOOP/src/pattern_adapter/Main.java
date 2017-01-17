package pattern_adapter;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// ArrayList 안에 각각의 마린과 탱크를 생성해서 집어넣으면 될 것이다.
		ArrayList<TerranInterface> unit = new ArrayList<TerranInterface>();
		
		// 마린 3개, 탱크 1기 생산
		unit.add(new Marine());
		unit.add(new Marine());
		unit.add(new Marine());
		unit.add(new Tank());
		unit.add(new MedicAdapter(new Medic()));
		
		for(TerranInterface tmp : unit){
			tmp.move();
		}
		
		for(TerranInterface tmp : unit){
			tmp.attack();
		}		
		System.out.println("수정사항");
	}

}
