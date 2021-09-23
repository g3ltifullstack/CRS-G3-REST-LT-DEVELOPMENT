package com.lt.business;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.lt.DAO.NotificationDAOImpl;
import com.lt.DAO.NotificationDAOInterface;
import com.lt.constants.NotificationType;
import com.lt.constants.PaymentMode;

public class NotificationImplService implements NotificationInterface {
	private static Logger logger = Logger.getLogger(NotificationImplService.class);
	NotificationDAOInterface notificationDao = new NotificationDAOImpl();

	/**
	 * Method to send notification
	 * 
	 * @param type:          type of the notification to be sent
	 * @param studentId:     student to be notified
	 * @param modeOfPayment: payment mode used
	 * @return notification id for the record added in the database
	 */
	@Override
	public int sendNotification(NotificationType type, int studentId, PaymentMode modeOfPayment, double amount) {
		int notificationId = 0;
		try {

			notificationId = notificationDao.sendNotification(type, studentId, modeOfPayment, amount);

		} catch (SQLException ex) {
			logger.error("Error occured " + ex.getMessage());
		}
		return notificationId;
	}
}
