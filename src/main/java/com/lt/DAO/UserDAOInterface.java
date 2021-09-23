package com.lt.DAO;

import java.util.List;

import com.lt.bean.Admin;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;


public interface UserDAOInterface {

    public User validateUser(String username, String pass);
	 public Student fetchStudent(int studentId);
	 public Admin fetchAdmin(int adminId);
	 public Professor fetchProfessor(int professorId);
	 public User createUser(User user);
	 public void createStudent(Student student) ;
	 public void createProfessor(Professor professor);
	 public void createAdmin(Admin admin);
	 public List<Student> displayStudents();
	 public List<Professor> displayProfessors();
	 public List<Admin> displayAdmins();
	 //check delete user 
}
