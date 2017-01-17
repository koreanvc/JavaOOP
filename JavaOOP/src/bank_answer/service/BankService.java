package bank_answer.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import bank_answer.dao.BankDAO;
import bank_answer.dto.BankDTO;

public class BankService {

	public BankService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	
	public BankDTO deposit(BankDTO dto) {
		
		// 로직 처리를 해요.
		// DB 처리를 해요. (세부적인 처리는 DAO에서)
		
		// Transaction 부분
		Connection con = null;
		try {			
			String id = "corsae";
			String pw = "tpgus2dlekA!";
			String url = "jdbc:mysql://localhost:3306/library";
			con = DriverManager.getConnection(url, id, pw);			
			
			con.setAutoCommit(false);	// 여기서 transaction을 하고 DAO에 넘겨준다.		
		
		// DAO는 로직처리가 아니라 데이터 처리만 하는 부분이다. (여기에 의미론적인 부분이 나오면 안된다.)
		// DAO에서 갑자기 deposit이라는 transaction에 대한 의미가 나오면 안된다.
		// DAO에 select 메소드 하나, update 메소드하나, 이렇게 조각조각 해놓고, Service에서 그걸 조합해서 쓰는게 좋다.
		// 이렇게 안하면 한번 쓴 메소드를 재사용하기가 어렵다. (재활용성, 유지보수성)
			
			// 1. Constructor injection
			BankDAO dao = new BankDAO(con);		// transaction을 위해 overload된 생성자를 통해 정보를 보냄.
			
			// 2. Setter injection (DAO에서 
			// dao.setConnection(con);
			
			
			// select라는 method는 DTO안의 사용자 이름을 뽑아내서 그 예금주가 맞는지 확인하는 메소드로 규정!
			// select가 그 사람의 잔액까지 가져오는걸로 규정해본다.
			// 만약 그런 사람이 없으면 null이 리턴되도록 규정.
			BankDTO result = dao.select(dto);
			
			// 만약 그런 사람이 null이 아니면 (그 객체가 존재하면) => update를 진행한다.		
			if( result != null ){
				dto = dao.updateDeposit(dto);
				if( dto != null ){
					con.commit();
				} else {
					con.rollback();
				}
			}			
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2);
			}
		}
		
		return dto;
	}

	public BankDTO withdraw(BankDTO dto) {
		
		Connection con = null;
		try {
			String id = "corsae";
			String pw = "tpgus2dlekA!";
			String url = "jdbc:mysql://localhost:3306/library";
			con = DriverManager.getConnection(url, id, pw);		
			
			con.setAutoCommit(false);
			
			BankDAO dao = new BankDAO();			
			BankDTO result = dao.select(dto); 	// 현재 해당하는 사람의 이름과 잔액을 result에 넣어왔다.
			
			// 잔액이 부족한 조건도 여기에 넣어주면 된다.
			// result의 잔액이 뽑으려고 하는 금액보다 많으면, (현재 dto에는 컨트롤러에서 입력한 정보가 들어있음.)  
			if( (result != null) && (result.getBalance() >= dto.getBalance()) ){
				dto = dao.updateWithdraw(dto);
				if(dto != null){
					con.commit();
				} else {
					con.rollback();
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		
		return dto;
	}

	// Transaction (DAO에서 만들지 않는다!!)
	// DAO는 각각의 단일 data 처리 기능들이다.
	// 그 기능들을 모아서 transaction을 만드는 것은 Service이다.
	// 따라서 Service 단에서 transacetion을 해주는 것이 문제를 해결하는 방법이다. 
	// Service에서 connection 객체를 만들어서 DAO에게 넘겨주어야 한다.
	
	
	public HashMap<String, BankDTO> transfer(BankDTO depositDto, BankDTO withdrawDto) {
		
		HashMap<String, BankDTO> result = new HashMap<String, BankDTO>();
		// 이체는 두 가지 작업을 한다. updateDeposit, updateWithdraw에 대해서 Transaction은 완성했다.
		
		
		// 문제 : 이 두 문장의 중간에서 오류가 나면? 이체 처리가 제대로 되지 않는다. (위에서 rollback()이 되었으므로)	
		// ==> Transaction 처리를 DAO에서 하지 않게 만든다!!
		result.put("deposit", deposit(depositDto));		
		result.put("withdraw", withdraw(withdrawDto));
		
		return result;
	}

}
