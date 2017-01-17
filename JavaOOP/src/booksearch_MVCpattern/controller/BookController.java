package booksearch_MVCpattern.controller;

import java.util.ArrayList;
import java.util.Scanner;

import booksearch_MVCpattern.dto.BookDTO;
import booksearch_MVCpattern.service.BookService;

public class BookController {
	
	public BookController() {
		// 1. 프로그램은 여기서부터 시작한다. (왜냐면, main에서 instance 호출 => 생성자 호출)
		// 입출력을 담당하는 class
		
		
		// 책을 찾는 키워드 입력받기 : Scanner
		Scanner s = new Scanner(System.in);
		String menu = "";
		String keyword = "";
		
		
		while(true){
			System.out.println("=== 도서관리 프로그램 ===");
			System.out.println("1. 도서검색 (키워드)");
			System.out.println("2. 도서삭제 (isbn)");
			System.out.println("3. 프로그램 종료");
			
			System.out.print("메뉴를 입력하세요: ");
			menu = s.nextLine();			
			if( menu.equals("1") ){
				// 도서검색				
				System.out.print("키워드를 입력하세요: ");
				keyword = s.nextLine();
				BookService service = new BookService();
				ArrayList<BookDTO> list = service.findBookByKeyword(keyword);
				for( BookDTO dto : list ){
					System.out.println(dto.getBtitle() + ", " + dto.getBauthor());
				}
				System.out.println("");
				continue;
			}
			else if( menu.equals("2") ){
				// 도서 삭제
				System.out.print("도서 번호를 입력하세요: ");
				String number = s.nextLine();
				BookService service = new BookService();
				
				// database에 있는 내용을 삭제하고 "잘 됐다", "안됐다"만 알려주면된다. => boolean으로 받는다.
				boolean result = service.deleteByNumber(number);
				
				if(result){
					System.out.println("정상적으로 삭제되었습니다.");
				} else{
					System.out.println("오류가 발생되었습니다.");
				}
				System.out.println("");
				continue;
			}
			else if( menu.equals("3") ){
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			else{
				// 잘못선택
				System.out.println("잘못 선택하셨습니다. 메뉴로 돌아갑니다. \n");
				continue;
			}
			
		}
		
		
		/*
		String keyword = s.nextLine();
		
		// 2. 로직을 처리하기 위해 객체(instance)를 생성해서 일을 시킨다.
		// 이 instance가 가지고 있는 method를 호출하겠다는 소리.
		BookService service = new BookService();
				
		// 3. 여기서 data 전달 객체인 DTO가 필요해진다.
		// 단일값으로는 못받을 것 같다. (복잡한 형태의 여러 개의 data를 받아야 하므로..)
		// return 받는것을 BookDTO의 집합 ==> ArrayList를 쓴다. 
		// ArrayList import, BookDTO import
		ArrayList<BookDTO> list = service.findBookByKeyword(keyword);		
		
		
		// 출력 
		// 확장 for문이 더 편함 ==> ArrayList "list" 안에 들어가있는 "dto"를 하나씩 끄집어 내는것!!
		// ArrayList 는 array처럼 index로 접근한다.
		// 여기서는 확장 for문으로 순서대로 뽑아!!!
		for( BookDTO dto : list ){
			System.out.println(dto.getBtitle() + ", " + dto.getBauthor());
		}
		*/
		
	}
}
