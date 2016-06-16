package model;

import java.util.Date;

public class Teachers {
	private String tid;
	private String tname;
	private String gender;
	private Date birth;
	private String address;
	
	
	public Teachers(){
		
	}
	
	public Teachers(String tid, String tname, String upasswd,String gender, Date birth,
			String address) {
		//super();
		this.tid = tid;
		this.tname = tname;
		this.gender = gender;
		this.birth = birth;
		this.address = address;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
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

	
	
	
	
	
}
