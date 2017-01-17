package transactionExercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {

	public static void main(String[] args) {
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			String id = "corsae";
			String pw = "tpgus2dlekA!";
			String url = "jdbc:mysql://localhost:3306/library";
			Connection con = DriverManager.getConnection(url, id, pw);
			
			// Transaction을 설정			
			con.setAutoCommit(false);	// 이 구문이 나오는 순간 이 Connection을 이용한 모든 작업은 Transaction이다.		
			String sql = "delete from book";
			PreparedStatement pstmt = con.prepareStatement(sql);
			int result = pstmt.executeUpdate();		// 싹 다 지우고 몇개 지웠는지 알려줄 것이다. (int)
			
			System.out.println("총 삭제된 레코드 수는 : " + result);
			// transaction을 닫아주지 않으면, 제대로 처리되지않은것으로 간주. 다시 되돌림. (Atomicity)
			if(result == 1){		// result == 745면 진짜 다지워짐. 1로 바꿔놓음.
				// 정상적인 처리
				// 이 connection을 가지고 database에 정상적인 것을 처리해. 끝나고 다른 transaction 시작!
				con.commit();
				
			} else{
				// 비정상적인 처리
				// 명시적으로 무효화 처리 (con이 시작한 부분에서 모든 작업을 모두 복구시킨다.)
				con.rollback();
				
			}
			
			
			pstmt.close();
			con.close();		
			
		} catch(Exception e){
			System.out.println(e);
		}
		
	}
}
