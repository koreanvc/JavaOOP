package bank.controller;

import java.util.Scanner;
import bank.service.BankService;

public class BankController {
	
	// 프로그램은 여기서부터 시작한다.
	// 입출력을 담당하는 class
	public BankController(){
		Scanner s = new Scanner(System.in);
		
		String menu = "";
		String nameInput = "";
		String balSender = "";
		String balReceiver = "";
		
		int balanceInput;
		int withdrawInput;
		int sendingInput;
		
		// Scanner : 입력받는 Menu 생성
		while(true){
			System.out.println("=== 은행시스템입니다. ===");
			System.out.println("1. 입금업무");
			System.out.println("2. 출금업무");
			System.out.println("3. 이체업무");
			System.out.println("4. 종료");
			System.out.print("메뉴를 입력해 주세요: ");
			menu = s.nextLine();
			
			// 1. 입금업무
			if( menu.equals("1") ){
				System.out.print("입금할 사람의 이름을 입력하세요: ");
				nameInput = s.nextLine();
				BankService service = new BankService();
				boolean nameExist = service.findPersonByName(nameInput);
				
				// 이름이 DB상에 존재할 때
				if(nameExist){
					System.out.print("입금할 금액을 입력하세요: ");
					balanceInput = s.nextInt();
					s.nextLine();
					boolean depositResult = service.deposit(nameInput, balanceInput);
					if(depositResult){
						System.out.println("정상적으로 입금되었습니다.\n");
					} else{
						System.out.println("입금에서 오류가 발생되었습니다.");
						System.out.println("메뉴 화면으로 돌아갑니다. \n");
					}
					continue;
				}
				// 이름이 DB상에 존재하지 않을 때
				else{					
					// 오류
					System.out.println("이름이 디비상에 없음.");
					System.out.println("메뉴 화면으로 돌아갑니다. \n");
					continue;
				}
				
				
			}
			// 2. 출금업무
			else if( menu.equals("2") ){
				System.out.print("출금할 사람의 이름을 입력하세요: ");
				nameInput = s.nextLine();
				BankService service = new BankService();
				boolean nameExist = service.findPersonByName(nameInput);
				
				// 이름이 DB상에 존재할 때
				if(nameExist){
					System.out.print("출금할 금액을 입력하세요: ");
					withdrawInput = s.nextInt();
					s.nextLine();
					boolean withdrawResult = service.withdraw(nameInput, withdrawInput);
					if(withdrawResult){
						System.out.println("정상적으로 출금되었습니다.\n");
					} else{
						System.out.println("출금에서 오류가 발생되었습니다.");
						System.out.println("메뉴 화면으로 돌아갑니다. \n");
					}
					continue;
				}
				// 이름이 DB상에 존재하지 않을 때
				else{					
					// 오류
					System.out.println("이름이 디비상에 없음.");
					System.out.println("메뉴 화면으로 돌아갑니다. \n");
					continue;
				}
			}
			// 3. 이체업무
			else if( menu.equals("3") ){
				System.out.print("이름을 입력해주세요: ");
				balSender = s.nextLine();
				BankService service = new BankService();
				boolean senderNameExist = service.findPersonByName(balSender);
				// 보내는 사람의 이름이 DB에 존재할 때
				if(senderNameExist){
					System.out.print("이체를 실행할 사람의 이름을 입력해주세요: ");
					balReceiver = s.nextLine();
					boolean receiverNameExist = service.findPersonByName(balReceiver);
					// 받는 사람의 이름이 DB에 존재할 때
					if(receiverNameExist){
						System.out.println("***"+balSender+"님이 "+balReceiver+"님에게 이체를 실행합니다.***");
						System.out.print("이체할 금액을 입력하세요: ");
						sendingInput = s.nextInt();
						s.nextLine();
						boolean sendingResult = service.sending(balSender, balReceiver, sendingInput);
						if(sendingResult){
							System.out.println("정상적으로 이체되었습니다.\n");
						} else{
							System.out.println("출금에서 오류가 발생되었습니다.");
							System.out.println("메뉴 화면으로 돌아갑니다. \n");
						}
						continue;
					}
					// 받는 사람의 이름이 DB에 존재하지 않을 때
					else{
						System.out.println("이름이 디비상에 없음. 오류코드2");
						System.out.println("메뉴 화면으로 돌아갑니다. \n");
						continue;
					}
				}
				// 보내는 사람의 이름이 DB에 존재하지 않을 때
				else{
					System.out.println("이름이 디비상에 없음. 오류코드1");
					System.out.println("메뉴 화면으로 돌아갑니다. \n");
					continue;
				}
				
			}
			// 4. 프로그램 종료
			else if( menu.equals("4")){
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			else{
				// 잘못선택
				System.out.println("잘못 선택하셨습니다. 메뉴로 돌아갑니다. \n");
				continue;
			}
			
		}
	}
	
	
	
	
}
