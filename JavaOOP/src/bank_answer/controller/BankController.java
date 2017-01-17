package bank_answer.controller;

import java.util.HashMap;
import java.util.Scanner;
import bank_answer.dto.BankDTO;
import bank_answer.service.BankService;

public class BankController {
	
	// 굳이 service객체를 매번 메모리에 만들어야하나? => 동기화처리, 비동기화처리의 문제(혼자사용하면 상관없음)
	// Bank controller가 기본적으로 service 객체를 가지고 있어도 된다. (이 예제에서는)
	// 이렇게 쓰면, 여러 사람이 이 Bank 시스템을 한번에 쓸 때에는 서비스 객체가 공유될 위험이 있다.
	// private BankService service = new BankService();
	
	public BankController(){
		
		// 사용자에게 메뉴 등 입력받아야 하므로.. Scanner 필요
		Scanner s = new Scanner(System.in);
		
		String menu = null;
		do {
			System.out.println("=== 은행시스템입니다. ===");
			System.out.println("(1) 입금업무");
			System.out.println("(2) 출금업무");
			System.out.println("(3) 이체업무");
			System.out.println("(4) 종료");
			System.out.print("메뉴를 입력하세요: ");
			menu = s.nextLine();
			
			if( menu.equals("1") ){
				// 입금
				// 이름과 금액을 따로 보내는게 아니라, 이걸 묶어서 DTO로 만든다. (DTO 사용의 예시)
				// controller와 service가 데이터를 주고받을 때 DTO(데이터의 묶음, String과 int)로 주고 받는게 좋다.
				BankDTO dto = new BankDTO();
				System.out.print("입금할 사람의 이름을 입력하세요: ");
				dto.setName(s.nextLine());		// Scanner로부터 받아서 dto에 바로 넣는다.
				System.out.print("입금할 금액을 입력하세요: ");
				dto.setBalance(s.nextInt());
				s.nextLine();			// input buffer 비워주기.
				// Stream자체를 이용하면 이런 문제가 없는데, Scanner를 이용해서 엔터키 처리를 해주어야 한다.
				// nextInt는 input buffer에 엔터키가 남아있음.				
				
				BankService service = new BankService();
				// 여기서 인자를 DTO로 준다. (나는 String int 둘다 넘겼음.. 여기서 실수)
				// 여기서 결과도 DTO로 받아온다.
				dto = service.deposit(dto);	
				
				System.out.println(dto.getName() + "님의 잔액은 " + dto.getBalance() + "입니다.\n");
				// deposit이라는 작업이 하나의 일의 묶음이다. => 이게 Transaction이다.
				// 따라서 service에서 나오는 하나의 method 자체가 transaction이 되는 경우가 많다.				
			}
			if( menu.equals("2") ){
				// 출금
				BankDTO dto = new BankDTO();
				System.out.print("출금할 사람의 이름을 입력하세요: ");
				dto.setName(s.nextLine());		// Scanner로부터 받아서 dto에 바로 넣는다.
				System.out.print("출금할 금액을 입력하세요: ");
				dto.setBalance(s.nextInt());
				s.nextLine();
				
				BankService service = new BankService();
				dto = service.withdraw(dto);
				System.out.println(dto.getName() + "님의 잔액은 " + dto.getBalance() + "입니다.\n");
			}
			if( menu.equals("3") ){
				// 이체
				BankDTO depositDto = new BankDTO();
				BankDTO withdrawDto = new BankDTO();
				
				System.out.print("입금할 사람의 이름을 입력하세요: ");
				depositDto.setName(s.nextLine());	
				System.out.print("출금할 사람의 이름을 입력하세요: ");
				withdrawDto.setName(s.nextLine());					
				
				System.out.print("이체할 금액을 입력하세요: ");
				int money = s.nextInt();
				depositDto.setBalance(money);
				withdrawDto.setBalance(money);
				s.nextLine();
				
				BankService service = new BankService();
				HashMap<String, BankDTO> map = service.transfer(depositDto, withdrawDto);
				
				depositDto = map.get("deposit");
				withdrawDto = map.get("withdraw");
				
				System.out.println("입금자: " + depositDto.getName() + "님의 잔액은 " + depositDto.getBalance() + "입니다.");
				System.out.println("출금자: " + withdrawDto.getName() + "님의 잔액은 " + withdrawDto.getBalance() + "입니다.\n");
								
			}
			
			
		} while( !menu.equals("4") );
	}
}
