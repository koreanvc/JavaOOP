package bank_answer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bank_answer.dto.BankDTO;

public class BankDAO {
	
	private Connection con;
	
	public BankDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public BankDAO(Connection con) {
		this.con = con;
	}
	
	public Connection getCon(){
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	
	// 1. select : 입력한 이름에 해당하는 사람이 있는지 없는지 판단하는 method
	public BankDTO select(BankDTO dto) {
		
		BankDTO result = null;		
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		
		try {			
			String sql = "select name,balance from bank where name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			rs = pstmt.executeQuery();
			
			// next가 된다는 얘기는 "있다" 라는 이야기니까..
			if( rs.next() ){
				result = new BankDTO();
				result.setName(rs.getString("name"));		// result 객체에서 가져온것으로 이름 설정
				result.setBalance(rs.getInt("balance"));	// result 객체에서 가져온것으로 잔액 설정
			}			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// finally는 exception이 뜨던 뜨지 않던 무조건 호출한다. 따라서 메모리상 닫아줘야 하는 부분은 여기서 실행한다.
			// 문제가 발생하면 rs에서 exception으로 가므로 이게 실행이 안된다. => DB connection을 잡아먹는다.
			// 그런데 블록이 틀려졌다. 따라서 선언이 try 블록 밖으로 나가야 한다. 
			// unhandled exception => 이걸 할때에는 try~catch를 강제적으로 실행해야 한다.
			// try ~ catch가 또 있어야 한다.
			try {
				// 이런식으로 리소스를 해제해주어야 한다.
				rs.close();
				pstmt.close();
				// con.close(); 서비스에서 커넥션을 만들어주었으니 서비스에서 끊어주어야 한다.
				
			} catch (Exception e2) {
				System.out.println(e2);
			}			
		}
		return result;
	}

	// 2. updateDeposit : 
	public BankDTO updateDeposit(BankDTO dto) {
		
		BankDTO result = null;
		PreparedStatement pstmt = null;
		
		try {			
			// 현재 입력받은 값을, 기존잔액에 더해서 update한다.
			String sql = "update bank set balance = balance+? where name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBalance());
			pstmt.setString(2, dto.getName());
			
			int count = pstmt.executeUpdate();		// update 발생, 한명이 수정되면 count ==1 (제대로 된것)	
			
			if( count == 1 ){				
				result = select(dto); 	// 이건 내가 생각하지 못했던 부분 ☆★☆★☆★☆
			} 
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}		
		return result;
	}

	
	// 3. updateWithdraw
	public BankDTO updateWithdraw(BankDTO dto) {
		BankDTO result = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String id = "corsae";
			String pw = "tpgus2dlekA!";
			String url = "jdbc:mysql://localhost:3306/library";
			con = DriverManager.getConnection(url, id, pw);
			
			// 이 method는 db에 영향을 미치는것이기 때문에 connection에 대해 transaction을 잡아주어야 한다.
			con.setAutoCommit(false);
			
			String sql = "update bank set balance = balance-? where name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBalance());
			pstmt.setString(2, dto.getName());
			
			int count = pstmt.executeUpdate();		// update 발생
			
			if( count == 1 ){
				result = select(dto);
				con.commit();
			} else{
				con.rollback();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		
		return result;
	}

}
