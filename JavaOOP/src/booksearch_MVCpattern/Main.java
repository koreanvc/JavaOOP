package booksearch_MVCpattern;

import booksearch_MVCpattern.controller.BookController;

public class Main {
	
	public static void main(String[] args) {
		// 사용자로부터 입력을 받고, 출력을 담당 ==> Controller
		// main이 하는 일은 Controller instance를 만들어주고 끝난다.
		
		// 변수 이름을 쓸 필요가 없다. instance를 만들면서 main은 끝난다.
		new BookController();
	}
}
