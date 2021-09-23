package com.lt.bean;

/**
 * @author Hp
 *
 */
public class Admin extends User {
	private int adminId;
	private String name;
	private String gender;
	private long phoneNumber;
	private int userid;

	/**
	 * @return user id
	 */
	public int getUserid() { 
		return userid;
	}

	/**
	 * @param userid
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}

	/**
	 * @return admin id
	 */
	public int getAdminId() {
		return adminId;
	}

	/**
	 * @param adminId
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return phone number
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @param adminId
	 * @param name
	 * @param gender
	 * @param phoneNumber
	 * @param userid
	 */
	public Admin(int adminId, String name, String gender, long phoneNumber, int userid) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.userid = userid;
	}

	/**
	 * default constructor
	 */
	public Admin() {
		super();
	}

	/**
	 *Displaying adminId, name , gender, phone number,user id
	 */
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", gender=" + gender + ", phoneNumber=" + phoneNumber
				+ ", userid=" + userid + "]";
	}

}
