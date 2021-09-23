package com.lt.business;

import java.util.List;

import com.lt.bean.Payment;
import com.lt.bean.Student;

public interface PaymentInterface {
	public boolean  payment(Student student);
	public void viewreceipt(Student student);
	

}