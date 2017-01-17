package booksearch_MVCpattern.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import booksearch_MVCpattern.dto.BookDTO;

public class BookDAO {
	
	
	// 5. 여기서 database 처리 코드가 나와줘야 한다.
	// 처리된 결과가 ArrayList<BookDTO> 형태로 나와줘야 한다.
	public ArrayList<BookDTO> select(String keyword) {
		
		// 결과를 담을 ArrayList를 만든다.
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		try {			
			// Database 연결
			// 1. 드라이버 로딩			
			Class.forName("com.mysql.jdbc.Driver");		
			System.out.println("드라이버 로딩 성공");
			
			// 2. Database에 접속			
			String id = "corsae";
			String pw = "tpgus2dlekA!";
			String url = "jdbc:mysql://localhost:3306/library";					
			Connection con = DriverManager.getConnection(url, id, pw);	
			System.out.println("접속 성공!");			
			
			// 3. 문장 생성 ( SQL 질의 작성 ) [SQL문]			
			String sql = "select btitle, bauthor from book where btitle like ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");			
			
			// 4. 실행
			ResultSet rs = pstmt.executeQuery();		// 실행
			
			
			// 5. 결과처리 단계 (data 처리)
			while(rs.next()){
				// 내려갈 수 있으면 (rs.next()가 true라면..)
				// rs가 가리키는 곳에서 문자열을 가져와라, btitle에 해당하는 column에서  
				String title = rs.getString("btitle");
				String author = rs.getString("bauthor");
				
				BookDTO dto = new BookDTO();	// dto 객체를 반복할때마다 만들고
				dto.setBtitle(title);			// dto 객체에 title 넣기
				dto.setBauthor(author);			// dto 객체에 author 넣기
				list.add(dto);					// 위에서 만든 ArrayList에 dto넣기 				
			}			
			
			// 6. 사용한 resource를 해제 (마무리 처리)
			rs.close();
			pstmt.close();
			con.close();
						
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);		// 예외에 대한 내용을 출력			
		}
		
		return list;
	}
	
	
	// 책에 관한 database 처리하는것들.. 
	// 이 method는 number로 그에 해당하는 책을 찾아서 지워준다.
	public boolean delete(String number) {
		
		boolean result = false;
		
		try {			
			// 위와 똑같은 부분		
			Class.forName("com.mysql.jdbc.Driver");		
			System.out.println("드라이버 로딩 성공");					
			String id = "corsae";
			String pw = "tpgus2dlekA!";
			String url = "jdbc:mysql://localhost:3306/library";					
			Connection con = DriverManager.getConnection(url, id, pw);	
			System.out.println("접속 성공!");			
						
			// 여기가 달라지는 부분이다. (SQL문)
			// book이라는 table에서 지울 것이다. (delete from book)
			String sql = "delete from book where bisbn like ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, number);			
			
			
			// 이 method는 결과 레코드 집합을 가져오는 select가 아니다. (select는 executeQuery() 를 쓴다.)
			// Database에 영향을 미치는 작업!!(delete, insert, update) => method가 달라진다.
			// 이러한 작업들은 executeUpdate() 를 쓴다.
			
			// 4. 실행
			// ResultSet은 테이블을 나타내는 결과
			// executeUpdate는 return값이 int로 나온다.
			// 결과값이 의미하는 바는 영향을 받는 레코드의 수(int)
			// 우리가 짠 로직상 정상적으로 지우면(1개 지우기) tmp 값이 1이 되어야 한다.
			
			int tmp = pstmt.executeUpdate();		// 실행			
			
			if(tmp == 1){
				result = true;
				// 1이 아니면 result는 그대로 false를 유지하고 있을것이다.
			}
			
			
			// 6. 사용한 resource를 해제 (마무리 처리)
			// rs.close();  => ResultSet이 존재하지 않으므로 필요없음.
			pstmt.close();
			con.close();
						
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);		// 예외에 대한 내용을 출력			
		}
		
		return result;		
	}
	
}
