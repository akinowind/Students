package model;

import java.util.Date;

public class Students {
	
	private String sid;
	private String sname;
	private String gender;
	private Date birth;
	private String address;
	public Students(){
		
	}
	
	public Students(String sid, String sname, String gender, Date birth,
			String address) {
		//super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.birth = birth;
		this.address = address;
	}

	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Students [address=" + address + ", birth=" + birth
				+ ", gender=" + gender + ", sid=" + sid + ", sname=" + sname
				+ "]";
	}
	
}
