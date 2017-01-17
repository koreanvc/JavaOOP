package booksearch_MVCpattern.service;

import java.util.ArrayList;

import booksearch_MVCpattern.dao.BookDAO;
import booksearch_MVCpattern.dto.BookDTO;

public class BookService {
	// 로직처리가 나와야 하는 부분 (Service)
	
	// 4. keyword를 받아서 데이터를 찾아서 전해주는 일이 이 method가 하는일이다.
	// 하지만 database는 DB 전담 처리객체가 따로 있다. ==> 그 class에게 일을 따로 시켜야 한다.
	public ArrayList<BookDTO> findBookByKeyword(String keyword) {		
		
		// 일반 로직은 Service에서 구현을 하고, Database 처리는 service에서 직접 구현하지 않는다!!
		// Database 처리는 DAO에서 처리한다.
		BookDAO dao = new BookDAO();
		
		// 여기는 이름을 find를 안쓰고 select를 했다. (중요)
		// dao에서 ArrayList<BookDTO>를 만들어서 리턴할 것이다.
		return dao.select(keyword);
		
	}
	
	
	// number를 받아서 책을 삭제해주는 method
	public boolean deleteByNumber(String number) {
		
		BookDAO dao = new BookDAO();
		return dao.delete(number);
	}

}
