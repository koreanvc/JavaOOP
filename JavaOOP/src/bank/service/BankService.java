package bank.service;

import java.util.ArrayList;

import bank.dao.BankDAO;
import bank.dto.BankDTO;
import booksearch_MVCpattern.dto.BookDTO;

public class BankService {
	
	public boolean findPersonByName(String name){
		
		BankDAO dao = new BankDAO();		
		return dao.select(name);
	}

	public boolean deposit(String nameInput, int balanceInput) {
		
		BankDAO dao = new BankDAO();		
		return dao.depositData(nameInput ,balanceInput);
		
	}

	public boolean withdraw(String nameInput, int withdrawInput) {
		
		BankDAO dao = new BankDAO();		
		return dao.withdrawData(nameInput, withdrawInput);
	}

	public boolean sending(String balSender, String balReceiver, int sendingInput) {
		
		BankDAO dao = new BankDAO();
		return dao.sendingData(balSender, balReceiver, sendingInput);
	}
	

}
