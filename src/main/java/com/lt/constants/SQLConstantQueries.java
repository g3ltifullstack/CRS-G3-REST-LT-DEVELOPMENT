package com.lt.constants;



public class SQLConstantQueries {
	public static final String VALIDATE_USER="SELECT userid, roleid FROM user WHERE username=? AND userpassword=?";
	public static final String FETCH_STUDENT="SELECT studentid,studentname,gender,phonenumber,semester,branch FROM student WHERE userid=?";
	public static final String VIEW_SELECT_USER="SELECT userid FROM user WHERE username=?";
	public static final String VIEW_SELECT_STUDENT1="SELECT semester,branch FROM student WHERE userid=?";
	
	public static final String DISPLAY_COURSES= "SELECT * FROM course WHERE semester= ? AND branch =?";
	public static final String ADD_COURSE="INSERT INTO register_course VALUES (?,?,false,CURRENT_TIMESTAMP)";
	public static final String DROP_COURSE="DELETE FROM register_course WHERE studentid=? AND courseid=?" ;
	public static final String VIEW_SELECTED_COURSES="SELECT course.courseid, course.coursename, course.coursedescription,  register_course.timestamp\r\n" + 
			"FROM course \r\n" + "INNER JOIN register_course \r\n" + "ON register_course.courseid = course.courseid\r\n" + "WHERE register_course.studentid= ?";
	public static final String INSERT_USER="INSERT INTO user(username,userpassword,roleid,isapproved) VALUES(?,?,?,?)";
	public static final String INSERT_STUDENT="INSERT INTO student(studentname,gender,phonenumber,semester,branch,userid) VALUES(?,?,?,?,?,?)";
	public static final String NUMBER_OF_COURSES_SELECTED="SELECT count(CourseID) FROM register_course WHERE studentid=?";
    public static final String UPDATE_REGISTARTION_STATUS="UPDATE student SET StudentRegistrationStatus= true WHERE studentid=?";
	public static final String REGISTRATION_OF_COURSES= "UPDATE register_course SET CourseRegistrationStatus=1 WHERE studentid=?";
	public static final String UPDATE_ENROLLED_STUDENTS_NUMBER="UPDATE course_inventory SET NumberOfStudentsEnrolled = NumberOfStudentsEnrolled +1 WHERE courseid IN (SELECT courseid FROM register_course WHERE studentid=? AND courseregistrationstatus= true)";
    public static final String SUBMIT_REGISTRATION_DETAILS="INSERT INTO registration VALUES (?,?,?,?,CURRENT_TIMESTAMP)";
	public static final String SHOW_REGISTRATION_RECIEPT= "SELECT * FROM registration WHERE studentid=?";
	public static final String VIEW_ENROLLED_STUDENT_ID="SELECT studentid FROM register_course WHERE courseid=? AND courseregistrationstatus=1";
	public final static String PAYMNT_UPDATE="INSERT INTO payment(amount,paymentstatus,paymentmode,cardnumber,cardpin,studentname,paymentremark) VALUES (?,?,?,?,?,?,?)";
	public final static String PAYMENT_RECEPT="select paymentid,amount,paymentstatus,studentname,paymentmode from payment where studentname=?";
	//Professor Operation query
	public final static String  GRADE_UPLOAD="INSERT INTO GRADE(courseid,studentid,grade) VALUES (?,?,?)";
	public final static String SELECT_STUDENT_PROF="select studentid,studentname,gender,semester,branch,phonenumber from student";
    public final static String SELECT_STUDENT_BY_NAME="select studentid,studentname,gender,semester,branch,phonenumber from student where studentname=?";
}
