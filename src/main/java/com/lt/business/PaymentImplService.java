package com.lt.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

//import org.apache.log4j.Logger;

import com.lt.DAO.PayDAOImpl;
import com.lt.DAO.PayDAOInterface;
import com.lt.bean.Payment;
import com.lt.bean.Student;
@Service
public class PaymentImplService implements PaymentInterface {

	private static Logger logger = Logger.getLogger(PaymentImplService.class);
	
	Scanner sc=new Scanner(System.in);
	//iniitiate payment when student provide name by student class rest details taken fro here
	@Override

	public boolean payment(Payment paymnt) {
	
		
		
		logger.debug("setting valuse in object");
		
		
		PayDAOInterface paydao=new PayDAOImpl();
		logger.debug("going to payment");
		paydao.payBill(paymnt);
		logger.debug("going to payment");
	
		return false;
	}


	@Override
	public List<Payment> viewreceipt(Student student) {
		List <Payment> receipt=new ArrayList();
		PayDAOInterface paydao=new PayDAOImpl();
		receipt= paydao.viewreceipt(student.getName());
//		for (Payment payment : receipt) {
//			logger.info("payment id="+payment.getPaymentId()+"student name="+payment.getStudentname()+" amount="
//					+payment.getAmount()+" payment status"+payment.getPaymentstatus()+" payment mode ="+payment.getPaymentmode());
		return receipt;
			
		}
		
	}
	
	