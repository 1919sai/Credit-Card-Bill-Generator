package com.ccbg.entity;
import com.ccbg.exception.*;
import java.util.Date;
public class CreditCardBill {
	private String creditCardNo;
	private String customerId;
	private Date billDate;
	private Transaction monthTransactions[];
	public CreditCardBill (){
		
	}
	public CreditCardBill (String creditCardNo, String customerId, Date BillDate, Transaction monthTransactions[]){
		this.creditCardNo=creditCardNo;
		this.customerId=customerId;
		this.billDate=BillDate;
		this.monthTransactions=monthTransactions;
	}
	public double getTotalAmount(String transactionType){
		double amount=0;
		for(int i=0;i<monthTransactions.length;i++){
			Transaction t=monthTransactions[i];
			if(t.getTransactionType().equals(transactionType)){
				amount=amount+t.getTransactionAmount();
			}
		}
		return amount;
		
	}
	public double calculateBillAmount(){
		try{
			String s=validateData();
			if(s.equals("valid")){
				if(monthTransactions.length!=0){
					double dbAmount=getTotalAmount("DB");
					double crAmount=getTotalAmount("CR");
					double billAmount=dbAmount-crAmount;
					double total=billAmount+((billAmount*19.9/100)/12);
					return total;
				}
				else{
					return 0.0;
				}
			}
		}catch (InvalidInputException e) {
			// TODO: handle exception
			return 0.0;
		}
		return 0.0;
		
	}
	public String validateData() throws InvalidInputException{
		if(((creditCardNo.isEmpty()))||((creditCardNo.length()!=16))||((customerId.isEmpty()))||((customerId.length()<6))){
			throw new InvalidInputException();
		}
		return "valid";
	}


}
