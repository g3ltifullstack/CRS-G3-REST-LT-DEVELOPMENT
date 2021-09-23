package com.lt.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

//import org.apache.log4j.Logger;

import com.lt.DAO.PayDAOImpl;
import com.lt.DAO.PayDAOInterface;
import com.lt.bean.Payment;
import com.lt.bean.Student;

public class PaymentImplService implements PaymentInterface {

	private static Logger logger = Logger.getLogger(PaymentImplService.class);
	
	Scanner sc=new Scanner(System.in);
	//iniitiate payment when student provide name by student class rest details taken fro here
	@Override
	public boolean payment(Student student) {
		Payment paymnt=new Payment();
		logger.debug("inter paymnt details");
	    logger.debug(" enter amount--> enter only numeric value");
		int amount=sc.nextInt();
		logger.debug(" paymnt mode -->101 for debit card ---> 102 for credit card");
		int paymntmode=sc.nextInt();
		logger.debug("enter card number -->card number should be 16 degit");
		String cardnumber=sc.next();
		logger.debug("enter card pin ");
		int paymntpin=sc.nextInt();
		logger.debug("enter paymnt remark");
		String paymntremark=sc.next();
		
		logger.debug("setting valuse in object");
		paymnt.setAmount(amount);
		paymnt.setPaymentmode(paymntmode);
		paymnt.setCardnumber(cardnumber);
		paymnt.setPaymentpin(paymntpin);
		paymnt.setPaymentremark(paymntremark);
		
		PayDAOInterface paydao=new PayDAOImpl();
		logger.debug("going to payment");
		paydao.payBill(student.getName(),paymnt);
		logger.debug("going to payment");
	
		return false;
	}


	@Override
	public void viewreceipt(Student student) {
		List <Payment> receipt=new ArrayList();
		PayDAOInterface paydao=new PayDAOImpl();
		receipt= paydao.viewreceipt(student.getName());
		for (Payment payment : receipt) {
			logger.info("payment id="+payment.getPaymentId()+"student name="+payment.getStudentname()+" amount="
					+payment.getAmount()+" payment status"+payment.getPaymentstatus()+" payment mode ="+payment.getPaymentmode());
			
		}
		
	}
	
	
	

}