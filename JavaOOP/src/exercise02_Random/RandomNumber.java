package exercise02_Random;

import java.util.HashSet;
import java.util.Random;

public class RandomNumber {	
	
	public int[] renGen(){
		int arr[] = new int[10];
		Random r1 = new Random();		
			
		int a;
		int cnt = 0;
		
		arr[0] = r1.nextInt(30) + 1;
		for(int i=1; i<10; i++){	
			a = r1.nextInt(30) + 1;
			for(int j=0; j<i; j++){				
				if(arr[j] == a){
					cnt++;
				}				
			}
			if(cnt == 0){
				arr[i] = a;	
			}
			else{
				cnt = 0;
				i--;
				continue;
			}					
		}		
		return arr;
	}
	
	public static void main(String[] args) {
		/*
		// 내 코드
		int arr[] = new int[10];
		
		RandomNumber r1 = new RandomNumber();
		arr = r1.renGen();		
		
		for(int i=0; i<10; i++){
			System.out.print(arr[i] + ", ");
		}
		*/
		
		// Set을 이용해서 구현 => HashSet class 이용
		Random r = new Random();
		
		// HashSet set = new HashSet(); // 일반적으로 이렇게 쓸 수도 있다.
		
		// generic을 사용해서 선언
		HashSet<Integer> set = new HashSet<Integer>();
		
		// set의 사이즈를 비교한다.
		// 바구니 안에 몇개 들어가있는지 확인하는 메소드 size()
		while(set.size() != 10){			// set안에 10개가 들어갈동안 while 돈다.
			int k = r.nextInt(30) + 1;
			// set.add(k) 도 가능!! => auto-boxing (refer class를 이용해서 자동으로 처리해준다.)
			// 원래는 아래처럼 해야되는데, primitive type을 넣어도 된다. 			
			Integer i = new Integer(k);		// Integer 객체를 만들어서 k를 넣어준다.
			set.add(i);						// add 메소드를 이용해서 주머니에 추가한다. (중복은 자동으로 방지)
		}
		
		System.out.println(set);		// toString()이 override 되어있기 때문에 바로 출력 가능!		
		
	}
	
}
