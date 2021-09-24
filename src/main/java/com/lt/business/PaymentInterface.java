package com.lt.business;

import java.util.List;

import com.lt.bean.Payment;
import com.lt.bean.Student;

public interface PaymentInterface {
	public boolean  payment(Payment paymnt);
	public List<Payment> viewreceipt(Student student);
	

}