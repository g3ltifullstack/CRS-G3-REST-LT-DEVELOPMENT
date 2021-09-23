package com.lt.business;

import java.sql.SQLException;

import com.lt.constants.NotificationType;
import com.lt.constants.PaymentMode;

public interface NotificationInterface {
	/**
	 * Send Notification using SQL commands
	 * @param type: type of the notification to be sent
	 * @param studentId: student to be notified
	 * @param modeOfPayment: mode of payment used, defined in enum
	 * @param amount
	 * @return notification id for the record added in the database
	 * @throws SQLException
	 */
	public int sendNotification(NotificationType type,int studentId,PaymentMode paymentMode,double amount) throws SQLException;

}
