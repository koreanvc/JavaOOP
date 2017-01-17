package pattern_templatemethod;

import java.util.ArrayList;
import java.util.Random;

public class Woman extends Human{
	
	@Override
	public void search() {
		System.out.println("맘에드는 남성을 찾아요!!");
	}
	
	@Override
	public void doAction() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("활짝 웃는다.");
		list.add("얼굴이 이쁘다.");
		list.add("리액션을 크게 한다.");
		
		int num = (new Random()).nextInt(list.size());
		System.out.println(list.get(num));		
	}
	
	
}
