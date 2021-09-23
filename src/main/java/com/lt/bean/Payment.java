package com.lt.bean;

public class Payment {
	private int paymentId;
	private double amount;
	private String Paymentstatus;
	private String Studentname;
	private int Paymentmode;
	private String cardnumber;
	private int paymentpin;
	private String paymentremark;
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public int getPaymentpin() {
		return paymentpin;
	}
	public void setPaymentpin(int paymentpin) {
		this.paymentpin = paymentpin;
	}
	public String getPaymentremark() {
		return paymentremark;
	}
	public void setPaymentremark(String paymentremark) {
		this.paymentremark = paymentremark;
	}
	public String getPaymentstatus() {
		return Paymentstatus;
	}
	public void setPaymentstatus(String paymentstatus) {
		Paymentstatus = paymentstatus;
	}
	public String getStudentname() {
		return Studentname;
	}
	public void setStudentname(String studentname) {
		Studentname = studentname;
	}
	public int getPaymentmode() {
		return Paymentmode;
	}
	public void setPaymentmode(int paymentmode) {
		Paymentmode = paymentmode;
	}
	//type of payment details of debit card, online credit and check with enum 16 digit card number logic IMP
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	

}
