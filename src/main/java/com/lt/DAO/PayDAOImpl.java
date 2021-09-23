package com.lt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import org.apache.log4j.Logger;

import com.lt.bean.Payment;
import com.lt.bean.Student;
import com.lt.business.UserImplService;
import com.lt.constants.CommonData;
import com.lt.constants.SQLConstantQueries;
import com.lt.utils.DBUtil;

public class PayDAOImpl implements PayDAOInterface{
//	private static Logger logger = Logger.getLogger(PayDaoImpl.class);
	

	@Override
	public List<Payment> viewreceipt(String  name) {
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;
		 List <Payment> payreceipt=new ArrayList<Payment>();
		try {
			//paymentid,amount,paymntstatus,s tudentname,paymntmode
			//Declaring prepared statement
			stmt=connection.prepareStatement(SQLConstantQueries.PAYMENT_RECEPT);
		    //liststd.add(getInt(1, studentid));
			stmt.setString(1,name);
			
			ResultSet rs = stmt.executeQuery();
			System.out.println("rs executed"+ rs);
			
			while(rs.next()) {
				Payment payment =new Payment();
				payment.setPaymentId( rs.getInt("paymentid"));
				payment.setAmount( rs.getInt("amount"));
				payment.setPaymentstatus( rs.getString("paymentstatus"));
				payment.setStudentname( rs.getString("studentname"));
				payment.setPaymentmode( rs.getInt("paymentmode"));
				
				payreceipt.add( payment);

			}
			

		} catch (SQLException ex) {
//			logger.error(ex.getMessage());
		}
//		
		
		return payreceipt;
	}
		
		
	

	
	@Override
	public void payBill(String name, Payment payment) {
		
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;
		
		try {
           
			//Declaring prepared statement
			stmt=connection.prepareStatement(SQLConstantQueries.PAYMNT_UPDATE);
			
			stmt.setDouble(1,payment.getAmount());
			stmt.setString(2, "done");
			stmt.setInt(3,payment.getPaymentmode());
			stmt.setString(4,payment.getCardnumber());
			stmt.setInt(5,payment.getPaymentpin());
			stmt.setString(6,name);
			stmt.setString(7,payment.getPaymentremark());
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
			   System.out.println(rs.getString(1));
			   System.out.println("Payment Done");
			}
			
			else
			{
				System.out.println("Payment not done !");
			}

			

			

		} catch (SQLException ex) {
//			logger.error(ex.getMessage());
		}
//		
		
	}
		
	}
