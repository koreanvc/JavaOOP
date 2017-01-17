package bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bank.dto.BankDTO;

public class BankDAO {

	private Connection con;
	
	public boolean select(String name) {
		
		boolean result = false;		
		try {
			
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
			String sql = "select name from bank where name = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);	
			
			// 4. 실행 (위의 SQL문을 실행시킨다.)
			ResultSet rs = pstmt.executeQuery();		
			
			// ☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
			// 다음 것을 가져올 수 있다는 말은 이미 하나 가져왔다는 것.
			if(rs.next()) {
				result = true;
			} else{
				result = false;
			}
						
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		
		return result;
	}

	public boolean depositData(String nameInput, int balanceInput) {
		// TODO Auto-generated method stub
		boolean result = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			System.out.println("드라이버 로딩 성공");					
			String id = "corsae";
			String pw = "tpgus2dlekA!";
			String url = "jdbc:mysql://localhost:3306/library";					
			Connection con = DriverManager.getConnection(url, id, pw);	
			System.out.println("접속 성공!");			
			
			// Transaction 실행
			con.setAutoCommit(false);
						
			String sql = "update bank set balance = balance+? where name = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, balanceInput);
			pstmt.setString(2, nameInput);	
				
			// 입금을 실행해야 한다. 			
			int tmp = pstmt.executeUpdate();			

			if(tmp == 1){
				result = true;
				con.commit();
			}			
			else{
				con.rollback();
			}
			
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return result;
	}

	public boolean withdrawData(String nameInput, int withdrawInput) {
		
		boolean result = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			System.out.println("드라이버 로딩 성공");					
			String id = "corsae";
			String pw = "tpgus2dlekA!";
			String url = "jdbc:mysql://localhost:3306/library";					
			Connection con = DriverManager.getConnection(url, id, pw);	
			System.out.println("접속 성공!");
			
			// Transaction 실행
			con.setAutoCommit(false);
			
			String sql = "update bank set balance = balance-? where name = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, withdrawInput);
			pstmt.setString(2, nameInput);	
				
			// 입금을 실행해야 한다. 			
			int tmp = pstmt.executeUpdate();			
				
			if(tmp == 1){
				result = true;
				con.commit();
			}
			else{
				con.rollback();
			}
			
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return result;
		
	}

	public boolean sendingData(String balSender, String balReceiver, int sendingInput) {
		
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			System.out.println("드라이버 로딩 성공");					
			String id = "corsae";
			String pw = "tpgus2dlekA!";
			String url = "jdbc:mysql://localhost:3306/library";					
			Connection con = DriverManager.getConnection(url, id, pw);	
			System.out.println("접속 성공!");			
						
			int tmp = 0;
			
			// Transaction 실행
			con.setAutoCommit(false);
			
			// sender에서 빠져나가는것 + receiver에서 받는것.
			String sql1 = "update bank set balance = balance-? where name = ?";
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			pstmt1.setInt(1, sendingInput);
			pstmt1.setString(2, balSender);
			tmp += pstmt1.executeUpdate();
			
			String sql2 = "update bank set balance = balance+? where name = ?";
			PreparedStatement pstmt2 = con.prepareStatement(sql2);			
			pstmt2.setInt(1, sendingInput);
			pstmt2.setString(2, balReceiver);
			tmp += pstmt2.executeUpdate();	
			
			if(tmp == 2){
				result = true;
				con.commit();
			}
			else{
				con.rollback();
			}
			
			pstmt1.close();
			pstmt2.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return result;
	}
	
	
	
	
	
}
