package pattern_templatemethod;

import java.util.ArrayList;
import java.util.Random;

public class Man extends Human{
	// 이성친구를 찾는 과정을 프로그램으로 모델링
	
	
	@Override
	public void search() {
		System.out.println("맘에드는 여성을 찾아요!!");
	}
	
	@Override
	public void doAction() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("선물을 산다.");
		list.add("꽃을 산다.");
		list.add("부모님의 선물을 산다.");
		list.add("이야기를 잘 들어준다.");
		
		int num = (new Random()).nextInt(list.size());
		System.out.println(list.get(num));		
	}	
	
	
	
}
