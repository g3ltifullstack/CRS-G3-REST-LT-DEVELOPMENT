package com.lt.DAO;

import java.util.List;

import com.lt.bean.Payment;

public interface PayDAOInterface {

	public List<Payment> viewreceipt(String name);
	public void payBill(String name, Payment payment);
	
}
