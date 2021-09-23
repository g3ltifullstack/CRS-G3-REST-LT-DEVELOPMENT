package com.lt.DAO;

import java.sql.SQLException;

import com.lt.constants.NotificationType;
import com.lt.constants.PaymentMode;

public interface NotificationDAOInterface {
	/**
	 * 
	 * @param type: type of the notification to be sent
	 * @param studentId: student to be notified
	 * @return notification id for the record added in the database
	 */
	public int sendNotification(NotificationType type,int studentId,PaymentMode paymentMode,double amount) throws SQLException;

}
