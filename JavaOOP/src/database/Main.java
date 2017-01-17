package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		// (1) ~ (6) 이후에 순서
		// 입력을 받아보자!! 입력을 받기 위해서는 기본적으로 Stream이라는 객체를 사용한다.
		// 조금 쉬운 형태로 Scanner (class)를 사용해보자..
		
		// System.out => dos 창에 출력을 하라.
		// System.in => dos 창에서 입력을 받아라.
		Scanner s = new Scanner(System.in);
		System.out.print("검색어를 입력하세요: ");
		String keyword = s.nextLine();		// 문자열을 입력받기 위한 method. method는 API reference를 보고 찾아라!!
		
		
		
		// JDBC ( Java Database Connectivity )
		// 총 6단계를 거쳐서 java program이 Database를 이용
		// 조심해야 하는건.. Database program은 예외상황에 대한 처리가 같이 나와야 한다.
		
		// 예외처리 => Exception handling
		try {
			// 이 안에 있는 코드를 실행해요.
			// 만약 에러가 없으면 상관없지만, 혹시 Exception(오류)이 발생하면
			// catch문 안에 있는 내용을 수행하게 되요.
			
			// Database 연결
			// 1. 드라이버 로딩
			// 자바가 특정 데이터베이스를 이용하기 위해서는, 특수한 class의 instance가 필요해요.
			// java ----- JDBC Driver (class) ----> database
			// JDBC driver 파일을 사용하기 위해 경로를 설정해주어야 한다.
			
			Class.forName("com.mysql.jdbc.Driver");		// 드라이버 로딩하는 코드 (JDBC 찾아내서 로딩하는것.)
			System.out.println("드라이버 로딩 성공");
			
			// 2. Database에 접속
			// 접속을 위해 크게 3가지가 필요
			// ID / PW / 어느 DB에 접속할건지에 대한 주소. => 이것들을 String으로 만든다.
			String id = "corsae";
			String pw = "tpgus2dlekA!";
			String url = "jdbc:mysql://localhost:3306/library";		// 이건 형식에 따라야 한다. 
			
			Connection con = DriverManager.getConnection(url, id, pw);		// 이 줄을 통해 접속이 이루어진다.
			System.out.println("접속 성공!");
			
			
			// 3. 문장 생성 ( SQL 질의 작성 ) [SQL문]
			// String 형태로 sql문장을 작성!			
			// btitle과 bauthor를 알아와라! from book이라는 title(table)로부터, 그런데 조건이 있음(where)
			// where bisbn이 89-7914-063-0인 데이터를 뽑아와라
			
			// String sql = "select btitle, bauthor from book where bisbn='89-7914-063-0'";
			
			// 책 제목에 내가 입력한 키워드가 있는 책을 찾아야 한다!
			// "=" 기호는 완벽하게 똑같은것을 찾는것.
			// 우리가 하려는 것은 패턴매칭 (키워드가 "포함" 되어있는것) => "like" 사용 (제공되는것)
			// Java라는 문자가 포함되어 있는 문자열 => wildcard
			// SQL에서 사용할 수 있는 wildcard 중에 "%" => 0개 이상의 문자열을 의미!
			// %java => 문자열이긴 한데, 끝이 java로 끝나는 문자열
			// %java% => 앞과 뒤에 0개 이상의 문자열 포함 => java라는 글자를 포함하는 문자열!!!
			
			// 문자열 처리 힘들어짐 => "?" 제공 
			// ? => 아직 결정되진 않았는데, 나중에 넣을 것이다 라는 의미. (일단 여기에 뭐 하나 들어간다!)
			// 이것을 IN parameter라고 부른다. (readable하게 프로그램을 끌고갈 수 있다.)
			
			String sql = "select btitle, bauthor from book where btitle like ?";
			
						
			// 이 문자열(sql)을 Database에 전달해야 한다.
			// PreparedStatement라는 문장객체를 만들어서 이것을 이용해서 DB에 전달한다.
			// Import 하는것은 Java.sql 것을 사용한다. Mysql것을 사용하지 않는다.
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			
			// executeQuery()를 실행하기 전에 ?를 채워줘야 한다.
			// setString(1, x) => 여기서 1은 첫번째 물음표에 이 문자를 셋팅하라는 의미.
			pstmt.setString(1, "%" + keyword + "%");
			
			
			// 4. 실행
			// 조심해야할 것 : 어떤 종류의 sql을 사용하는지에 따라 실행하는 method가 달라진다
			// 데이터를 얻어오는 경우 ( select ~~ ) : pstmt.executeQuery()
			ResultSet rs = pstmt.executeQuery();		// 실행
			
			
			// 5. 결과처리 단계 (data 처리)
			// 실행했으니까 결과가 나온다. 
			// 지금의 경우는 select를 이용해서 결과data의 집합을 DB로부터 가져온 경우
			// 그럼 이것을 Java에서 어떻게 처리해서 보여주느냐? => resultset(결과 집합)
			
			// rs는 표의 윗줄(btitle, bauthor)을 가리키는 포인터!!
			// 지금은 윗쪽 라인을 가리키고 있으니, data를 얻으려면 rs를 한칸 내려야 한다.
			// 한칸 내리는 행위 => next(); 라는 method를 사용한다.
			// next : boolean return, 내릴 수 있으면 true, 없으면 false
			
			
			// 첫 번째 예제 (데이터 하나의 예시)
			/*
			if(rs.next()){
				// 내려갈 수 있으면 (rs.next()가 true라면..)
				// rs가 가리키는 곳에서 문자열을 가져와라, btitle에 해당하는 column에서  
				String title = rs.getString("btitle");
				String author = rs.getString("bauthor");
				System.out.println(title + ", " + author);
			}
			*/
			
			// 두 번째 예제 (여러 개의 데이터 예시)
			while(rs.next()){
				// 내려갈 수 있으면 (rs.next()가 true라면..)
				// rs가 가리키는 곳에서 문자열을 가져와라, btitle에 해당하는 column에서  
				String title = rs.getString("btitle");
				String author = rs.getString("bauthor");
				System.out.println(title + ", " + author);
			}
			
			
			// 6. 사용한 resource를 해제 (마무리 처리)
			// 리소스 해제를 잘 안하면 DB에서 문제가 생길 수 있다. => database에 리소스가 부족해진다.
			// 우리가 사용한 리소스 => connection, statement, resultset
			// 이 세가지를 해제해 주어야 한다.
			// 순서 : 나중에 만들어진것 부터 먼저 닫는다!!!!
			rs.close();
			pstmt.close();
			con.close();
						
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);		// 예외에 대한 내용을 출력			
		}
	}
}
