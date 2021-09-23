package com.lt.bean;

public class Professor extends User{
	
	private int professorId;
	private String professorName;
	private String department;
	private String email;
	private String gender;
	private String password;
	private String role;
	
	
	public Professor(int i, String string, String string2, String string3, String string4, String string5) {
	}
			 
	
	
	
	public Professor(int professorId, String professorName, String department, String email, String gender,
			String password, String role) {
		super();
		this.professorId = professorId;
		this.professorName = professorName;
		this.department = department;
		this.email = email;
		this.gender = gender;
		this.password = password;
		this.role = role;
	}


	public Professor() {
		// TODO Auto-generated constructor stub
	}




	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getProfessorId() {
		return professorId;
	}
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	@Override
	public String toString() {
		return "Professor [professorId=" + professorId + ", professorName=" + professorName + ", department="
				+ department + ", email=" + email + ", gender=" + gender + ", password=" + password + ", role=" + role
				+ "]";
	}

	
	
	
	

}
