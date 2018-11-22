package com.ccbg.main;
import com.ccbg.entity.*;
import java.text.*;
public class MainClass {

	public static void main(String args[]){
		try{
			Transaction monthTransaction[]=new Transaction[5];
			SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
			monthTransaction[0]=new Transaction("1111222233334444",formatter.parse("01/02/2016"),"household",8000.0,"DB");
		    monthTransaction[1]=new Transaction("1111222233334444",formatter.parse("05/02/2016"),"Textile",12000.0,"DB");
		    monthTransaction[2]=new Transaction("1111222233334444",formatter.parse("12/02/2016"),"movie",2700.0,"DB");
		    monthTransaction[3]=new Transaction("1111222233334444",formatter.parse("16/02/2016"),"paid",19000.0,"CR");
		    monthTransaction[4]=new Transaction("1111222233334444",formatter.parse("19/02/2016"),"household",4500.0,"DB");
		    CreditCardBill ccbill = new CreditCardBill("1111222233334444","ABC123",formatter.parse("02/03/2016"),monthTransaction);
		    System.out.println("Total to be paid : "+ccbill.calculateBillAmount());
		 }
		catch(Exception ex){
			System.out.println(0.0);
		}
	}
}
