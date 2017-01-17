package exercise03_HashMap;

import java.util.HashMap;
// java.util이라는 package안에 Random이라는 class를 제공해준다.
// import를 하면 package명을 안쓰고 쓸 수 있게 된다.
import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		
		// 1부터 100 사이의 random number 10개 발생 ( Random class )
		Random r = new Random();
		
		// 이렇게 발생된 난수를 HashMap에 저장 ( HashMap class)
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 1; i < 11; i++){
			map.put(i, r.nextInt(100) + 1);
		}
		
		// 저장된 데이터의 합계와 평균을 출력하세요.
		int sum = 0;
		for(int i=1; i<11; i++){
			System.out.print(map.get(i)+ ", ");
			sum += map.get(i);		// 정보를 가져올 때에는 key 값을 준다.
		}
		
		
		
		System.out.println("총합 : " + sum);
		System.out.println("평균 : " + sum/10);
	}
}
